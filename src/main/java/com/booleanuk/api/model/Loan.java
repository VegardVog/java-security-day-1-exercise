package com.booleanuk.api.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "loans")
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String title;

    @Column
    private String createdAt;

    @Column
    private String updatedAt;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

    public Loan(String title, String createdAt, String updatedAt, User user, Game game) {
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.user = user;
        this.game = game;
        this.title = title;
    }

    public Loan(int id) {
        this.id = id;
    }
}