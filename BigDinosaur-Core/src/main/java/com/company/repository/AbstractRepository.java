package com.company.repository;




import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.model.BaseJmx;

@Repository
public abstract interface AbstractRepository<T extends BaseJmx> extends JpaRepository<T, Long> {

}
