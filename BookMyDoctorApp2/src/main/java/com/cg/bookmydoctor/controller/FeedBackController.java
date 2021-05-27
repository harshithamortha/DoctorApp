package com.cg.bookmydoctor.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.service.FeedbackServiceImpl;

   
@RestController
@RequestMapping("/Feedback")
public class FeedBackController {
	
	@Autowired
	FeedbackServiceImpl feedbackService;


	@GetMapping("/getAllFeedback")
	@ExceptionHandler(FeedBackException.class)
	public List<FeedBack> getAllFeedBack(Doctor doctor) {
		return feedbackService.getAllFeedback(doctor);
	}

	//working
	@PostMapping("/addFeedback")
	@ExceptionHandler(FeedBackException.class)
	public FeedBack addFeedback(@RequestBody FeedBack feedback) {
		return feedbackService.addFeedback(feedback);
	}

	//working
	@GetMapping("/getFeedback/{feedbackId}")
	@ExceptionHandler(FeedBackException.class)
	public FeedBack getFeedback(@PathVariable("feedbackId") FeedBack fdb) {
		return feedbackService.getFeedback(fdb);
	}
	
}
