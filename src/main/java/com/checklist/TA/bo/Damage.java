package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="damages")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="status")
    private String status;

   @JsonIgnoreProperties("damageDeclaration")
    @ManyToOne
    private User userDeclaration;


   @JsonIgnoreProperties("damageUserResolution")
    @ManyToOne
    private User userResolution;

    @JsonIgnoreProperties("damageUserClosed")
    @ManyToOne
    private User userClosed;

    @Column(name="description")
    private String description;


    @Column(name="created_date")
    private Date createdDate;

    @Column(name="update_date")
    private Date updateDate;

   @JsonIgnoreProperties("damage")
    @OneToOne
    @JoinColumn(name="equipement_id")
    private Equipment equipement;

    @JsonIgnoreProperties("damages")
    //@JsonManagedReference
    @ManyToOne
    private DamageType damageType;

    @OneToMany(mappedBy = "damage",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnoreProperties("damage")
    private List<Picture> pictures;
}
