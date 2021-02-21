package br.com.academia.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import br.com.academia.model.Pessoa;

public class PessoaDAO implements DAO<Pessoa> {
	
	private Connection con;
	
	public PessoaDAO() {
		con = FabricaConexao.getConexao();
	}

	@Override
	public void incluir(Pessoa obj) {
		String sql = "INSERT INTO pessoa (nome, cpf, datanascimento, email, celular, sexo) VALUES (?, ?, ?, ?, ?, ?);";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, obj.getNome());
			ps.setString(2, obj.getCpf());
			Date data = new Date(obj.getDataNascimento().getTimeInMillis());
			ps.setDate(3, data);
			ps.setString(4, obj.getEmail());
			ps.setString(5, obj.getCelular());
			ps.setString(6, String.valueOf(obj.getSexo()));
			ps.executeUpdate();
			String sql2 = "SELECT * FROM pessoa WHERE cpf = ? AND nome = ? AND datanascimento = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setString(1, obj.getCpf());
			ps2.setString(2, obj.getNome());
			ps2.setDate(3, data);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()) {
				obj.setId(rs.getInt("id"));
			}
			ps.close();
			ps2.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void alterar(Pessoa p) {
		String str = "UPDATE pessoa SET nome = ?, email = ?, sexo = ?, celular = ?, datanascimento = ?, cpf = ? WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(str);
			ps.setString(1, p.getNome());
			ps.setString(2, p.getEmail());
			ps.setString(3, String.valueOf(p.getSexo()));
			ps.setString(4, p.getCelular());
			Date data = new Date(p.getDataNascimento().getTimeInMillis());
			ps.setDate(5, data);
			ps.setString(6, p.getCpf());
			ps.setInt(7, p.getId());
			ps.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void excluir(int id) {
		String sql = "DELETE FROM pessoa WHERE id = ?";
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public Pessoa pesquisar(int id) {
		String sql = "SELECT * FROM pessoa WHERE id = ?";
		Pessoa p = null;
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setSexo(rs.getString("sexo").toCharArray()[0]);
				p.setCelular(rs.getString("celular"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				Date dataNasc = rs.getDate("datanascimento");
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(dataNasc.getTime());
				p.setDataNascimento(gc);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return p;
	}

	@Override
	public List<Pessoa> pesquisar() {
		String sql = "SELECT * FROM pessoa ORDER BY id";
		List<Pessoa> list = new ArrayList<Pessoa>();
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa p = new Pessoa();
				p.setId(rs.getInt("id"));
				p.setNome(rs.getString("nome"));
				p.setCelular(rs.getString("celular"));
				p.setCpf(rs.getString("cpf"));
				p.setEmail(rs.getString("email"));
				p.setSexo(rs.getString("sexo").toCharArray()[0]);
				GregorianCalendar gc = new GregorianCalendar();
				gc.setTimeInMillis(rs.getDate("datanascimento").getTime());
				p.setDataNascimento(gc);
				list.add(p);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return list;
	}

}
