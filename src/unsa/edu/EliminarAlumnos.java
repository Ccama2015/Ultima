package unsa.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class EliminarAlumnos extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Alumnos.class);
		
		String cui = req.getParameter("cui");
		q.setFilter("cui == cuiParam");
		q.declareParameters("String cuiParam");
		
		try{
			List<Alumnos> alu = (List<Alumnos>) q.execute(cui);
			resp.getWriter().println("<p>EXITO AL BORRAR</p>");
			resp.getWriter().println("<p>El siguiente Alumno</p>");
			for(Alumnos p: alu){
				resp.getWriter().println(p.toString());
				pm.deletePersistent(p);
			}
			resp.getWriter().println("<ul>");
		}catch(Exception e){
			resp.getWriter().print("Ups .. ERROR");
		}finally{
			 q.closeAll();
		}
	}
}
