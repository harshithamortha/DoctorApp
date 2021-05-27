package com.cg.bookmydoctor.service;


import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.FeedBackException;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 


	@Autowired
	private IFeedbackDao feedbackDao;
	FeedBack feedback;

	@Override
	public FeedBack addFeedback(FeedBack fdb) {
		if(fdb != null) {
			return feedbackDao.save(fdb);
		}  else {
			throw new FeedBackException("Passed object is null");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) {
		Optional<FeedBack> feedbackDb = this.feedbackDao.findById(fdb.getFeedbackId());
		if(feedbackDb .isPresent()) {
			return feedbackDb .get();
		} 
		else {
			throw new FeedBackException("Record not found with id : " + fdb.getFeedbackId());
		}

	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doctor) {
		List<FeedBack> list = null;
		if(feedback.getDoctor().getDoctorId() == doctor.getDoctorId()) {
			list.add(feedback);
		}
		return list;
	}
}