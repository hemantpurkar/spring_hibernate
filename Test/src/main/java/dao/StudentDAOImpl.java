package dao;

import java.util.List;

import model.Student;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class StudentDAOImpl implements StudentDAO  {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void create(Student stud) {
		sessionFactory.getCurrentSession().save(stud);
	}

	@Transactional
	public void update(Student stud) {
		sessionFactory.getCurrentSession().update(stud);
	}

	@Transactional
	public Student getStudent(Integer id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class,
				id);
	}
	
	@Transactional
	public List<Student> getAllStudents() {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Student");
		List<Student> studentList = query.list();
		return studentList;
	}
	
	@Transactional
	public void delete(Student stud) {
		sessionFactory.getCurrentSession().delete(stud);
	}
}
