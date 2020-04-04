package by.delivery.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/")
public class AuthenticationFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        if (servletRequest instanceof HttpServletRequest) {
            if (userAlreadyLoggedIn(servletRequest)) {
                allowAccess(servletRequest, servletResponse, filterChain);
            } else {
                sendBack(servletRequest, servletResponse);
            }
        }
    }

    private void sendBack(ServletRequest servletRequest, ServletResponse servletResponse) throws IOException {
        String previousUrl = ((HttpServletRequest) servletRequest).getHeader("Referer");
        ((HttpServletResponse) servletResponse).sendRedirect(previousUrl);
    }

    private void allowAccess(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        filterChain.doFilter(servletRequest, servletResponse);
    }

    private boolean userAlreadyLoggedIn(ServletRequest httpRequest) {
        return ((HttpServletRequest) httpRequest).getSession().getAttribute("currentUser") != null;
    }

    @Override
    public void destroy() {

    }
}