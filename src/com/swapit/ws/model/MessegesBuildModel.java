package com.swapit.ws.model;

public class MessegesBuildModel {
	
	public static String ACTIVETITLE = "swapit - ativar conta";
	
	public String activeMessege(String personID){
		String active = "Ol�, seja bem vindo ao sistema swapit."
				+ " Antes de come�ar � necess�ria a ativa��o da sua conta."
				+ " Para isso, clique no link a baixo. "
				+ "http://localhost:8080/swapitws/rs/person/active/"+personID;
		
		
		return active;
		
	}

}
