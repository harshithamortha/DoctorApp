package com.cg.bookmydoctor.service;
import java.util.ArrayList; 
import java.util.List;  
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.bookmydoctor.dao.IFeedbackDao;
import com.cg.bookmydoctor.dto.*;
import com.cg.bookmydoctor.exception.DoctorException;
import com.cg.bookmydoctor.exception.FeedBackException;
import com.cg.bookmydoctor.service.IFeedbackService;

@Service
public class FeedbackServiceImpl implements IFeedbackService { 


	@Autowired
	private IFeedbackDao fbDao;
	FeedBack fb;

	@Override
	public FeedBack addFeedback(FeedBack fdb) {
		Optional<FeedBack> findById = fbDao.findById(fdb.getRatingId());
		if(findById.isPresent()) {
			return fbDao.save(fdb);
		} else if(findById.isEmpty()){
			throw new FeedBackException("Passed object can't be null");
		} else {
			throw new FeedBackException("Object not found");
		}

	}

	@Override
	public FeedBack getFeedback(FeedBack fdb) {
		Optional<FeedBack> fbdb = this.fbDao.findById(fdb.getRatingId());

		if(fbdb.isPresent()) {
			return fbdb.get();
		} 
		else {
			throw new FeedBackException("Record not found with id : " + fdb.getRatingId());
		}

	}

	@Override
	public List<FeedBack> getAllFeedback(Doctor doc) {
		
		List<FeedBack> list = null;
		if(fb.getDoctor().getDoctorId() == doc.getDoctorId()) {
			list.add(fb);
		}
		return list;
	}
}