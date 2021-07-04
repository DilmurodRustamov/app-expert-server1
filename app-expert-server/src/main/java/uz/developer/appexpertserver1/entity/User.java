//package uz.developer.appexpertserver1.entity;
//
//
//import lombok.Data;
//import lombok.EqualsAndHashCode;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import uz.developer.appexpertserver1.entity.enums.PersonType;
//import uz.developer.appexpertserver1.entity.template.AbsEntity;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.List;
//import java.util.Set;
//
//@EqualsAndHashCode(callSuper = true)
//@Data
//@Entity(name = "users")
//public class User extends AbsEntity implements UserDetails {
//
//    @Column(nullable = false)
//    private String firstName;
//    private String lastName;
//
//    private String middleName;
//
//    @Column(unique = true,nullable = false)
//    private String phoneNumber;
//
//    @Column(nullable = false)
//    private String password;
//
//    @Column(length = 9,unique = true,nullable = false)
//    private String tin; //INN or STIR
//
//    @Column(nullable = false,unique = true)
//    private String email;
//
//    @ManyToOne(optional = false)
//    private District district;
//
//    @Enumerated(EnumType.STRING)
//    private PersonType personType;
//
//    @ManyToMany
//    private Set<Role> roles;
//
//    private boolean accountNonExpired = true;
//
//    private boolean accountNonLocked = true;
//
//    private boolean credentialsNonExpired = true;
//
//    private boolean enabled;
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return roles;
//    }
//
//    @Override
//    public String getUsername() {
//        return null;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return accountNonExpired;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return accountNonLocked;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return credentialsNonExpired;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return enabled;
//    }
//}
