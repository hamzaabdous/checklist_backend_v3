package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import java.util.Date;
import java.util.List;


@javax.persistence.Entity
@Table(name="functions")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Function {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="name")
    private String name;

    @JsonIgnoreProperties("function")
    @OneToMany(mappedBy = "function",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<User> users;

    @JsonIgnoreProperties("functions")
    @ManyToOne
    private Department department;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;
}
