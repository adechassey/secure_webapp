package ets.secure_webapp.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ets.secure_webapp.entities.User;

@WebFilter({ "/cercle" })
public class CercleFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession();

		User user = (User) session.getAttribute("connectedUser");

		if (!user.getRole().getName().equals("userCercle") && user.isAdmin() == false) {
			System.err.println("[ERROR] - User is not userCercle!");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("home");
			return;
		}

		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
	}

}