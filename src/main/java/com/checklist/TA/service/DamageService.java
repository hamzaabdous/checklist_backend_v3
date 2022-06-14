package com.checklist.TA.service;

import com.checklist.TA.bo.Damage;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DamageService {
    public Optional<Damage> damageSave (Damage damage);
    public List<Damage> damageSaveList (List<Damage>damages);

    public List<Damage> findAll();
    public Optional<Damage>  DeleteId(Damage damage);
    public Optional<Damage>  UpdateDamage(Damage damage);
    public long countDamages();
    public List<Damage> FindDamageTypeByEquipmentID( Long idEquipment);
    public List<Damage> FindDamageTypeByEquipmentIDandDamage_type_id( Long equipement_id,Long damage_type_id);
    public  List<Long> GetAllDamages();

}
