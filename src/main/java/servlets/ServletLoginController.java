package servlets;

import java.io.IOException;

import daos.LoginRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Login;

@WebServlet(urlPatterns = { "/admin/ServletLogin", "/ServletLogin" }) /* mapeamento da url */
public class ServletLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLoginController() {
		super();
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			Login login = new Login(request.getParameter("name"), request.getParameter("password"));
			String url = request.getParameter("url");
	
			if (url == null || url.equals("null")) {
				url = "admin/dashboard.jsp";
			}
	
			if (login.getUser() != null && !login.getUser().isEmpty() && login.getPassword() != null && !login.getPassword().isEmpty()) {
				LoginRepository auth = new LoginRepository();
					if (auth.login(login)) {
						if (request.getSession().getAttribute("logged") == null
								|| (request.getSession().getAttribute("logged") != null
										&& request.getSession().getAttribute("logged").toString().isEmpty())) {
							request.getSession().setAttribute("logged", login.getUser());
						}
	
						RequestDispatcher redirect = request.getRequestDispatcher(url);
						request.setAttribute("user", login.getUser());
						redirect.forward(request, response);
						return;
					}
	
				this.redirectBack(request, response);
			}
	
			this.redirectBack(request, response);
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			RequestDispatcher redirect = request.getRequestDispatcher("error.jsp");
			request.setAttribute("message", e.getMessage());
			redirect.forward(request, response);
			return;
		}
	}

	private void redirectBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp");
		request.setAttribute("msg", "Usuário ou senha inválidos ou em branco!");
		redirect.forward(request, response);
		return;
	}

}
