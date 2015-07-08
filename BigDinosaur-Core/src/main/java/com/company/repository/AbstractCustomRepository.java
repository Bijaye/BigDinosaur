package com.company.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.mysema.query.jpa.JPQLQuery;
import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.path.StringPath;



/**
 * <<This is a Abstract Class (Utility Class) for writing  custom queries >>
 * @author Kamal Giri 
 * @version 1.0
 * @since 1.0.0
 */
public abstract class AbstractCustomRepository {
	@PersistenceContext
	protected EntityManager em;

	protected EntityManager getEntityManager() {
		return em;
	}

	/**
	 *<<This is a utility method for writing queries.It is not responsible for automatically sorting & paging. >>
	 * @return This method returns JPQLQuery
	 * @author  Kamal Giri
	 * @since 1.0.0   ,Modified In: @version,By @author
	 */
	public JPQLQuery getQuery() {
		return new JPAQuery(em);
	}

	
	
	/**
	 *<<This is a utility method for querying customizable queries. It  automatically applies pagination & sorting. >>
	 * @param This method takes Pageable as a parameter.
	 * @return This method returns JPQLQuery.
	 * @author  Kamal Giri
	 * @since  1.0.0  ,Modified In: @version,By @author
	 */
	public JPQLQuery pageableQuery(Pageable pageable) {
		return applyPaginationAndSorting(pageable, getQuery());
	}
	

	/**
	 *<<This is a helper method for applying pagination & sorting.>>
	 * @param This method takes Pageable as a parameter.
	 * @param This method takes JPQLQuery as a parameter.
	 * @return This method returns JPQLQuery.
	 * @author  Kamal Giri
	 * @since  1.0.0  ,Modified In: @version,By @author
	 */
	public JPQLQuery applyPaginationAndSorting(Pageable pageable, JPQLQuery query) {

		if (null == pageable) {
			return query;
		}

		query.offset(pageable.getOffset());
		query.limit(pageable.getPageSize());

		return applySorting(pageable.getSort(), query);
	}

	/**
	 *<<This is a helper method for sorting.>>
	 * @param This method takes Sort as a parameter.
	 * @param This method takes JPQLQuery as a parameter.
	 * @return This method returns JPQLQuery.
	 * @author  Kamal Giri
	 * @since 1.0.0   ,Modified In: @version,By @author
	 */
	public JPQLQuery applySorting(Sort sort, JPQLQuery query) {

		if (null == sort) {
			return query;
		}

		for (Order order : sort) {

			query.orderBy(toOrder(order));
		}

		return query;
	}

	/**
	 *<<This is a helper method to set orderBy  parameters.>>
	 * @param This method takes Order as a parameter.
	 * @return This method returns OrderSpecifier.
	 * @author  Kamal Giri
	 * @since 1.0.0   ,Modified In: @version ,By @author
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	private OrderSpecifier<?> toOrder(Order order) {
		return new OrderSpecifier(order.isAscending() ? com.mysema.query.types.Order.ASC : com.mysema.query.types.Order.DESC,
				new StringPath(order.getProperty()));
	}

}
