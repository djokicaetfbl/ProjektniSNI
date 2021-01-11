package org.unibl.etf.firewall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.valves.ValveBase;
import org.unibl.etf.attacks.DoSAttacks;
import org.unibl.etf.attacks.LoggerAttacks;
import org.unibl.etf.attacks.CheckRequest;

import jdk.jfr.internal.PrivateAccess;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;


public class Firewall extends ValveBase {
	
	private static final String  ADMINSNIAPP = "/AdminSNIApp/j_security_check";
	private static final String ADMINLWSNIAPP = "/AdminLWSNIApp/j_security_check";
	private static final String WEBSHOPSNIApp = "/WebShopSNIApp/j_security_check";
	private static String tmp = "";
	

	@Override
	public void invoke(Request arg0, Response arg1) throws IOException, ServletException {
		
		if(arg0.getRequestURI().equals(ADMINSNIAPP) || arg0.getRequestURI().equals(ADMINLWSNIAPP) || arg0.getRequestURI().equals(WEBSHOPSNIApp) ) {
			
			String jUsername = arg0.getParameter("j_username");
			HttpSession session = arg0.getSession();
			session.setAttribute("username", jUsername);
			session.setAttribute("username", "<script> alert('poruka')</script>");
			//session.setAttribute("username", "select * from user");
			//session.setAttribute("username", new Object());
			
			if(arg0.getRequestURI().equals(ADMINSNIAPP)) {
				tmp = "/AdminSNIApp/";
			} else if(arg0.getRequestURI().equals(ADMINLWSNIAPP)) {
				tmp = "/AdminLWSNIApp";
			} else if(arg0.getRequestURI().equals(WEBSHOPSNIApp)) {
				tmp = "/WebShopSNIApp/detectedAttack";
			}
		}		
		
		//System.out.println("POZIV NA FIREWALL: "+arg0.getParameter("action"));
		
		if ("".equals(LoggerAttacks.logPath)) {
			LoggerAttacks.logPath = arg0.getServletContext().getRealPath("");
		}
		
		boolean isAttack = false;
		
		if(!arg0.equals(null)) {		
			isAttack = CheckRequest.checkForAttacks(arg0);
			//System.out.println("Ovaj zahtjev je ka "+arg0.getRequestURI());
		}
		
		synchronized (DoSAttacks.lock) {
			if (DoSAttacks.isHttpSlowAttack) {
				//System.out.println("JESTE DOS ATTACK");
				isAttack = true;
			}
		}
		
		if (!isAttack) {
		getNext().invoke(arg0, arg1);
		}
		else {
			
			OutputStream outputStream = arg1.getOutputStream();
			outputStream.write("Action is not allowed ! ".getBytes());
			outputStream.flush();
			outputStream.close();
			
		}
	}
	

}