package com.swapit.ws.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.swapit.ws.relate.PersonActiveRelate;
import com.swapit.ws.relate.PersonRecoverPass;
import com.swapit.ws.relate.PropositionRelate;

public class RelationServiceStartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		@SuppressWarnings("unused")
		PropositionRelate propRelate = new PropositionRelate();
		//propRelate.start();
		
		PersonActiveRelate perActive = new PersonActiveRelate();
		perActive.start();
		
		PersonRecoverPass perRecover = new PersonRecoverPass();
		perRecover.start();
	}
}
