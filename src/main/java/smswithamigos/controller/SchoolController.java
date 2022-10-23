package smswithamigos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import smswithamigos.data.models.Student;
import smswithamigos.services.StudentService;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class SchoolController {
private final StudentService studentService;
@Autowired
    public SchoolController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/register")
    public void registerNewStudent(@RequestBody Student student){
        studentService.addNewStudent(student);
    }
    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudents();

    }
    @DeleteMapping(path ="{studentId}")
    public void deleteStudent(@PathVariable("studentId")Long studentId){
        studentService.deleteStudent(studentId);
    }
    @PutMapping(path = "{studentId}")
    public void updateStudentProfile(@PathVariable("studentId") Long studentId,
                                     @RequestParam(required=false)String name,
                                     @RequestParam(required = false)String email){
        studentService.updateStudent(studentId, name, email);
    }


}
