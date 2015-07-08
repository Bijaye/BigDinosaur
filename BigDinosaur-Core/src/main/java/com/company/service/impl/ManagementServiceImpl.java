package com.company.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.BaseJmx;
import com.company.repository.IManagementRepository;
import com.company.service.IManagementService;

@Service
public class ManagementServiceImpl implements IManagementService {
	@Autowired
	private IManagementRepository managementRepository;

	@Override
	public BaseJmx Register(BaseJmx management) throws Exception {

		try {

			return managementRepository.save(management);
		} catch (Exception e) {
			throw new Exception();
		}

	}
}
