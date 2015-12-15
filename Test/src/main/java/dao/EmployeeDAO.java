package dao;

import model.Employee;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDAO {

	private SessionFactory sessionFactory;

	/*
	 * public void setSessionFactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	public void saveEmployee(Employee employee) {
		sessionFactory.getCurrentSession().save(employee);
	}
	
	@Transactional
	public Employee findEmployeeById(String id) {
		return (Employee) sessionFactory.getCurrentSession().get(
				Employee.class, id);
	}
	
	@Transactional
	public void updateEmployee(Employee employee) {
		sessionFactory.getCurrentSession().update(employee);

	}

	@Transactional
	public void deleteEmployee(Employee employee) {
		sessionFactory.getCurrentSession().delete(employee);
	}
}
