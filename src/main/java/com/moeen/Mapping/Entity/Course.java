package com.moeen.Mapping.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "Course_TBL")

public class Course {
    @Id
    private Long id;
    private String title;
    private  String description;
    private double fees;

    @ManyToMany(mappedBy = "courses",fetch = FetchType.LAZY)
  @JsonBackReference
    private Set<Student> students;
}
