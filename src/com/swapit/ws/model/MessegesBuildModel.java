package com.swapit.ws.model;

public class MessegesBuildModel {
	
	public static String ACTIVETITLE = "swapit - ativar conta";
	public static String LOCATEPROPOSITION = "swapit - propostas relacionadas a você";
	public static String RECOVERPASS = "swapit - reculperar senha";
	
	public String activeMessege(String personID){
		String active = "Olá, seja bem vindo ao sistema swapit."
				+ " Antes de começar é necessária a ativação da sua conta."
				+ " Para isso, clique no link a baixo. "
				+ "http://localhost:81/sw_app/#/"+personID;
		
		
		return active;
		
	}
	
	public String recoverPass(String personID){
		String recover =  "Clique no link abaxo para reculperar sua senha"
				+ "http://localhost:81/sw_app/#/recoverpass/"+personID;
		
		
		return recover;
	}

}
