package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "birthday")
    private Date birthday;
    @Column(name = "sex")
    private Sex sex;
    @OneToMany(mappedBy = "owner")
    private List<Cat> cats;

    public Owner() {
    }

    public Owner(String name, Date birthday, Sex sex, List<Cat> cats) {
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.cats = cats;
    }
}