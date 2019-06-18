package it.polito.tdp.porto.model;

import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;

import it.polito.tdp.porto.db.PortoDAO;

public class Model {
	
	PortoDAO dao = new PortoDAO();
	AuthorMap am = new AuthorMap();
	List<Author> autori = new LinkedList<Author>();
	SimpleGraph<Author,DefaultEdge> grafo = new SimpleGraph<Author,DefaultEdge>(DefaultEdge.class);
	
	public Model() {
		autori.addAll(dao.getAllAutori(am));
	}
	
	public void creaGrafo() {
		
		Graphs.addAllVertices(grafo, autori);
		for(Author v : grafo.vertexSet()) 
			for(Author co : dao.getCoautori(v, am)) 
				if(!grafo.containsEdge(v, co))
						grafo.addEdge(v, co);
		System.out.println(grafo.vertexSet().size() + " "+ grafo.edgeSet().size());
	}
	
	public List<Author> getAllAutori(){
		return autori;
	}
	
	public List<Author> getCoautori(Author a) {
		List<Author> coAutori = new LinkedList<Author>();
		for(Author c : grafo.vertexSet())
			if(grafo.containsEdge(a,c))
				coAutori.add(c);
		return coAutori;
	}
	
	
	

}
