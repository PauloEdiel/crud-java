package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDao;
import beans.User;

@WebServlet("/cadastrarUsuario")
public class CadastroUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CadastroUsuario() {
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String acao = request.getParameter("acao");
		String login = request.getParameter("user");
		 
		

		switch (acao) {
		case "listar":
			RequestDispatcher view = request.getRequestDispatcher("cadastrousuario.jsp");
			request.setAttribute("usuarios", UserDao.listar());
			view.forward(request, response);
			System.out.println("Usuários listados ");
			break;
		case "delete":
			if(! login.isEmpty()){
				UserDao.delete(login);
			}
			System.out.println("Login deletado -> " + login);
			break;
		case "editar":
			Integer id = Integer.parseInt(request.getParameter("id"));
			UserDao.buscarPorId(id);
			System.out.println(id);
			System.out.println("Ação de editar");
			break;
		case "buscar":
			UserDao.buscarPorId(Integer.parseInt(request.getParameter("id")));			
			System.out.println("Ação de Buscar");
			
			break;
		default:
			System.out.println("Opção Inválida");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		

		if (!nome.isEmpty() && !senha.isEmpty()) {
			User user = new User(nome, login, senha);
			UserDao.inserir(user);
			System.out.println("Usuário Inserido");
			RequestDispatcher view = req.getRequestDispatcher("cadastrousuario.jsp");
			req.setAttribute("usuarios", UserDao.listar());
			view.forward(req, resp);

		}

	}

}
