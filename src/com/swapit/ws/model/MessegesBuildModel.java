package com.swapit.ws.model;

public class MessegesBuildModel {
	
	public static String ACTIVETITLE = "swapit - ativar conta";
	public static String LOCATEPROPOSITION = "swapit - propostas relacionadas a você";
	
	public String activeMessege(String personID){
		String active = "Olá, seja bem vindo ao sistema swapit."
				+ " Antes de começar é necessária a ativação da sua conta."
				+ " Para isso, clique no link a baixo. "
				+ "http://localhost:81/sw_app/#/"+personID;
		
		
		return active;
		
	}

}
