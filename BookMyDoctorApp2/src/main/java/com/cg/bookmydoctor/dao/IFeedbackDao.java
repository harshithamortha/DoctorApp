package com.cg.bookmydoctor.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.bookmydoctor.dto.Doctor;
import com.cg.bookmydoctor.dto.FeedBack;

public interface IFeedbackDao extends JpaRepository<FeedBack, Integer> {

	//FeedBack findById(Optional<Doctor> optional);
	
}
