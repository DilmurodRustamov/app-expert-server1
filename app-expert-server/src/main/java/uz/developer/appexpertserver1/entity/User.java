package uz.developer.appexpertserver1.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import uz.developer.appexpertserver1.entity.enums.PersonType;
import uz.developer.appexpertserver1.entity.template.AbsEntity;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity(name = "users")
@NoArgsConstructor
public class User extends AbsEntity implements UserDetails {

    @Column(nullable = false)
    private String firstName;
    private String lastName;

    private String middleName;

    @Column(unique = true,nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String password;

    @Column(length = 9,unique = true,nullable = false)
    private String tin; //INN or STIR

    @Column(nullable = false,unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    private PersonType personType;

    @ManyToMany
    @JoinTable(name = "user_role",
    joinColumns = {@JoinColumn(name = "user_id")},
    inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Set<Role> roles;

    private boolean accountNonExpired = true;
    private boolean accountNonLocked = true;
    private boolean credentialsNonExpired = true;
    private boolean enabled;

    public User(String firstName, String lastName, String middleName,
                String phoneNumber, String password, String tin, String email, PersonType personType, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.email = email;
        this.tin = tin;
        this.personType = personType;
        this.roles = roles;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
