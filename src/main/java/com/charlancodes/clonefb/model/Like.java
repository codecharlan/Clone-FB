package com.charlancodes.clonefb.model;

import lombok.*;

import javax.persistence.*;
import java.sql.Timestamp;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "dolike")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Post post;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private Comment comment;

    @Column(name = "timestamp", nullable = false, length = 100)
    private Timestamp timestamp;
}
