package com.sparta.trellopractice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name = "board")
public class Board extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private String backgroundColor;

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BoardMember> boardMemberList = new ArrayList<>();

    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Deck> deckList = new ArrayList<>();
}
