package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.awt.*;
import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "cats")
public class Cat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "sex")
    private Sex sex;
    @Column(name = "breed")
    private String breed;
    @Column(name = "color")
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

    public Cat() {
    }

    public Cat(String name, Date birthday, Sex sex, String breed, Color color, Owner owner, List<Cat> friends) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.breed = breed;
        this.color = color;
        this.owner = owner;
        this.friends = friends;
    }
}