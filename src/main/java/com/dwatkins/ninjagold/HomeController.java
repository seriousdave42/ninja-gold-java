package com.dwatkins.ninjagold;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
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
		if (currentGold > -50) {
			return "gold.jsp";			
		}
		else {
			return "redirect:/prison";
		}
	}
	
	@RequestMapping("/prison")
	public String prison(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		if (currentGold == null || currentGold > -50) {
			return "redirect:/gold";
		}
		else {
			return "prison.jsp";			
		}
	}
	
	@RequestMapping(value="/farm", method=RequestMethod.POST)
	public String farm(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		LocalDateTime logTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
		String timeString = formatter.format(logTime);
		int randomGold = ThreadLocalRandom.current().nextInt(10,21);
		String message = "You farmed and earned " + randomGold + " gold.";
		currentGold += randomGold;
		message +=  " (" + timeString + ")";
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/cave", method=RequestMethod.POST)
	public String cave(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		LocalDateTime logTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
		String timeString = formatter.format(logTime);
		int randomGold = ThreadLocalRandom.current().nextInt(5,11);		
		String message = "You spelunked and earned " + randomGold + " gold.";
		currentGold += randomGold;
		message +=  " (" + timeString + ")";
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/house", method=RequestMethod.POST)
	public String house(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		LocalDateTime logTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
		String timeString = formatter.format(logTime);
		int randomGold = ThreadLocalRandom.current().nextInt(2,6);		
		String message = "You Netflixed and chilled and somehow earned " + randomGold + " gold.";
		currentGold += randomGold;
		message +=  " (" + timeString + ")";
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/casino", method=RequestMethod.POST)
	public String casino(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		LocalDateTime logTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
		String timeString = formatter.format(logTime);
		int randomGold = ThreadLocalRandom.current().nextInt(-50,51);
		String message = "";
		if (randomGold == 0) {
			message = "You gambled and broke even.";
		}
		else if (randomGold > 0) {
			message = "You gambled and won " + randomGold + " gold"; 
		}
		else {
			message = "You gambled and lost " + -randomGold + " gold.";
		}
		currentGold += randomGold;
		message +=  " (" + timeString + ")";
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/spa", method=RequestMethod.POST)
	public String spa(HttpSession session) {
		Integer currentGold = (Integer) session.getAttribute("gold");
		ArrayList<String> actionLog = (ArrayList<String>) session.getAttribute("log");
		LocalDateTime logTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.LONG).withZone(ZoneId.systemDefault());
		String timeString = formatter.format(logTime);
		int randomGold = ThreadLocalRandom.current().nextInt(-20,-4);
		String message = "You treated yourself and lost " + -randomGold + " gold.";
		currentGold += randomGold;
		message +=  " (" + timeString + ")";
		actionLog.add(0, message);
		session.setAttribute("gold", currentGold);
		session.setAttribute("log", actionLog);
		return "redirect:/gold";
	}
	
	@RequestMapping(value="/reset")
	public String reset(HttpSession session) {
		session.invalidate();
		return "redirect:/gold";
	}
}
