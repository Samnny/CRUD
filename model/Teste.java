package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Teste {

	public static void main(String[] args) {
		
		Connection con = ConnectionFactory.getConnection();
		
		String sql = "insert into agenda (nome, sobrenome, idade, telefone) values ('Larissa', 'Oliveira', 23, '(85) 8734-2345')";
		
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.execute();
			ps.close();
			System.out.println("Contato salvo com sucesso");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
