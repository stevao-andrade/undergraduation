/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package cpi.filtros;

import java.io.IOException;
import javax.servlet.*;

/**
 *
 * @author stevao
 * 
 * Resolver o problema de acentuação de caracteres.
 */
public class EncodingFilter implements Filter {

	private String encoding = "utf-8";

    @Override
	public void doFilter(ServletRequest request,

	ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
		request.setCharacterEncoding(encoding);
		filterChain.doFilter(request, response);
	}

    @Override
	public void init(FilterConfig filterConfig)

	throws ServletException {
		String encodingParam = filterConfig.getInitParameter("encoding");
		if (encodingParam != null) {
			encoding = encodingParam;
		}
	}

    @Override
	public void destroy() {
		// nothing todo
	}

}
