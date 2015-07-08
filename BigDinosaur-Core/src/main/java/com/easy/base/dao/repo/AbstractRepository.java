package com.easy.base.dao.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public abstract interface AbstractRepository<T extends BaseJmx> extends JpaRepository<T, Long> {

}
