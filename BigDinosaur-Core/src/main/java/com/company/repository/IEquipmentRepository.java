package com.company.repository;

import com.company.model.Equipment;
import com.company.repository.custom.IEquipmentRepositoryCustom;

/**
 * @author Santosh
 *
 */
public interface IEquipmentRepository extends IAbstractRepository<Equipment>, IEquipmentRepositoryCustom{

}
