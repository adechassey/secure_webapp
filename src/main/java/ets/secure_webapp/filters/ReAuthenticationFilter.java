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

/**
 * All paths below will be filtered and prompted for password
 */
@WebFilter({ "/administration", "/setPassword", "/addUser" })

public class ReAuthenticationFilter implements Filter {

	private Boolean isReAuthenticateSuccess;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		HttpSession session = httpRequest.getSession();

		isReAuthenticateSuccess = (Boolean) session.getAttribute("isReAuthenticateSuccess");
		if (!isReAuthenticateSuccess) {
			System.err.println("[ERROR] - User is not re-authenticate!");
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			httpResponse.sendRedirect("reauthenticate");
			return;
		}

		// Before servlet
		chain.doFilter(request, response);
		// After servlet

	}

	@Override
	public void destroy() {
	}

}
