package servlet;

import java.io.IOException;
import java.util.List;

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
		RequestDispatcher view = request.getRequestDispatcher("cadastrousuario.jsp");

		switch (acao) {
		case "listar":
			request.setAttribute("usuarios", UserDao.listar());
			view.forward(request, response);
			System.out.println("Usuários listados ");
			break;

		case "delete":
			Integer numId = Integer.parseInt(request.getParameter("id"));
			//if (!login.isEmpty()) {
			System.out.println(numId);
			UserDao.delete(numId);
			//}
			request.setAttribute("usuarios", UserDao.listar());
			view.forward(request, response);
			System.out.println("Login deletado -> " + login);
			break;

		case "editar":
			Integer id = Integer.parseInt(request.getParameter("id"));
			User usuario = UserDao.buscarPorId(id);
			request.setAttribute("user", usuario);
			request.setAttribute("usuarios", UserDao.listar());
			view.forward(request, response);
			System.out.println("Editado o user -> " + usuario.getLogin());
			break;

		case "cancelar":
			view.forward(request, response);

		case "buscar":
			UserDao.buscarPorId(Integer.parseInt(request.getParameter("id")));
			System.out.println("Ação de Buscar");

			break;
		default:
			view.forward(request, response);
			System.out.println("Opção Inválida");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher view = req.getRequestDispatcher("cadastrousuario.jsp");

		String nome = req.getParameter("nome");
		String login = req.getParameter("login");
		String senha = req.getParameter("senha");
		String id = (req.getParameter("id"));
		User user = new User();

		if (!id.isEmpty()) {
			System.out.println(id + " " + nome + " " + login);
			user.setId(Integer.parseInt(id));
			user.setName(nome);
			user.setLogin(login);
			user.setPassword(senha);
			UserDao.atualizar(user);
			req.setAttribute("usuarios", UserDao.listar());
			view.forward(req, resp);

		} else if (!nome.isEmpty() && !senha.isEmpty()) {
			user.setName(nome);
			user.setLogin(login);
			user.setPassword(senha);

			if (UserDao.userExiste(login)) {
				req.setAttribute("msg", "Já existe um usuário com esse Login");
				view.forward(req, resp);

			} else {

				UserDao.inserir(user);
				System.out.println("Usuário Inserido");
				req.setAttribute("usuarios", UserDao.listar());
				view.forward(req, resp);

			}

		}

	}

}
