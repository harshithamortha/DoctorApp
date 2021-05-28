package com.cg.bookmydoctor.serviceimpl;


import java.util.List; 
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 


	@Autowired
	private IFeedbackDao feedbackDao;
	FeedBack feedback;

	@Override
	public FeedBack addFeedback(FeedBack fdb) throws FeedBackException {
		Optional<FeedBack> findById = feedbackDao.findById(fdb.getFeedbackId());
		if(!findById.isPresent()) {
			return feedbackDao.save(fdb);
		}  else {
			throw new FeedBackException("Feedback with id : " +fdb.getFeedbackId()+ "already exists");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) throws FeedBackException {
		Optional<FeedBack> feedbackDb = this.feedbackDao.findById(fdb.getFeedbackId());
		if(feedbackDb .isPresent()) {
			return feedbackDb .get();
		} 
		else {
			throw new FeedBackException("Feedback with ID :" + fdb.getFeedbackId()+"doesn't exist");
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