package com.example.instagram.api.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    @JsonIgnore
    private User user;

    @Column(length = 13, nullable = false)
    @JsonIgnore
    private String photos;

    @Column(length = 200, nullable = true)
    @JsonIgnore
    private String description;

    @Column(nullable = false)
    @ColumnDefault("0")
    @JsonIgnore
    private int commentCount;
}
