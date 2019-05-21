package it.polito.tdp.dizionariograph.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.DefaultUndirectedGraph;
import org.jgrapht.graph.SimpleDirectedGraph;

import it.polito.tdp.dizionariograph.db.WordDAO;

public class Model {
	
	private Graph<String,DefaultEdge> grafo;
	private List<String> parole;
	private Map<String,String> mappaparole;

	public void createGraph(int numeroLettere) {
		
		// creo i vertici del grafo che non sono altro che le parole del dizionario
		this.grafo = new DefaultUndirectedGraph<>(DefaultEdge.class);
		//ho creato il grafo vuoto ma del tipo giusto
		
		WordDAO dao=new WordDAO();
		
		parole=new ArrayList<String>(dao.getAllWordsFixedLength(numeroLettere));//creo la lista di parole di una certa lunghezza di lettere
		
		//uso la libreria graphs per popolare i vertici
		Graphs.addAllVertices(grafo, parole);
		
		//aggiungo gli archi 
		
		
		
		/*for(String s: this.grafo.vertexSet()) {
			int i;
			String sb=new String (s);
			char[] temp = sb.toCharArray();
			List<String> parolevicine=new ArrayList<String>();
			for(i=0;i<s.length();i++) {
				String sinvio;
				temp[i]='_';
				sinvio=new String(temp);
				parolevicine.addAll(dao.parolevicine(sinvio,parolevicine));
				 temp = sb.toCharArray();
			}
			for(String si : parolevicine) {
				if(grafo.containsEdge(s, si)==false && !s.equals(si))
				this.grafo.addEdge(s, si);
				
			}
		}
		*/
		//metodo solo lavorando in java
		for(String vertice: this.grafo.vertexSet()) {
			for(String parolavicina:parole) {
				if(!vertice.equals(parolavicina) && this.controlladifferenza(vertice, parolavicina)==true && grafo.containsEdge(vertice, parolavicina)==false )
					this.grafo.addEdge(vertice, parolavicina);
			}
		}
		

		System.err.println("createGraph -- TODO");
	}

	public List<String> displayNeighbours(String parolaInserita) {
		List<DefaultEdge> archivertice=new ArrayList<DefaultEdge>(this.grafo.edgesOf(parolaInserita));
		List<String> vicini =new ArrayList<String>();
		for(DefaultEdge e:archivertice) {
			if(!grafo.getEdgeTarget(e).equals(parolaInserita))
			vicini.add(grafo.getEdgeTarget(e));//aggiungo le parole che sono target degli archi della parola vertice
		//solo se sono diverse dalla parola vertice perchè conta gli archi da entrambe le parti
			
			
			
		}
		

		System.err.println("displayNeighbours -- TODO");
		return vicini;
	}

	public int findMaxDegree() {
		String vincitore="";
			int maxdegree=0;
		for(String vertice: this.grafo.vertexSet()) {
			if(grafo.degreeOf(vertice)>maxdegree) {
				maxdegree=grafo.degreeOf(vertice);
				vincitore=vertice;
			}
		}
		
		
		
		System.err.println("findMaxDegree -- TODO");
		return maxdegree;
	}
	public boolean controlladifferenza(String parola1 , String parola2) {
		int count=0;
		int i;
		for(i=0;i<parola1.length();i++) {
			if((parola1.charAt(i)) != (parola2.charAt(i)))

					count++;
		}
		
		if(count<=1)
			return true;
		else
			return false;
		
				
					

				
			
		}
	public boolean controlladifferenza2(String parola1 , String parola2) {
		char[] temp1 = parola1.toCharArray();
		char[] temp2 = parola2.toCharArray();
		int count=0;
		int i;
		for(i=0;i<parola1.length();i++) {
			if(temp1[i]!= temp2[i])
					count++;
		}
		
		if(count<=1)
			return true;
		else
			return false;
			
		}

	
	
}
