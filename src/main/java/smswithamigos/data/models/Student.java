package smswithamigos.data.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;
import java.time.Period;

@Entity
@ToString
@Table

public class Student {
    @Id
/*    @SequenceGenerator(
            name = "student_sequence",
            sequenceName = "student_sequence",
            allocationSize = 1
    )*/
    /*@GeneratedValue(strategy = GenerationType.AUTO,
    generator = "student_sequence")*/
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate dob;
    @Email
    private  String email;

//    private Gender gender;

    @Transient
    private  Integer age;

    public Student(Long id, String name, String email, LocalDate dob) {
        this.id=id;
        this.name = name;
        this.email = email;
        this.dob = dob;
    }

    public Student(String name, String email,LocalDate dob) {
        this.name = name;
        this.email = email;
        this.dob = dob;
//        this.gender = gender;
    }

    public Student() {

    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDob() {
        return dob;
    }

    public Integer getAge() {
        return Period.between(this.dob,LocalDate.now()).getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }



//  public Student(String aLex, String s, LocalDate of, int i) {
  //
    //
    //    public Integer getAge() {
    //        return Period.between (this.dob,LocalDate.now()).getYears();
    //    }}
}
