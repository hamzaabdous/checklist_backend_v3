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
    @Query(value = "select id,name from damages d",nativeQuery = true)
    List<Long> GetAllDamages();
}
