package require4test.filter;

import jakarta.inject.Inject;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import require4test.services.UserManagementService;

import java.io.IOException;

@WebFilter("*.xhtml")
public class LoginFilter extends HttpFilter {

    @Inject
    UserManagementService userManagementService;

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        String requestURI = request.getRequestURI();
        if (requestURI.endsWith("login.xhtml")) {
            chain.doFilter(request, response);
            return;
        }
        if (userManagementService.getCurrentUser() == null) {
            response.sendRedirect(request.getContextPath() + "/login.xhtml");
        } else {
            chain.doFilter(request, response);
        }
    }
}
