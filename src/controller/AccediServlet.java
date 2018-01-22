package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Utente;
import persistence.connect.DatabaseManager;
import persistence.dao.UtenteDao;

/**
 * Servlet implementation class AccediServlet
 */
@WebServlet("/AccediServlet")
public class AccediServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccediServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String nome =request.getParameter("nome");
		String cognome = request.getParameter("cognome");
		String email =request.getParameter("email");
		PrintWriter out = response.getWriter();
		
		Utente ut = new Utente(username, password, nome, cognome,email);
		UtenteDao utenteDao =DatabaseManager.getInstance().getDaoFactory().getUtenteDao();
		Utente esistente=utenteDao.getUtente(username);
		
		if(esistente != null && esistente.getPassword() != null && esistente.getPassword().equals(password)) {
			out.print("utente valido");
			request.getSession().setAttribute("utente" ,ut);
			request.getSession().setAttribute("username", ut.getNome());
			response.sendRedirect("utentePanel.jsp");
		}
		else
			response.sendRedirect("ErrorePag.jsp");
			
		out.close();
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
