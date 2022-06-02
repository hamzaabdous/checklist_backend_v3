package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name="equipments")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;


    @Column(name="description")
    private String description;

    @JsonIgnoreProperties("equipementList")
    @ManyToOne
    private ProfileGroup profileGroup;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;
}
