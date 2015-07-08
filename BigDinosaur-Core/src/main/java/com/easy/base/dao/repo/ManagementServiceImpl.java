package com.easy.base.dao.repo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;












@Service
public class ManagementServiceImpl implements ManagementService {
    @Autowired
    private ManagementRepository managementRepository;

    @Override
    public BaseJmx Register(BaseJmx management) throws Exception{
	
	try{
	    
	return managementRepository.save(management);
	}
	 catch (Exception e) {
	     throw new Exception();
		}
	
    }
}
