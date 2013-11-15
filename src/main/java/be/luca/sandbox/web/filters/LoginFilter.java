/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package be.luca.sandbox.web.filters;

import be.luca.sandbox.web.beans.LoginBean;
import java.io.IOException;
import java.util.Map;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Filters if the LoginBean has the property loggedIn to true.
 *
 * @author Luca
 */
public class LoginFilter implements Filter {
    
    @Inject
    private LoginBean loginBean;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //Do nothing
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
       HttpServletRequest req = (HttpServletRequest) request;

        if (loginBean != null && loginBean.isLoggedIn()) {
            // User is logged in, so just continue request.
            chain.doFilter(request, response);
        } else {
            // User is not logged in, so redirect to index.
            HttpServletResponse res = (HttpServletResponse) response;
            res.sendRedirect(req.getContextPath() + "/login.xhtml");
        }
    }

    @Override
    public void destroy() {
        //Do nothing
    }
}
