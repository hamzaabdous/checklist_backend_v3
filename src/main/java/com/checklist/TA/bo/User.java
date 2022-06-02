package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.*;
import org.springframework.lang.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;


@Entity
@Table(name="users")
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class User implements UserDetails {
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @NotNull(message = "username null")
    @NotBlank(message = "saisir votre username")
    @Size(min = 3, message = "username  must have at least 3 characters")
    @Column(name="username",unique=true)
    private String username;

    @NotNull(message = "lastName null")
    @NotBlank(message = "saisir votre lastName")
    @Column(name = "lastName")
    private String lastName;

    @NotNull(message = "firstName null")
    @NotBlank(message = "saisir votre firstName")
    @Column(name = "firstName")
    private String firstName;


    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$")
    @Column(name="email")
    private String email;

    @Column(name="password")
    private String password;

    @Column(name="phone_Number")
    private String phoneNumber;



    @JsonIgnoreProperties("users")
    @ManyToOne()
    private Function function;

    @JsonIgnoreProperties("users")
    @ManyToMany
    @JoinTable(name = "profileGroup_users",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_profileGroup"))
    private List<ProfileGroup> profileGroups;

    @JsonIgnoreProperties("userDeclaration")
    @OneToMany(mappedBy = "userDeclaration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageDeclaration;

  @JsonIgnoreProperties("userResolution")
    @OneToMany(mappedBy = "userResolution",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageResolution;

    @JsonIgnoreProperties("userClosed")
    @OneToMany(mappedBy = "userClosed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageClosed;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;
}
