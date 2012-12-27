package com.osrufung.irregularverbsapi;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

import javax.jdo.Query;
import com.google.gson.Gson;
 

@SuppressWarnings("serial")
public class IrregularVerbsAPIServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		PersistenceManager pm = PMF.get().getPersistenceManager();
		 
		Query query = pm.newQuery(Verb.class);
		
		int level_int=0;
		try{
			level_int = Integer.parseInt(req.getParameter("level"));
		}catch(Exception e){
			
		}
		
		if(level_int>0){
			query.setFilter("level == "+req.getParameter("level"));
		}
	    
		List verbs = new ArrayList();
		verbs = (List)query.execute();
		
		
		Gson g1 = new Gson();
		
		
		resp.getWriter().println(g1.toJson(verbs));
	}
}
