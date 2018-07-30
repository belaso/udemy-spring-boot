package com.example.demo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
class TimeEntriesController {

	@Autowired
	TimeEntriesRepository repository;
	
	@GetMapping("/add_timeentry")
	ModelAndView addTimeentry() {
		TimeEntry timeEntry = new TimeEntry(LocalDateTime.now());
		repository.save(timeEntry);
		return timeentries();
	}

	@GetMapping("/timeentries")
	ModelAndView timeentries() {
		ModelAndView modelAndView = new ModelAndView("timeentries");
		modelAndView.addObject("title", "Zeiteinträge Anwendung");
		modelAndView.addObject("timeEntries", repository.findAll());
		return modelAndView;
	}

}
