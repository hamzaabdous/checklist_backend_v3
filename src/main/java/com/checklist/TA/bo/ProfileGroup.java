package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="profileGroups")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor



public class ProfileGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("profileGroups")
    @JsonIgnore
    @ManyToMany
    @JoinTable(name = "profileGroup_users",joinColumns = @JoinColumn(name = "id_profileGroup"),inverseJoinColumns = @JoinColumn(name = "id_user"))
    private List<User> users;

    @JsonIgnoreProperties("profileGroup")
    @OneToMany(mappedBy = "profileGroup",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<DamageType> damageTypes;

  @JsonIgnoreProperties("profileGroup")
    @OneToMany(mappedBy = "profileGroup",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Equipment> equipments;


    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;
}
