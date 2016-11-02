package com.swapit.ws.service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.swapit.ws.relate.PropositionRelate;

public class RelationServiceStartServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void init() throws ServletException{
		PropositionRelate propRelate = new PropositionRelate();
		//propRelate.start();
	}
}
