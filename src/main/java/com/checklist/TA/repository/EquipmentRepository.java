package com.checklist.TA.repository;

import com.checklist.TA.bo.Equipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EquipmentRepository extends JpaRepository<Equipment,Long> {
}
