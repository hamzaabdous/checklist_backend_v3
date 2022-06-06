package com.checklist.TA.repository;

import com.checklist.TA.bo.Picture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PictureRepository extends JpaRepository<Picture,Long> {
    Optional<Picture> findByName(String name);

}
