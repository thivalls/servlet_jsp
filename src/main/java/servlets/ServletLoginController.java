package servlets;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Login;

@WebServlet("/ServletLogin") /* mapeamento da url */
public class ServletLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletLoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("name");
		String password = request.getParameter("password");
		String url = request.getParameter("url");

		if (url == null || url.equals("null")) {
			url = "admin/dashboard.jsp";
		}

		if (user != null && !user.isEmpty() && password != null && !password.isEmpty()) {
			Login auth = new Login(user, password);
			if (auth.login()) {
				if (request.getSession().getAttribute("logged") == null
						|| (request.getSession().getAttribute("logged") != null
								&& request.getSession().getAttribute("logged").toString().isEmpty())) {
					request.getSession().setAttribute("logged", auth.getUser());
				}

				RequestDispatcher redirect = request.getRequestDispatcher(url);
				request.setAttribute("user", "Fulano");
				redirect.forward(request, response);
			} else {
				RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
				request.setAttribute("msg", "Usuário ou senha inválidos ou em branco!");
				redirect.forward(request, response);
			}

		} else {
			RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
			request.setAttribute("msg", "Usuário ou senha inválidos ou em branco!");
			redirect.forward(request, response);
		}
	}

	private void redirectBack(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher redirect = request.getRequestDispatcher("index.jsp");
		request.setAttribute("msg", "Usuário ou senha inválidos ou em branco!");
		redirect.forward(request, response);
		return;
	}

}
