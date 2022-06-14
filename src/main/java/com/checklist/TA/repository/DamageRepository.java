package com.checklist.TA.repository;

import com.checklist.TA.bo.Damage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageRepository extends JpaRepository<Damage,Long> {
    @Query(value = "select * from damages where equipement_id= :id",nativeQuery = true)
    List<Damage> FindDamageTypeByEquipmentID(@Param("id") Long idEquipment);

    @Query(value = "SELECT * FROM `damages` WHERE `equipement_id`=:equipement_id AND `damage_type_id` = :damage_type_id",nativeQuery = true)
    List<Damage> FindDamageTypeByEquipmentIDandDamage_type_id(@Param("equipement_id") Long equipement_id,@Param("damage_type_id") Long damage_type_id);
    @Query(value = "select id,name from damages d",nativeQuery = true)
    List<Long> GetAllDamages();
}
