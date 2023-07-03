package com.charlancodes.clonefb.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "firstname", nullable = false, length = 100)
    private String firstName;
    @Column(name = "surname", nullable = false, length = 100)
    private String surname;
    @Column(name = "email", unique = true, nullable = false, length = 100)
    private String emailAddress;
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Column(name = "dateofbirth", nullable = false, length = 100)
    private Date dateOfBirth;
    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false, length = 10)
    private Gender gender;
    @Column(name = "phonenumber", unique = true, nullable = false, length = 100)
    private String phoneNo;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Post> posts;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private List<Comment> comments;
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "user", cascade = CascadeType.ALL)
    private Like likes;
}
