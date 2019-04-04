package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class AnagrammaDAO {

	public boolean isValida(String s) 
	{
		String sql = "SELECT * FROM parola WHERE nome = ?";
		try
		{
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, s);
			ResultSet rs = st.executeQuery();
			boolean res = false;

			//risultato di una sola riga
			if (rs.next()) 
				res = true;
			
			conn.close();
			return res;
		}
		catch (SQLException e) 
		{
			 e.printStackTrace();
			throw new RuntimeException("Errore Db");
		}
	}

}
