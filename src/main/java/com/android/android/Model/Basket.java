package com.android.android.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "_basket")
@Getter
@Setter
@NoArgsConstructor
public class Basket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    private User user;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "basket")
    private List<BasketSneaker> basketSneakers;

    public Basket(User user){
        this.user = user;
    }
}
