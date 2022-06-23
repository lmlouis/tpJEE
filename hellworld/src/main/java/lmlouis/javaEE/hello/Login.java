package lmlouis.javaEE.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }
    // doGet =  requête du serveur vers le navigateur
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("textLogin");
		String password = request.getParameter("textPassword");
		if(login==null) login="";
		if(password==null) password="";
	    // créer une session si elle n'existe pas 
		HttpSession session =  request.getSession(true);
		// stockage des clés/valeurs
		session.setAttribute("login", login);
		session.setAttribute("password", password);
		// Redirection vers le jsp : appel de la page jsp 
		request.getRequestDispatcher("/login.jsp").forward(request, response);
		
		
	}
	// doPost =  requête du navigateur vers le serveur
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// Réccuper les informations du formulaire 
		String login = request.getParameter("textLogin");
		String password = request.getParameter("textPassword");
		if(login.equals("admin") && password.equals("admin")) {
            response.setContentType( "text/html" );
            try ( PrintWriter out = response.getWriter() ) {
                out.println("ok");
            }
        } else {
            doGet( request, response );
        }
    }

}
