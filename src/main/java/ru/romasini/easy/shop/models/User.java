package ru.romasini.easy.shop.models;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name ="username")
    private String username;

    @Column(name ="password")
    private String password;

    @Column(name ="email")
    private String email;

//    @OneToMany(mappedBy = "user")
//    @Cascade(org.hibernate.annotations.CascadeType.ALL)
//    private List<Order> orders;

    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Collection<Role> roles;

}
