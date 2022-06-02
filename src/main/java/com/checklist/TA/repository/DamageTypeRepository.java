package com.checklist.TA.repository;

import com.checklist.TA.bo.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DamageTypeRepository extends JpaRepository<DamageType,Long> {
    @Query(value = "SELECT * FROM `damage_types` WHERE `profile_group_id`=:id ",nativeQuery = true)
    List<DamageType> getDamage_typesByProfile_group_id(@Param("id") Long profile_group_id);
}
