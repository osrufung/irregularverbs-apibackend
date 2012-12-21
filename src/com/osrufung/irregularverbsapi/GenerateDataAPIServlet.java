package com.osrufung.irregularverbsapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@SuppressWarnings("serial")
public class GenerateDataAPIServlet  extends HttpServlet  {
public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		List lista = new ArrayList();
		
		
		Verb v1 = new Verb("become","became","become","llegar a ser");
		lista.add(v1);
		Verb v2 = new Verb("begin","began","begun","empezar");
		lista.add(v2);
		try{
		pm.makePersistentAll(lista);
		}finally{
			pm.close();
		}
		resp.setContentType("text/plain");
		resp.getWriter().println("Generated data");
}
}
