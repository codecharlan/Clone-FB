package com.charlancodes.clonefb.model;

import lombok.*;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn
    private Post post;

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @Column(name = "timestamp", nullable = false, length = 100)
    private Timestamp timestamp;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "comment", cascade = CascadeType.ALL)
    private Like like;
}

