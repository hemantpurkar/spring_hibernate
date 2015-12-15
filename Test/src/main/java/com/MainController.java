package com;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Employee;
import model.Student;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import dao.EmployeeDAO;
import dao.StudentDAO;

@Controller
public class MainController {

	@RequestMapping("home")
	public ModelAndView readStudentInfo(Model model) {
		return new ModelAndView("student");
	}

	@RequestMapping("addStudent")
	public ModelAndView addStudent(HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		StudentDAO studentDao = (StudentDAO) r.getBean("studDao");

		System.out.println("------Records Creation--------");
		Student stud = new Student();
		stud.setName(req.getParameter("name"));
		stud.setAge(Integer.parseInt(req.getParameter("age")));
		studentDao.create(stud);

		return new ModelAndView("redirect:listStudents");
	}

	@RequestMapping("listStudents")
	public String listStudents(HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		StudentDAO studentDao = (StudentDAO) r.getBean("studDao");

		List<Student> students = studentDao.getAllStudents();

		/*System.out.println("students::" + students);
		for (int i = 1; i <= students.size(); i++) {
			System.out.println(">>>>>>>" + students.get(i).getName()
					+ ">>>>>>>>>>" + students.get(i).getAge());
		}*/

		model.addAttribute("studentsData", students);
		return "studentsList";
	}

	@RequestMapping("employee")
	public String addEmployeeInfo(HttpServletRequest req,
			HttpServletResponse resp, Model model) {
		ApplicationContext r = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		EmployeeDAO edao = (EmployeeDAO) r.getBean("empDao");
		Employee e = new Employee();
		e.setName("Varun");
		e.setSalary(50000);

		edao.saveEmployee(e);

		model.addAttribute("message",
				"Employee Information added successfully...");
		return "home";
	}
}