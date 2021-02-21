package br.com.academia.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricaConexao {

	public static Connection getConexao() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/academia", "postgres", "postgres");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}
