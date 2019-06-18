package it.polito.tdp.porto.model;

import java.util.HashMap;
import java.util.Map;

public class AuthorMap {
	Map<Integer, Author> map = new HashMap<Integer,Author>();
	
	public AuthorMap() {
	}
	
	public void add(Author a) {
		if(!map.containsValue(a))
			map.put(a.getId(), a);
	}
	
	public Author get(int id) {
		return map.get(id);
	}
}
