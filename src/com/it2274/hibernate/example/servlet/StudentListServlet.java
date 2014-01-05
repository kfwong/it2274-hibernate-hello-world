package com.it2274.hibernate.example.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.it2274.hibernate.example.dao.StudentDao;
import com.it2274.hibernate.example.dto.Student;

/**
 * Servlet implementation class StudentListServlet
 */
@WebServlet("/StudentListServlet")
public class StudentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StudentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// You have quite a few options to retrives record from database.
		// Please take a look at the StudentDao.getAll() method for furthur explainations
		StudentDao studentDao = new StudentDao();
		List<Student> students = studentDao.getAll();
		
		request.setAttribute("students", students);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
