package com.checklist.TA.vo;

import com.checklist.TA.bo.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class damage_damagetype {

    private long damage_id;

    private String damage_name;

    private String damage_status;

    private User damage_userDeclaration;

    private User damage_userResolution;

    private User damage_userClosed;

    private String damage_description;

    private Date damage_createdDate;

    private Date damage_updateDate;

    private Equipment damage_equipement;

    private DamageType damage_damageType;

    // damage type

    private Long damagetype_id;

    private String damagetype_name;

    private ProfileGroup damagetype_profileGroup;

    private Department damagetype_department;

    private Date damagetype_createdDate;

    private Date damagetype_updateDate;
}
