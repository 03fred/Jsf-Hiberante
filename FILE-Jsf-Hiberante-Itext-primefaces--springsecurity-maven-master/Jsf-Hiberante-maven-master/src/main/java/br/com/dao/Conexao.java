package br.com.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	public static Connection getConnection() {
		
		java.sql.Connection con = null;
		try {
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
	            System.out.println("erro - driver "+ e.getMessage());

			}
			con =  DriverManager.getConnection("jdbc:postgresql://localhost:5432/Projetojsf","postgres","0");
            System.out.println("conectado com sucesso ");

		} catch (SQLException e) {
            System.out.println("erro - conex�o "+ e.getMessage());
		}
		return con;
	}
	
}
