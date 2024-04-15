package com.example.personalcoordinator.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Getter
@Setter
@SQLDelete(sql = "UPDATE default_courses SET is_deleted = TRUE WHERE id = ?")
@Where(clause = "is_deleted = FALSE")
@Entity
@Table(name = "default_courses")
public class DefaultCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, name = "course_name")
    private String name;
    @Column(nullable = false, name = "description")
    private String description;
    @Column(nullable = false, name = "link")
    private String link;
    @Column(nullable = false, name = "image")
    private String image;
    @Column(nullable = false)
    private boolean isDeleted = false;
}
