package org.unibl.etf.attacks;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Base64;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.stream.Collectors;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


public class ParameterTamperingAttack {

	private static boolean flag = false;

	public static boolean checkForParameterTampering(HttpServletRequest request) {
		flag = false;
		checkSession(request);
		checkParameterNames(request);
		return flag;
	}
	
	private static void checkSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if(session != null) {
			request.getSession().getAttributeNames().asIterator().forEachRemaining(a -> {
				if(request.getSession().getAttribute(a) != null && request.getSession().getAttribute(a) instanceof String) {
					String username = request.getSession().getAttribute(a).toString();
				} else {
					flag = true;
					LoggerAttacks.getLogger().log(Level.WARNING,"ParameterTamperingAttack in session, in parameter: !"+request.getSession().getAttribute(a).toString());
				}
			});
		}
		
	}
			
	private static void checkParameterNames(HttpServletRequest request) {
		Enumeration<String> parameter = request.getParameterNames();
		while (parameter.hasMoreElements()) {
			String temp = parameter.nextElement();
			if (request.getParameter(temp) != null) {
				if ("j_username".equals(temp)) {
					checkString(temp, request.getParameter(temp));
					checkLetterAndNumForUsername(temp, request.getParameter(temp));
				} else if ("j_password".equals(temp)) {
					checkString(temp, request.getParameter(temp));
				} else if ("name".equals(temp)) {
					checkString(temp, request.getParameter(temp));
				} else if ("price".equals(temp)) {
					checkDouble(temp, request.getParameter(temp));
				} 
			}
		}
	}
	
	private static void checkString(String parm, String value) {
		if (value == null) {
			flag = true;
			LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
		}
	}

	private static void checkInteger(String parm, String value) {
		try {
			int number = Integer.parseInt(value);
			if (number <= 0 || number > 3) {
				flag = true;
				LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
			}
		} catch (NumberFormatException e) {
			flag = true;
			LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
		}
	}
	
	private static void checkLetterAndNumForUsername(String parm, String value) {
		if (value == null || !value.matches("^[a-zA-Z0-9]*$")) {
			flag = true;
			LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
		}
	}

	private static void checkDouble(String parm, String value) {
		try {
			double number = Double.parseDouble(value);
			if (number <= 0.0 || number > Double.MAX_VALUE) {
				flag = true;
				LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
			}
		} catch (Exception e) {
			flag = true;
			LoggerAttacks.getLogger().log(Level.WARNING, "ParameterTamperingAttack in parameter: "+ parm);
		}
	}





}
