package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="damageTypes")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DamageType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull(message = "name null")
    @NotBlank(message = "saisir votre name")
    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("damageTypes")
    @ManyToOne
    private ProfileGroup profileGroup;

    @JsonIgnoreProperties("damageTypes")
    @ManyToOne
    private Department department;

    @JsonIgnoreProperties("damageType")
    //@JsonBackReference

    @OneToMany(mappedBy = "damageType",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damages;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;


}
