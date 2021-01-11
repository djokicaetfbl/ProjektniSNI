package org.unibl.etf.attacks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;

public class DoSAttacks {

	public static final Object lock = new Object();
	public static boolean isHttpSlowAttack = false;
	private static final Map<String, Integer> requestFromRemoteAddress = new HashMap<String, Integer>();

	private static Timer timer;
	static {

		timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				synchronized (DoSAttacks.lock) {
					if (LoggerAttacks.getLogger() != null) {
						requestFromRemoteAddress.entrySet().stream()
								.filter(f -> f.getValue() >= CheckRequest.MAX_NUMBER_OF_REQUEST).forEach(address -> {
									LoggerAttacks.getLogger().log(Level.WARNING,
											"Http slow attack from: " + address.getKey());
									isHttpSlowAttack = true;
								});
						requestFromRemoteAddress.clear();
					}
				}
			}
		}, 0, CheckRequest.TIME_OUT);
	}

	public static void checkHttpSlowAttack(HttpServletRequest request) {
		synchronized (DoSAttacks.lock) {
				if (!requestFromRemoteAddress.containsKey(request.getRemoteAddr())) {
					requestFromRemoteAddress.put(request.getRemoteAddr(), 1);

				} else {
					requestFromRemoteAddress.merge(request.getRemoteAddr(), 1, (a, b) -> a + b);
				}

				if (requestFromRemoteAddress.get(request.getRemoteAddr()) > CheckRequest.MAX_NUMBER_OF_REQUEST) {
					LoggerAttacks.getLogger().log(Level.WARNING,
							"Http slow attack from: " + request.getRemoteAddr());
					isHttpSlowAttack = true;
					requestFromRemoteAddress.remove(request.getRemoteAddr());
				}

		}
	}
}