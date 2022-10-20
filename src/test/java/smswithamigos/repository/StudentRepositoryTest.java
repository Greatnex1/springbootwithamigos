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

private Student student;
//    @BeforeEach
//    void setUp() {
//        student = new Student(
//               "Joy", "joy@gmail.com", LocalDate.of(2020, JANUARY,21),Gender.FEMALE);
//       studentRepo.save(student);
//    }

    @AfterEach
    void tearDown() {
        studentRepo.deleteAll();
    }

    @Test
    void findStudentByEmailTest() {
      // var exist = studentRepo.findStudentByEmail(email);

       assertThat(student).isNotNull();
       assertThat(student.getEmail()).isEqualTo("joy@gmail.com");
       assertEquals("joy@gmail.com",student.getEmail());
    }
    @Test
    void studentEmailDoesNotExist (){
        assertThat(student.getEmail()).isEmpty();
    }

}