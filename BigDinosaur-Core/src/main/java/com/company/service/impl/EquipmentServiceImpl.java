package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Equipment;
import com.company.repository.IEquipmentRepository;
import com.company.service.IEqipmentService;

/**
 * @author Santosh
 * 
 */
@Service
public class EquipmentServiceImpl implements IEqipmentService {

	@Autowired
	private IEquipmentRepository equipmentRepository;

	@Override
	public Equipment saveEquipment(Equipment equipment) {
		return this.equipmentRepository.saveAndFlush(equipment);
	}

}
