package org.unibl.etf.attacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

public class CheckRequest {

	public static String XSS_KEYWORD;
	public static String SQLI_KEYWORDS;
	public static Integer MAX_NUMBER_OF_REQUEST;
	public static Integer TIME_OUT;

	public static final boolean checkForAttacks(HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("");
		path = path + ".." + File.separator + ".." + File.separator + "wtpwebapps" + File.separator + "Firewall"
				+ File.separator + "WEB-INF" + File.separator + "properties" + File.separator + "attacks.properties";

		Properties properties = new Properties();

		try {
			properties.load(new FileInputStream(path));
			XSS_KEYWORD = properties.getProperty("XSS_KEYWORDS");
			SQLI_KEYWORDS = properties.getProperty("SQLI_KEYWORDS");
			MAX_NUMBER_OF_REQUEST = Integer.parseInt(properties.getProperty("MAX_NUMBER_OF_REQUEST"));
			TIME_OUT = Integer.parseInt(properties.getProperty("TIME_OUT"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		DoSAttacks.checkHttpSlowAttack(request);

		return SQLInjectionAttack.checkForSQLInjection(request) || XSSAttack.checkForXSS(request)
				|| ParameterTamperingAttack.checkForParameterTampering(request);
	}

}
