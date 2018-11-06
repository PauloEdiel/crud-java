package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String 	nome = req.getParameter("login");
		String senha = req.getParameter("pass");
		if (UserDao.validaLogin(nome, senha)) {
			RequestDispatcher view = req.getRequestDispatcher("cadastros.jsp");
			view.forward(req, resp);

		} else {
			RequestDispatcher view = req.getRequestDispatcher("index.jsp");
			view.forward(req, resp);
		}
		
		
	}

}
