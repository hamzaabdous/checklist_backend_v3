package com.checklist.TA.service.umpl;

import com.checklist.TA.bo.DamageType;
import com.checklist.TA.repository.DamageTypeRepository;
import com.checklist.TA.service.DamageTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class DamageTypeServiceUmpl implements DamageTypeService {
    @Autowired
    private DamageTypeRepository damageTypeRepository;

    @Override
    public Optional<DamageType> damageTypeSave(DamageType damageType) {
        Date currentDate = new Date();
        damageType.setCreatedDate(currentDate);
        return Optional.ofNullable(damageTypeRepository.save(damageType));
    }

    @Override
    public List<DamageType> findAll() {
        return damageTypeRepository.findAll();
    }

    @Override
    public List<DamageType> getDamage_typesByProfile_group_id(Long id) {
        return damageTypeRepository.getDamage_typesByProfile_group_id(id);
    }
    @Override
    public List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentIN(Long profile_group_id, Long department_id, Long equipement_id) {

        return damageTypeRepository.getAllByProfileGroupAndAndDepartmentAndEquipmentIN(profile_group_id,department_id,equipement_id);
    }

    @Override
    public List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(Long profile_group_id, Long department_id, Long equipement_id) {
        return damageTypeRepository.getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(profile_group_id,department_id,equipement_id);
    }

    @Override
    public Optional<DamageType> DeleteId(DamageType damageType) {
        damageTypeRepository.deleteById(damageType.getId());
        return Optional.ofNullable(damageType);
    }

    @Override
    public Optional<DamageType> UpdateDamageType(DamageType damageType) {
        Date currentDate = new Date();
        damageType.setUpdateDate(currentDate);
        return Optional.ofNullable(damageTypeRepository.save(damageType));
    }

    @Override
    public long countDamageTypes() {
        return damageTypeRepository.count();
    }
}
