package com.checklist.TA.service;

import com.checklist.TA.bo.DamageType;

import java.util.List;
import java.util.Optional;

public interface DamageTypeService {
    public Optional<DamageType> damageTypeSave (DamageType damageType);
    public List<DamageType> findAll();
    public List<DamageType> getDamage_typesByProfile_group_id(Long id);

    List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentIN(Long profile_group_id, Long department_id, Long equipement_id);
    List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(Long profile_group_id, Long department_id, Long equipement_id);

    public Optional<DamageType>  DeleteId(DamageType damageType);
    public Optional<DamageType>  UpdateDamageType(DamageType damageType);
    public long countDamageTypes();
}
