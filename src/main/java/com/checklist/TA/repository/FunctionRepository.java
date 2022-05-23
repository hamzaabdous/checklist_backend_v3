package com.checklist.TA.repository;

import com.checklist.TA.bo.Function;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FunctionRepository extends JpaRepository<Function,Long> {
}
