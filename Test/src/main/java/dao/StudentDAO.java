package dao;

import java.util.List;

import model.Student;

import org.hibernate.SessionFactory;

public interface StudentDAO {
	public void setSessionFactory(SessionFactory sessionFactory);

	public void create(Student stud);

	public void update(Student stud);

	public Student getStudent(Integer id);
	
	public List<Student> getAllStudents();

	public void delete(Student stud);
}
