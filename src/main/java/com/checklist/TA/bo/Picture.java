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
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Picture {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "image", unique = false, nullable = false, length = 100000)
    private byte[] image;

    @Column(name = "description")
    private String description;
    @JsonIgnoreProperties("pictures")
    @ManyToOne
    private Damage damage;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
}
