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
 * Servlet implementation class StudentDeleteServlet
 */
@WebServlet("/StudentDeleteServlet")
public class StudentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Deleting record from database requires only the primary key of the entity
		// In this case the student.id (not the adminNo)
		// The rest of the attributes are irrelevant
		
		int id = Integer.parseInt(request.getParameter("s_id"));

		Student student = new Student();
		student.setId(id);

		StudentDao studentDao = new StudentDao();
		studentDao.delete(student);
		
		response.sendRedirect("StudentListServlet");
	}

}
