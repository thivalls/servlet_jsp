package filters;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = { "/admin/*" })
public class FilterAuth implements Filter {

	public FilterAuth() {
	}

	/*
	 * Encerra os processos quando o servidor � padado Ex. Encerrar conex�o com
	 * banco de dados.
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/*
	 * M�todo que faz o filtro em todas as urls
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		String loggedUser = (String) session.getAttribute("logged");
		String urlBefore = req.getServletPath();

		if (loggedUser == null && !urlBefore.equalsIgnoreCase("/admin/ServletLogin")) {
			RequestDispatcher redirect = request.getRequestDispatcher("/index.jsp?url=" + urlBefore);
			request.setAttribute("msg", "Para acessar o dashboard voc� deve estar logado!");
			redirect.forward(request, response);
			return; /* se n�o der o return ele n�o executa o redirecionamento de fato */
		}

		chain.doFilter(request, response);
	}

	/*
	 * Inicia o processo ou recurso quando o servidor sobe o projeto Ex. Iniciar a
	 * conex�o com banco de dados
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
