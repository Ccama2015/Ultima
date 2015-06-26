package unsa.edu;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;
import javax.servlet.http.*;



@SuppressWarnings("serial")
public class ModificarNombre extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query q = pm.newQuery(Alumnos.class);
		
		String cui = req.getParameter("cui");
		String nombre = req.getParameter("nombre");
		q.setFilter("cui == cuiParam");
		q.declareParameters("String cuiParam");
		
		try{
			List<Alumnos> alu = (List<Alumnos>) q.execute(cui);
			resp.getWriter().println("<p>EXITO EN CAMBIAR</p>");
			resp.getWriter().println("<p>El siguiente nombre</p>");
			for(Alumnos p: alu){
				resp.getWriter().println(p.toString() + "\n");
				resp.getWriter().println("<p>Se modifico" + p.getNombre() + " por " + nombre);
				p.setNombre(nombre);
			}
		}catch(Exception e){
			resp.getWriter().print("Ups .. ERROR");
		}finally{
			 q.closeAll();
		}
	}
}
