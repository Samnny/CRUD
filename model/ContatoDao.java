package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ContatoDao {
	
	private Connection con;
	
	public ContatoDao() {
		
		con = new ConnectionFactory().getConnection();
		
	}
	
	public void cadastrarContato(Contato contato) {
		
		String sql = "insert into agenda(nome, sobrenome, idade, telefone) values(?, ?, ?, ?)";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setInt(3, contato.getIdade());
			ps.setString(4, contato.getTelefone());
			
			ps.execute();
			ps.close();
			
			System.out.println("Contato cadastrado com sucesso.");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public void alterarContato(Contato contato) {
		
		String sql = "update agenda set nome=?, sobrenome=?, idade=?, telefone=? where id=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, contato.getNome());
			ps.setString(2, contato.getSobrenome());
			ps.setInt(3, contato.getIdade());
			ps.setString(4, contato.getTelefone());
			ps.setLong(5, contato.getId());
			
			ps.execute();
			ps.close();
			
			System.out.println("Contato alterado com sucesso.");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public void deletarContato(long id) {
		
		String sql = "delete from agenda where id=?";
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setLong(1, id);
			ps.execute();
			ps.close();
			
			System.out.println("Contato deletado com sucesso.");
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		
	}
	
	public List<Contato> listarContato(){
		
		String sql = "select * from agenda";
		
		List<Contato> contatos = new ArrayList<>();
		
		try {
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
				Contato contato = new Contato();
				contato.setId(rs.getLong("id"));
				contato.setNome(rs.getString("nome"));
				contato.setSobrenome(rs.getString("sobrenome"));
				contato.setIdade(rs.getInt("idade"));
				contato.setTelefone(rs.getString("telefone"));
				
				contatos.add(contato);
				}
			
			rs.close();
		
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return contatos;
		
	}
	
}
