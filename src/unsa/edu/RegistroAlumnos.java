package unsa.edu;

import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

import javax.jdo.PersistenceManager;
import javax.servlet.http.*;

@SuppressWarnings("serial")
public class RegistroAlumnos extends HttpServlet {
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		      
		PersistenceManager pm = PMF.get().getPersistenceManager();
		
		String cui = req.getParameter("cui");
		String nombre = req.getParameter("nombre");
		String apellidoPaterno = req.getParameter("apellidoPaterno");
		String apellidoMaterno = req.getParameter("apellidoMaterno");
		
		try {
			Alumnos alu = new Alumnos(cui, nombre, apellidoPaterno, apellidoMaterno);
			pm.makePersistent(alu);
			resp.getWriter().print("GUARDADO\n" + alu.toString());
		} catch (Exception e) {
			resp.getWriter().print("ERROR");
		} finally {
			pm.close();
		}
	}
}
