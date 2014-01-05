package com.it2274.hibernate.example.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it2274.hibernate.example.dao.StudentDao;
import com.it2274.hibernate.example.dto.Student;

/**
 * Servlet implementation class StudentCreateServlet
 */
@WebServlet("/StudentCreateServlet")
public class StudentCreateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public StudentCreateServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Inserting record in database using Hibernate is just simply setting values through entity's setter method
		
		// Retrieves parameters from html form
		String name = request.getParameter("s_name");
		String adminNo = request.getParameter("s_admin_no");
		int age = Integer.parseInt(request.getParameter("s_age"));

		// Create a detached Student object and set the values
		// You SHOULD omit the primary key field, in this case, the student.id
		// Because Hibernate will handle the id sequence generation for you
		Student student = new Student();
		student.setName(name);
		student.setAdminNo(adminNo);
		student.setAge(age);

		// Persist data into the database using DAO class
		StudentDao studentDao = new StudentDao();
		studentDao.create(student);
		
		response.sendRedirect("StudentListServlet");
	}

}
