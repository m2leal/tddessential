package com.algaworks.camel_case;

public class CamelCaseConverter {

	public String converter(String nome) {
		String[] arrayDeNomes = nome.split(" ");
		for(int i = 0; i <= arrayDeNomes.length-1; i++) {
			arrayDeNomes[i] = arrayDeNomes[i].substring(0, 1).toUpperCase() + arrayDeNomes[i].substring(1).toLowerCase();
		}
		return String.join(" ", arrayDeNomes);
	}
	
}
