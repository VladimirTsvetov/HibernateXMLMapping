package dao;

import entity.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDAO {
    void add(Student Student) throws SQLException;

    //read
    List<Student> getAll() throws SQLException;

    Student getById(Long id) throws SQLException;

    //update
    void update(Student Student) throws SQLException;

    //delete
    void remove(Student Student) throws SQLException;

}
