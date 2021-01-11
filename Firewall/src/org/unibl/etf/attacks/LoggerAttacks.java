package org.unibl.etf.attacks;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class LoggerAttacks {
	
	private static File file;
	private static Handler handler = null;
	private static Logger logger = null;	
	public static String logPath = "";
	
	public static final Logger getLogger() {
		if(logger == null) {
			String path = logPath + ".." + File.separator + ".." + File.separator + "wtpwebapps" + File.separator
					+ "Firewall" + File.separator + "WEB-INF" + File.separator + "logger" + File.separator
					+ "attacks.log";
			
			try {
				file = new File(path);
				handler = new FileHandler(file.getAbsolutePath(), true);
				logger = Logger.getLogger("attacks.log");
				logger.addHandler(handler);
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return logger;
	}
}
