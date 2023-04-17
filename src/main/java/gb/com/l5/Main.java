package gb.com.l5;

import Service.StudentService;
import bl.HibernateUtil;
import entity.Student;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        StudentService studentService = new StudentService();

        Student student = new Student();

        student.setFirst_name("John");
        student.setLast_name("Lennon");
        student.setMark(5);
        studentService.add(student);

        student.setFirst_name("Ozzy");
        student.setLast_name("Osbourne");
        student.setMark(10);
        studentService.add(student);


        Student anyStudent = studentService.getById(1L);
        System.out.println(anyStudent);
        anyStudent.setMark(2);
        studentService.update(anyStudent);


        HibernateUtil.shutdown();
    }
}