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

    @Query(value = "SELECT * FROM `damage_types` WHERE `profile_group_id`= :profile_group_id  AND `department_id`=:department_id AND\n" +
            " id IN (SELECT `damage_type_id` FROM `damages` WHERE `equipement_id` = :equipement_id)",nativeQuery = true)
    List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentIN(@Param("profile_group_id") Long profile_group_id,@Param("department_id") Long department_id,@Param("equipement_id") Long equipement_id);

    @Query(value = "SELECT * FROM `damage_types` WHERE `profile_group_id`= :profile_group_id  AND `department_id`=:department_id AND\n" +
            " id NOT IN (SELECT `damage_type_id` FROM `damages` WHERE `equipement_id` = :equipement_id)",nativeQuery = true)
    List<DamageType> getAllByProfileGroupAndAndDepartmentAndEquipmentNOT(@Param("profile_group_id") Long profile_group_id,@Param("department_id") Long department_id,@Param("equipement_id") Long equipement_id);
}
