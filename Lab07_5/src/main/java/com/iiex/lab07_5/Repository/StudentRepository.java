package com.iiex.lab07_5.Repository;

import com.iiex.lab07_5.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    @Query("SELECT s FROM Student s WHERE s.age >= :age")
    List<Student> findByAgeGreaterThanOrEqual(@Param("age") int age);

    @Query("SELECT COUNT(s) FROM Student s WHERE s.ieltsScore = :ieltsScore")
    int countByIeltsScore(@Param("ieltsScore") double ieltsScore);

    @Query("SELECT s FROM Student s WHERE UPPER(s.name) LIKE CONCAT('%', :name, '%')")
    List<Student> findByNameEquals(@Param("name") String name);
}
