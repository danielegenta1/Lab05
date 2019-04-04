package it.polito.tdp.anagrammi.model;

import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.AnagrammaDAO;

public class Model 
{	
	//utilizzo un set in quanto non ammette duplicati
	Set<String> soluzioni;
	
	public Set<String> allAnagrammi(String input)
	{
		// genera
		String parziale = "";
		soluzioni = new HashSet<String>();
		this.cerca(parziale, input, 0);
		return soluzioni;
	}

	/**
	 * Metodo ricorsivo, si parte dalla stringa in input e si costruiscono tutti gli anagrammi
	 * 
	 * NOTA: nel caso di lettere multiple (es. mamma) occorre una scrematura post-ricorsione dato che
	 * 		anche se si tratta della stessa lettera, trovandosi in posizione diversa, verrà riconosciuta come
	 * 		altra lettera e verranno perciò creati dei duplicati
	 * @param parziale, soluzione parziale
	 * @param input, parola data da utente
	 * @param L, livello
	 */
	private void cerca(String parziale,String input, int L)
	{
		//terminazione
		if (L == input.length())
		{
			System.out.println(parziale);
			if (!soluzioni.contains(parziale))
				soluzioni.add(parziale);
			return;
		}
		//per ogni lettera controllo se ne ho già inserite abbastanza nella soluzione parziale
		for (int i = 0; i < input.length(); i++) 
		{
			if (charCounter(parziale, input.charAt(i)) < charCounter(input, input.charAt(i)))
			{
				parziale += input.charAt(i);
				
				//recursion
				cerca(parziale, input, L+1);
				
				//backtrack (potrei utilizzare una stringa ausiliaria, più leggibile)
				parziale = parziale.substring(0, parziale.length()-1);
			}
		}
	}
	
	/**
	 * Conta le occorrenze di una lettera in una parola
	 * @param s
	 * @param c
	 * @return
	 */
	public int charCounter(String s, char c)
	{
		int count = 0;
		for (int  i = 0; i < s.length(); i++)
		{
			if (s.charAt(i) == c)
				count++;
		}
		return count;
		
	}

	/**
	 * Cerco sul db se esiste la parola 
	 * @param s
	 * @return
	 */
	public boolean isValida(String s) 
	{
		AnagrammaDAO dao = new AnagrammaDAO();
		return dao.isValida(s);
	}

	

}
