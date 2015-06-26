package unsa.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RelacionAlumnos extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		      
		PersistenceManager pm = PMF.get().getPersistenceManager();
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		
		Query q = pm.newQuery(Alumnos.class);
		
		try{
			List<Alumnos> alu = (List<Alumnos>) q.execute();
			out.println("Lista de Alumnos \n <ul>");
			for(Alumnos p: alu){
				out.println(p.toString() + "<br>");
			}
			out.println("<ul>");
		}catch(Exception e){
			out.println("Ups .. ERROR");
		}finally{
			 q.closeAll();
		}
	}
}
