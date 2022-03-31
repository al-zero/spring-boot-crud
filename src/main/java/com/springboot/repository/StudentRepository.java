package com.springboot.repository;

import com.springboot.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface StudentRepository  extends JpaRepository<Student, Long> {
    //Custom query
    @Query(value = "select * from student_management_system s where " +
            "s.first_name like %:keyword% or " +
            "s.last_name like %:keyword% or " +
            "s.email like %:keyword%",
            nativeQuery = true)
    List<Student> findByKeyword(@Param("keyword") String keyword);
}
