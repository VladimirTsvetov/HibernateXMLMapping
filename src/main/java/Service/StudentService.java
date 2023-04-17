package Service;

import bl.SessionUtil;
import dao.StudentDAO;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class StudentService extends SessionUtil implements StudentDAO {

    public void add(Student student) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(student);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public List<Student> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM STUDENT";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Student.class);
        List<Student> studentList = query.list();

        //close session with a transaction
        closeTransactionSesstion();

        return studentList;
    }

    public Student getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM STUDENT WHERE ID = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Student.class);
        query.setParameter("id", id);

        Student student = (Student) query.getSingleResult();

        //close session with a transaction
        closeTransactionSesstion();

        return student;
    }

    public void update(Student student) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(student);

        //close session with a transaction
        closeTransactionSesstion();
    }

    public void remove(Student student) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(student);

        //close session with a transaction
        closeTransactionSesstion();
    }

}