package com.checklist.TA.repository;

import com.checklist.TA.bo.DamageType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DamageTypeRepository extends JpaRepository<DamageType,Long> {
}
