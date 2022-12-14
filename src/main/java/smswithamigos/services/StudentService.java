package smswithamigos.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import smswithamigos.data.models.Student;
import smswithamigos.exception.StudentAlreadyExistException;
import smswithamigos.repository.StudentRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

//    @Autowired
//   public StudentService(StudentRepository studentRepository) {
//       this.studentRepository = studentRepository;
//  }

    public void addNewStudent(Student student){
       Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if (studentByEmail.isPresent()) {
            throw new IllegalStateException ("student with email " + student.getEmail() + " already exists");
        } else {
            studentRepository.save(student);
        }
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();

    }

    public void deleteStudent(Long studentId) {
        var exist = studentRepository.existsById(studentId);
        if (!exist){
            throw new IllegalStateException("student with id " + studentId + " does not exist");
        } else {
            studentRepository.deleteById(studentId);
        }

    }

    @Transactional
    public void updateStudent(Long studentId, String name, String email) {
        Student student = studentRepository.findById(studentId).orElseThrow(() -> new IllegalStateException
                ("student with id " + studentId + " does not exist"));
        if (name != null && name.length() > 0 && !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
        if (email != null && email.length() > 0 && !Objects.equals(student.getEmail(), email)) {
            var studentByEmail = studentRepository.findStudentByEmail(email);
            if (studentByEmail.isPresent()) {
                throw new IllegalStateException("email already taken");
            }
            student.setEmail(email);


        }
    }
}