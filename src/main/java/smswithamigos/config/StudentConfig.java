package smswithamigos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import smswithamigos.data.models.Student;
import smswithamigos.repository.StudentRepository;
import smswithamigos.repository.StudentRepository;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static java.time.Month.JANUARY;

@Configuration
public class StudentConfig {

@Bean
CommandLineRunner commandLineRunner (
    StudentRepository repository
    ){
    return args -> {

        Student mary = new Student(


                "Mariam",
                "may@gmail.com",
                LocalDate.of(2020, JANUARY,21)
        );
        Student alex = new Student(
                "Alex",
                "alex@gmail.com",
                LocalDate.of(2001, JANUARY,3)

        );
        repository.saveAll(List.of(mary,alex)
        );
    };
}
        }






