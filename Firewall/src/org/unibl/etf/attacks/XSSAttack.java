package org.unibl.etf.attacks;

import java.util.Enumeration;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;



public class XSSAttack {
	
	private static Pattern pattern = Pattern.compile(CheckRequest.XSS_KEYWORD);	
	private static boolean flag = false;
	
		
	public static boolean checkForXSS(HttpServletRequest request) {
		flag = false;
		checkURL(request);
		checkParameterNames(request);
		checkSession(request);
		checkQueryString(request);
		return flag;
	}
	
	private static void checkURL(HttpServletRequest request) { // npr: xss_r/?name=<script>alert(document.cookie)</script>
		String url = request.getRequestURL().toString();
		Matcher matcher = pattern.matcher(url);
		if (matcher.find()) {
			LoggerAttacks.getLogger().log(Level.WARNING, "XSS attack in url '"+url+"' from address "+request.getRemoteAddr());
           flag = true;
        }
	}
	
	
	private static void checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			request.getSession().getAttributeNames().asIterator().forEachRemaining(a -> {
				if(request.getSession().getAttribute(a) != null && request.getSession().getAttribute(a) instanceof String) {
					String username = request.getSession().getAttribute(a).toString();
					Matcher matcher = pattern.matcher(username);
					if(matcher.find()) {
						flag = true;
						LoggerAttacks.getLogger().log(Level.WARNING, "XSS attack in session: "+ username + "from address: "+request.getRemoteAddr());
					}
				}
			});
		}
		
	}
	
	private static void checkQueryString(HttpServletRequest request) { // sve poslije upitnika
		String query = request.getQueryString();
		//System.out.println("QUERY STRING"+query); // treba da bude oblika: &?<parameterName>= // npr: &?<parameterName>=<script>%20alert(%27poruka%27)</script>
		if(query != null) {
			Matcher matcher = pattern.matcher(query);
			if(matcher.find()) {
				LoggerAttacks.getLogger().log(Level.WARNING, "XSS attack in query string '"+query+"' from address: "+request.getRemoteAddr());
				flag = true;
			}
		}
	}
	
	private static void checkParameterNames(HttpServletRequest request) { // provjera za forme
		Enumeration<String> parameter = request.getParameterNames();
		while(parameter.hasMoreElements()) {
			String param = parameter.nextElement();
			if(request.getParameter(param) != null) {
				Matcher matcher = pattern.matcher(request.getParameter(param));
				if(matcher.find()) {
					flag = true;
					LoggerAttacks.getLogger().log(Level.WARNING, "XSS attack in parameter '"+param+"' from address "+request.getRemoteAddr());
				}
			}
		}
	}

}
