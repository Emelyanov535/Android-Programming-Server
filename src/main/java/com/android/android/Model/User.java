package com.android.android.Model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "_user")
@Getter
@Setter
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String username;
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;
    @Nullable
    private byte photo;

    @ManyToMany
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Collection<Role> roles;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    private List<Order> orders;

    @OneToOne
    private Basket basket;

    public User(String username, String email, String password, byte photo) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.photo = photo;
    }
}
