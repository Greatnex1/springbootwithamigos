package smswithamigos.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import smswithamigos.data.models.Student;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class StudentServiceTest {
    private  StudentService studentService;


    @BeforeEach
    void setUp() {



    }

    @Test
    void addNewStudent() {
        studentService.addNewStudent(new Student());
        assertNotNull(studentService);
    }

    @Test
    void getStudents() {
    }

    @Test
    void deleteStudent() {
    }

    @Test
    void updateStudent() {
    }
}