package com.checklist.TA.vo;

import com.checklist.TA.bo.Damage;
import com.checklist.TA.bo.Department;
import com.checklist.TA.bo.ProfileGroup;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

public class damageTypesVo {

    private Long id;

    private String name;

    private ProfileGroup profileGroup;

    private Department department;

    private List<Damage> damages;

    private Date createdDate;

    private Date updateDate;


    public damageTypesVo(Long id, String name, ProfileGroup profileGroup, Department department, List<Damage> damages, Date createdDate, Date updateDate) {
        this.id = id;
        this.name = name;
        this.profileGroup = profileGroup;
        this.department = department;
        this.damages = damages;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProfileGroup getProfileGroup() {
        return profileGroup;
    }

    public void setProfileGroup(ProfileGroup profileGroup) {
        this.profileGroup = profileGroup;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<Damage> getDamages() {
        return damages;
    }

    public void setDamages(List<Damage> damages) {
        this.damages = damages;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
