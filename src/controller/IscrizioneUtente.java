package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Utente;
import persistence.connect.DatabaseManager;
import persistence.dao.UtenteDao;

/**
 * Servlet implementation class IscrizioneUtente
 */
@WebServlet("/IscrizioneUtente")
public class IscrizioneUtente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public  IscrizioneUtente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			// TODO Auto-generated method stub
			//response.getWriter().append("Served at: ").append(request.getContextPath());
			RequestDispatcher dispacher = 
					request.getRequestDispatcher("utentePanel.jsp");
			dispacher.forward(request, response);
		
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String username= request.getParameter("username");
			String password = request.getParameter("password");
			String nome = request.getParameter("nome");
			String cognome = request.getParameter("cognome");
			String email = request.getParameter("email");
		

			
			Utente ut = new Utente(username, password, nome, cognome,email);
			 UtenteDao utenteDao= DatabaseManager.getInstance().getDaoFactory().getUtenteDao();
			
			utenteDao.save(ut);
			
			request.setAttribute("utente", ut);
			
			
			
			RequestDispatcher dispacher = 
					request.getRequestDispatcher("utentePanel.jsp");
			dispacher.forward(request, response);
			
			
				
		}
}
