package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Invito;
import model.Lega;
import model.Utente;
import persistence.connect.DatabaseManager;
import persistence.dao.InvitoDao;
import persistence.dao.LegaDao;

/**
 * Servlet implementation class InvitaUtenteServlet
 */
@WebServlet("/invitaUtente")
public class InvitaUtenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InvitaUtenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long idLega = Long.parseLong(request.getParameter("id"));
		Utente utente = (Utente) request.getSession().getAttribute("utente");
		if(utente != null) {
			InvitoDao invitoDao = DatabaseManager.getInstance().getDaoFactory().getInvitoDao();
			LegaDao legaDao = DatabaseManager.getInstance().getDaoFactory().getLegaDao();
			Lega dacercare = new Lega(idLega, 0.0f, "", "", "");
			Lega lega = legaDao.findByPrimaryKey(dacercare); 
			request.setAttribute("lega", lega);
			List<Invito> inviti = invitoDao.getInvitiPerLega(utente.getEmail(), idLega);
			request.setAttribute("inviti", inviti);
			request.getRequestDispatcher("/WEB-INF/pagine/invitaUtente.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Un utente invita un altro utente ad iscriversi alla lega da lui creata.
	}

}
