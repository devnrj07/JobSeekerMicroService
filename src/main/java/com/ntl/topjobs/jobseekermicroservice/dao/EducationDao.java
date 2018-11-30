package com.ntl.topjobs.jobseekermicroservice.dao;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ntl.topjobs.jobseekermicroservice.model.EducationDetails;

@Repository
public interface EducationDao extends JpaRepository<EducationDetails,Long>{

	public List<EducationDetails> findAllByResumeID(String resumeId);
	
	
	@Query("From  EducationDetails where eduID= :eduId and resumeID= :resumeId")
	public EducationDetails findByResumeIDEduId(@Param("resumeId")String resumeId, @Param("eduId") long eduId);
}
