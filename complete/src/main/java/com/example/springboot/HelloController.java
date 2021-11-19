package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;

import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar; 

@Controller
public class HelloController {

	// @GetMapping("/")
	// public String index() {
	// 	return "Greetings from Spring Boot!";
    // }
    
    @GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}


	@GetMapping("/xkcd")
	public String xkcd() {
		return "xkcd";
	}


	//request paramether mathod
	@GetMapping("/xkcdSpec")
	public String xkcdSpecific(@RequestParam(name ="id", required=false) String id, Model model) {
		if(id == null){
			id = "200";
		}
		model.addAttribute("id", id);
		return "xkcdSpecfic";
	}

	// path variable method 
	//@GetMapping("/xkcdSpec/{id}")
	//public String xkcdSpecific(@PathVariable String id, Model model) {
		//model.addAttribute("id", id);
		//return "xkcdSpecfic";
	//}

	@GetMapping("/apodNasa")
	public String nasa(@RequestParam(name ="date", required=false) String date, Model model) {
		if(date == null  ){
			DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");  
                date = dateFormat.format(date);  ;
		}
		model.addAttribute("date", date);
		return "nasa";
	}


}

