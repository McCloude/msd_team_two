package com.bah.msd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.bah.msd.util.ApiLogger;
import com.bah.msd.util.JWTHelper;

@Component
@Order(1)
public class AuthFilter implements Filter {

	// public static Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
	private static final String AUTH_SCOPE = "com.bah.msd.auth.apis";
	private static final String API_SCOPE = "com.bah.msd.data.apis";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// get authorization header
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String uri = req.getRequestURI();

		// for development purposes
		// allow turning off auth checking with header tokencheck:false
		String tokenheader = req.getHeader("tokencheck");
		if (tokenheader != null && !tokenheader.equalsIgnoreCase("true")) {
			chain.doFilter(request, response);
			return;
		}

		// auth checking will not apply to these cases
		// token endpoint
		// user register endpoint
		// healthcheck endpoint on '/api/'
		if (!uri.startsWith("/api/events") && !uri.startsWith("/api/registrations") && !uri.equals("/api/customers")) {
			chain.doFilter(request, response);
			return;
		} else {
			// check JWT token
			String authheader = req.getHeader("authorization");
			if (StringUtils.length(authheader) > 7 && authheader.startsWith("Bearer")) {
				String jwt_token = authheader.substring(7, authheader.length());
				if (JWTHelper.verifyToken(jwt_token)) {
					String requestScopes = JWTHelper.getScopes(jwt_token);
					if (StringUtils.containsAny(requestScopes, API_SCOPE, AUTH_SCOPE)) {
						chain.doFilter(request, response);
						return;
					}
				}
			}
		}
		// continue
		res.sendError(HttpServletResponse.SC_FORBIDDEN, "failed authentication");

	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		ApiLogger.log("AuthFilter.init");

	}

	@Override
	public void destroy() {
		ApiLogger.log("AuthFilter.destroy");
	}

	/*
	 * public boolean verifyToken(String token) { try {
	 * Jwts.parser().setSigningKey(key).parseClaimsJws(token); return true; } catch
	 * (JwtException e) { return false; } }
	 * 
	 * public String getScopes(String token) { try { Claims claims =
	 * Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody(); String
	 * scopes = claims.get("scopes", String.class); return scopes; } catch
	 * (JwtException e) { return null; } }
	 */

}