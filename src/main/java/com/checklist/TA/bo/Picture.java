package com.checklist.TA.bo;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name="pictures")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;


    @Column(name="filename")
    private String filename;

    @Column(name="url")
    private String url;
    @JsonIgnoreProperties("pictures")
    @ManyToOne
    private Damage damage;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;

}
