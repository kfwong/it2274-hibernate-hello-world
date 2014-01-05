package com.it2274.hibernate.example.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it2274.hibernate.example.dao.StudentDao;
import com.it2274.hibernate.example.dto.Student;

/**
 * Servlet implementation class StudentUpdateServlet
 */
@WebServlet("/StudentUpdateServlet")
public class StudentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Updating an entity in Hibernate requires primary key field to be set explicitly
		
		int id = Integer.parseInt(request.getParameter("s_id"));
		String name = request.getParameter("s_name");
		String adminNo = request.getParameter("s_admin_no");
		int age = Integer.parseInt(request.getParameter("s_age"));

		Student student = new Student();
		student.setId(id); // MUST set into the Student object since this is the primary key
		student.setName(name);
		student.setAdminNo(adminNo);
		student.setAge(age);

		StudentDao studentDao = new StudentDao();
		studentDao.update(student);
		
		response.sendRedirect("StudentListServlet");
	}

}
