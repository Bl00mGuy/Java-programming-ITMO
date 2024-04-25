package org.example.model;

import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String name;
    private LocalDate birthDate;
    private Sex sex;
    @OneToMany(mappedBy = "owner")
    private List<Cat> cats;
}