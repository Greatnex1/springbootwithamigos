package smswithamigos.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import smswithamigos.data.models.Gender;
import smswithamigos.data.models.Student;
import smswithamigos.exception.StudentAlreadyExistException;
import smswithamigos.repository.StudentRepository;

import java.time.LocalDate;
import static java.time.Month.JANUARY;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

//@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    @Mock
    private StudentRepository studentRepository;
   // private AutoCloseable autoCloseable;
    private  StudentService studentService;


    @BeforeEach
    void setUp() {
      //  autoCloseable = MockitoAnnotations.openMocks(this);
studentService = new StudentService(studentRepository);

    }
//    @AfterEach
//    void tearDown() throws Exception{
//        autoCloseable.close();
//
//    }

    @Test
    void addNewStudentTest() {
    Student  student = new Student(
               "Joy", "joy@gmail.com",
            LocalDate.of(2020, JANUARY,21),
            Gender.FEMALE);
       studentService.addNewStudent(student);
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(studentRepository).save(studentArgumentCaptor.capture());

        Student captureStudent = studentArgumentCaptor.getValue();

        assertThat(captureStudent).isEqualTo(student);

//        studentService.addNewStudent(new Student());
//        assertNotNull(studentService);
    }

    @Test
    void getStudents() {
        studentService.getStudents();
        verify(studentRepository).findAll();
    }

//    @Test
//    void deleteStudent() {
// assertThat(studentService.deleteStudent());
//
//    }
    //assertThat(productService.deleteProduct(response.getProductId()));
    @Test
    void willThrowExceptionWhenEmailIsAlreadyTaken(){
        Student  student = new Student(
                "Joy", "joy@gmail.com",
                LocalDate.of(2020, JANUARY,21),
                Gender.FEMALE);

       given  (studentRepository.fetchStudentByEmail(student.getEmail())).willReturn(true);

     //  assertTrue(savedEmail);

        assertThatThrownBy(()-> studentService.addNewStudent(student))
                .isInstanceOf(StudentAlreadyExistException.class)

                .hasMessageContaining("student with email " + student.getEmail() + " already exists");
verify(studentRepository,never()).save(any());
    }

    @Test
    @Disabled
    void updateStudent() {

    }
}