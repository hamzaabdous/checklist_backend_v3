package com.checklist.TA.repository;

import com.checklist.TA.bo.ProfileGroup;
import com.checklist.TA.bo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileGroupRepository extends JpaRepository<ProfileGroup,Long> {

}
