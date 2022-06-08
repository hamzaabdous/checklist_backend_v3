package com.checklist.TA.bo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import org.hibernate.Hibernate;
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
import java.util.Objects;


@Entity
@Table(name="users")
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
    //@JsonBackReference(value="function")
    @ManyToOne()
    private Function function;

    @JsonIgnoreProperties("users")
    //@JsonBackReference(value="profileGroups")
    @ManyToMany
    @JoinTable(name = "profileGroup_users",joinColumns = @JoinColumn(name = "id_user"),inverseJoinColumns = @JoinColumn(name = "id_profileGroup"))
    private List<ProfileGroup> profileGroups;

    @JsonIgnoreProperties("userDeclaration")
    @OneToMany(mappedBy = "userDeclaration",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonBackReference(value="damageDeclaration")

    private List<Damage> damageDeclaration;

  @JsonIgnoreProperties("userResolution")
  @JsonBackReference(value="damageResolution")
  @OneToMany(mappedBy = "userResolution",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
  private List<Damage> damageResolution;

    @JsonIgnoreProperties("userClosed")
    @JsonBackReference(value="damageClosed")
    @OneToMany(mappedBy = "userClosed",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Damage> damageClosed;

    @Nullable
    @Column(name="created_Date")
    private Date createdDate;
    @Nullable
    @Column(name="update_Date")
    private Date updateDate;


    public User(Long id, String username, String lastName, String firstName, String email, String password, String phoneNumber, Function function, List<ProfileGroup> profileGroups, List<Damage> damageDeclaration, List<Damage> damageResolution, List<Damage> damageClosed, @Nullable Date createdDate, @Nullable Date updateDate) {
        this.id = id;
        this.username = username;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.function = function;
        this.profileGroups = profileGroups;
        this.damageDeclaration = damageDeclaration;
        this.damageResolution = damageResolution;
        this.damageClosed = damageClosed;
        this.createdDate = createdDate;
        this.updateDate = updateDate;
    }

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public List<ProfileGroup> getProfileGroups() {
        return profileGroups;
    }

    public void setProfileGroups(List<ProfileGroup> profileGroups) {
        this.profileGroups = profileGroups;
    }

    public List<Damage> getDamageDeclaration() {
        return damageDeclaration;
    }

    public void setDamageDeclaration(List<Damage> damageDeclaration) {
        this.damageDeclaration = damageDeclaration;
    }

    public List<Damage> getDamageResolution() {
        return damageResolution;
    }

    public void setDamageResolution(List<Damage> damageResolution) {
        this.damageResolution = damageResolution;
    }

    public List<Damage> getDamageClosed() {
        return damageClosed;
    }

    public void setDamageClosed(List<Damage> damageClosed) {
        this.damageClosed = damageClosed;
    }

    @Nullable
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(@Nullable Date createdDate) {
        this.createdDate = createdDate;
    }

    @Nullable
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(@Nullable Date updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
