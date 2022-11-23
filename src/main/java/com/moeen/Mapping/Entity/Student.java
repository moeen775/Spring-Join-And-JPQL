package com.moeen.Mapping.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "STUDENT_TBL")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int age;
    private String dept;

    public Student(int age) {
        this.age = age;
    }

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "STUDENT_COURSE_TBL",joinColumns = {
            @JoinColumn(name = "student_id",referencedColumnName = "id")
    },
            inverseJoinColumns = {
            @JoinColumn(name = "course_id",referencedColumnName = "id")
            }
    )
    @JsonManagedReference
    private Set<Course> courses;
}
