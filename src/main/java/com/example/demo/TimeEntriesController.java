package com.example.demo;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class TimeEntriesController {
	
	private List<TimeEntry> timeEntries = new LinkedList<>();
	
	public TimeEntriesController() {
		timeEntries.add(new TimeEntry(LocalDateTime.now()));
		timeEntries.add(new TimeEntry(LocalDateTime.now()));
		timeEntries.add(new TimeEntry(LocalDateTime.now()));
		timeEntries.add(new TimeEntry(LocalDateTime.now()));
		timeEntries.add(new TimeEntry(LocalDateTime.now()));
	}

	@GetMapping("/timeentries")
	ModelAndView timeentries() {
		ModelAndView modelAndView = new ModelAndView("timeentries");
		modelAndView.addObject("title", "Zeiteinträge Anwendung");
		modelAndView.addObject("timeEntries", timeEntries);
		return modelAndView;
	}

}
