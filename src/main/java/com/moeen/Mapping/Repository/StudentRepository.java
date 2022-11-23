package com.moeen.Mapping.Repository;

import com.moeen.Mapping.Entity.Student;
import com.moeen.Mapping.dto.StudentCourseFind;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
   //@Query(value = "select * from student_tbl",nativeQuery = true)
    @Query("select s from Student s")
    public List<Student> getAllStudent();
    @Query("select s from Student s where s.name=:n")
    public Student getStudentByName(@Param("n") String name);
    @Query("select new com.moeen.Mapping.dto.StudentCourseFind(s.name ,c.title) from Student s JOIN s.courses c")
    public List<StudentCourseFind> customJoinGet();

 @Query("select new com.moeen.Mapping.dto.StudentCourseFind(s.name ,c.title) from Student s JOIN " +
         "s.courses c where s.name=:n")
 public List<StudentCourseFind> customJoinGetNameFilter(@Param("n") String name);

 @Query("select new com.moeen.Mapping.dto.StudentCourseFind(s.name ,c.title) from Student s JOIN " +
         "s.courses c where s.name=:n and c.title='java'")
 public StudentCourseFind customJoinGetNameFilterWithTitle(@Param("n") String name);



}
