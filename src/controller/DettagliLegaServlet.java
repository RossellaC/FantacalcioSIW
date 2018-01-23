package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Lega;
import model.Squadra;
import model.Utente;
import persistence.connect.DatabaseManager;
import persistence.dao.LegaDao;
import persistence.dao.SquadraDao;

/**
 * Servlet implementation class DettagliLegaServlet
 */
@WebServlet("/dettagliLega")
public class DettagliLegaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DettagliLegaServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idLega = Long.parseLong(request.getParameter("id"));
		Utente loggato = (Utente) request.getSession().getAttribute("utente"); 
		LegaDao legaDao = DatabaseManager.getInstance().getDaoFactory().getLegaDao();
		Lega l = new Lega(idLega, 0.0f, "", "", loggato.getEmail());
		Lega lega = legaDao.findByPrimaryKey(l);
		if(lega.getFkUtente().equals(loggato.getEmail())) {
			SquadraDao squadraDao = DatabaseManager.getInstance().getDaoFactory().getSquadraDao();
			List<Squadra> squadre = squadraDao.getSquadreLega(idLega);
			request.setAttribute("lega", lega);
			request.setAttribute("squadre", squadre);
			request.getRequestDispatcher("/WEB-INF/pagine/dettagliLega.jsp").forward(request, response);
		} else {
			response.sendRedirect("ErrorePag.jsp");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
