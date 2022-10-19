package smswithamigos.repository;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import smswithamigos.data.models.Gender;
import smswithamigos.data.models.Student;

import java.time.LocalDate;

import static java.time.Month.JANUARY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StudentRepositoryTest {
@Autowired
 private StudentRepository studentRepo;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void findStudentByEmailTest() {
       String email = "joy@gmail.com";
       Student student = new Student(
               "Joy", "joy@gmail.com", LocalDate.of(2020, JANUARY,21),Gender.FEMALE);
       studentRepo.save(student);
       var exist = studentRepo.findStudentByEmail(email);

       //assertThat(student).isNotNull();
       assertEquals("joy@gmail.com",student.getEmail());
    }

}