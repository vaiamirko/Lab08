package it.polito.tdp.dizionariograph.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordDAO {

	/*
	 * Ritorna tutte le parole di una data lunghezza
	 */
	public List<String> getAllWordsFixedLength(int length) {

		String sql = "SELECT nome FROM parola WHERE LENGTH(nome) = ?;";
		List<String> parole = new ArrayList<String>();

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, length);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				parole.add(res.getString("nome"));
			}

			return parole;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error Connection Database");
		}
	}
	
	public List<String> parolevicine(String parola, List<String> parolevicine) {
		
		
		List<String> parole = new ArrayList<String>();
		Map<String,String> mappaparole=new HashMap<String,String>();
		String sql = "SELECT nome  " + 
				"FROM parola  " + 
				"WHERE nome LIKE ? ";
		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);
			ResultSet res = st.executeQuery();

			while (res.next()) {
				
				if(parolevicine.contains((res.getString("nome")))==true || parola.equals((res.getString("nome")))==true)
					continue;
				parole.add(res.getString("nome"));
				
			}

			return parole;

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Error Connection Database");
		}
	}
	

}
