package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.awt.*;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate birthDate;
    private Sex sex;
    private String breed;
    private Color color;
    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private Owner owner;
    @Fetch(FetchMode.JOIN)
    @ManyToMany
    @JoinTable(
            name = "cats_friends",
            joinColumns = {@JoinColumn(
                    name = "cat_id"
            )},
            inverseJoinColumns = {@JoinColumn(
                    name = "friend_id"
            )}
    )
    private List<Cat> friends;
}