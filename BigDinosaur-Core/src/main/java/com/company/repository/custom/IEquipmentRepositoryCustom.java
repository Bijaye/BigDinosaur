package com.company.repository.custom;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.company.model.Equipment;

/**
 * @author Santosh
 *
 */
public interface IEquipmentRepositoryCustom {

	/**
	 * @param pageable
	 * @param category
	 * @return
	 */
	List<Equipment> findAllCategory(Pageable pageable, String category);
}
