package com.company.repository.custom.impl;

import java.util.List;

import org.springframework.data.domain.Pageable;

import com.company.model.Equipment;
import com.company.model.QEquipment;
import com.company.repository.AbstractCustomRepository;
import com.company.repository.custom.IEquipmentRepositoryCustom;

/**
 * @author Santosh
 * 
 */
public class IEquipmentRepositoryImpl extends AbstractCustomRepository
		implements IEquipmentRepositoryCustom {

	private QEquipment qEquipment = QEquipment.equipment;

	@Override
	public List<Equipment> findAllCategory(Pageable pageable, String category) {
		return pageableQuery(pageable).from(qEquipment)
				.where(qEquipment.category.eq(category)).list(qEquipment);
	}

}
