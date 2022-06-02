package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

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

  // @JsonIgnoreProperties("damageDeclaration")
    @JsonIgnoreProperties(value = {"damageDeclaration"}, allowSetters = true)
    @ManyToOne
    private User userDeclaration;


   //@JsonIgnoreProperties("damageUserResolution")
   @JsonIgnoreProperties(value = {"damageUserResolution"}, allowSetters = true)
    @ManyToOne
    private User userResolution;

   // @JsonIgnoreProperties("damageUserClosed")
    @JsonIgnoreProperties(value = {"damageUserClosed"}, allowSetters = true)
    @ManyToOne
    private User userClosed;

    @Column(name="description")
    private String description;


    @Column(name="created_date")
    private Date createdDate;

    @Column(name="update_date")
    private Date updateDate;

   //@JsonIgnoreProperties("damage")
    @JsonIgnoreProperties(value = {"damage"}, allowSetters = true)
    @OneToOne
    @JoinColumn(name="equipement_id")
    private Equipment equipement;

    @ManyToOne
    @JoinColumn(name = "damage_type_id")
    //@JsonIgnoreProperties("damages")
    @JsonIgnoreProperties(value = {"damages"}, allowSetters = true)
    private DamageType damageType;

    @OneToMany(mappedBy = "damage",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //@JsonIgnoreProperties("damage")
    @JsonIgnoreProperties(value = {"damage"}, allowSetters = true)
    private List<Picture> pictures;
}
