package com.easy.base.dao.repo;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;



@Entity
@Inheritance(strategy =  InheritanceType.JOINED)
public abstract class BaseJmx  {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	public Long getId() {
	    return id;
	}
	public void setId(Long id) {
	    this.id = id;
	}

}
