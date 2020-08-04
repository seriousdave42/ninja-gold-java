package com.dwatkins.ninjagold;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	@RequestMapping("/gold")
	public String gold(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		if (currentGold == null) {
			currentGold = 0;
		}
		if (actionLog == null) {
			actionLog = new ArrayList<String>();
		}
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "gold.jsp";
	}
	
	@RequestMapping(value="/gold", method=RequestMethod.POST)
	public String turn(@RequestParam(value="turn") String turn, HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		int randomGold = 0;
		String message = "";
		if (turn.equals("farm")) {
			randomGold = ThreadLocalRandom.current().nextInt(10,21);
			message = "You farmed and earned " + randomGold + " gold.";
		}
		else if (turn.equals("cave")) {
			randomGold = ThreadLocalRandom.current().nextInt(5,11);		
			message = "You spelunked and earned " + randomGold + " gold.";
		}
		else if (turn.equals("house")) {
			randomGold = ThreadLocalRandom.current().nextInt(2,6);		
			message = "You lounged and earned " + randomGold + " gold.";
		}
		else {
			randomGold = ThreadLocalRandom.current().nextInt(-50,51);		
			message = "You gambled and earned " + randomGold + " gold.";
		}
		currentGold += randomGold;
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
}
