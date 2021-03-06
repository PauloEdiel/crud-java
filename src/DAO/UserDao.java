package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.User;
import connection.ConectionFactory;

public class UserDao {

	public static boolean validaLogin(String login, String senha) {

		String sql = "select * from users where login = ? and password = ?";
		try (Connection conexao = ConectionFactory.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			ps.setString(1, login);
			ps.setString(2, senha);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static boolean userExiste(String login) {
		String sql = "select * from users where login = ?";
		try (Connection conexao = ConectionFactory.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			ps.setString(1, login);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return false;
	}

	public static void inserir(User user) {

		if (user != null) {
			String sql = "insert into users values(default,?,?,?)";

			try (Connection conexao = ConectionFactory.getConexao();
					PreparedStatement ps = conexao.prepareStatement(sql);) {
				ps.setString(1, user.getName());
				ps.setString(2, user.getLogin());
				ps.setString(3, user.getPassword());
				ps.executeUpdate();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<User> listar() {
		String sql = "Select * from users";
		List<User> listaUsuarios = new ArrayList<>();
		try (Connection conexao = ConectionFactory.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			ResultSet resultSet = ps.executeQuery();
			while (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt("id"));
				user.setLogin(resultSet.getString("login"));
				user.setName(resultSet.getString("name"));
				user.setPassword(resultSet.getString("password"));
				listaUsuarios.add(user);

			}
			return listaUsuarios;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void delete(Integer id) {
		String sql = "delete from users where id = ?";
		try {
			Connection conexao = ConectionFactory.getConexao();
			PreparedStatement preparedStatement = conexao.prepareStatement(sql);
			preparedStatement.setInt(1, id);
			preparedStatement.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(login);

	}

	public static User buscarPorId(Integer id) {
		String sql = "Select * from users where id = ?";
		User user = null;
		try (Connection conexao = ConectionFactory.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setLogin(rs.getString("login"));
				user.setName(rs.getString("name"));
				user.setPassword(rs.getString("password"));

				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;

	}

	public static void atualizar(User user) {
		String sql = "update users set name = ?, login = ? where id = " + user.getId();
		try (Connection conexao = ConectionFactory.getConexao();
				PreparedStatement ps = conexao.prepareStatement(sql);) {
			ps.setString(1, user.getName());
			ps.setString(2, user.getLogin());
			// ps.setString(3, user.getPassword());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
