package pl.skoltun.SpringBoot.repository;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class UserAuthority implements GrantedAuthority {
    @Id
    @GeneratedValue
    private Long id;
    private String authority;
    @ManyToOne
    private User user;

    public UserAuthority() {
    }

    public UserAuthority(String authority, User user) {
        this.authority = authority;
        this.user = user;
    }

    @Override
    public String getAuthority() {
        return null;
    }

}
