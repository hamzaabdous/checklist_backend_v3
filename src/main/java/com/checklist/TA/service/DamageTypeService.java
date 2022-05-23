package com.checklist.TA.service;

import com.checklist.TA.bo.DamageType;

import java.util.List;
import java.util.Optional;

public interface DamageTypeService {
    public Optional<DamageType> damageTypeSave (DamageType damageType);
    public List<DamageType> findAll();
    public Optional<DamageType>  DeleteId(DamageType damageType);
    public Optional<DamageType>  UpdateDamageType(DamageType damageType);
    public long countDamageTypes();
}
