package com.charlancodes.clonefb.model;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @Column(name = "user_id", insertable = false, updatable = false, nullable = false)
//    private long user_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private User user;
    @Column(name = "title", nullable = false, length = 100)
    private String title;
    @Column(name = "content", nullable = false, length = 10000)
    private String content;
    @Column(name = "timestamp", nullable = false, length = 100)
    private Timestamp timestamp;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "post", cascade = CascadeType.ALL)
    private Like likes;

}

