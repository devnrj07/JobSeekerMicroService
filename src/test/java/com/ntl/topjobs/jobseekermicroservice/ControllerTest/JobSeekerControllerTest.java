package com.ntl.topjobs.jobseekermicroservice.ControllerTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import com.ntl.topjobs.jobseekermicroservice.controller.JobSeekerController;
import com.ntl.topjobs.jobseekermicroservice.dao.EducationDao;
import com.ntl.topjobs.jobseekermicroservice.dao.ExperienceDao;
import com.ntl.topjobs.jobseekermicroservice.dao.ResumeDao;
import com.ntl.topjobs.jobseekermicroservice.dao.SkillsDao;
import com.ntl.topjobs.jobseekermicroservice.model.EducationDetails;
import com.ntl.topjobs.jobseekermicroservice.model.ExperienceDetails;
import com.ntl.topjobs.jobseekermicroservice.model.Resume;
import com.ntl.topjobs.jobseekermicroservice.model.Skills;
import com.ntl.topjobs.jobseekermicroservice.service.JobSeekerService;

@RunWith(MockitoJUnitRunner.class)
public class JobSeekerControllerTest {
	
	@Mock
	JobSeekerService service;
	
	
	
	
	@Mock
	ResumeDao resumedb;
	@Mock
	EducationDao educationdb;
	@Mock
	ExperienceDao expdb;
	@Mock
	SkillsDao skilldb;

	@Test
	public void testDisplayAllEducationDetailsByResumeId() {
		
ArrayList<EducationDetails> list = new ArrayList<EducationDetails>();
		
EducationDetails education = new EducationDetails();
		education.setBoard("CBSE");
		education.setDegree("Xth");
		education.setEduID((long) 1);
		education.setEnddate(LocalDate.of(2012, 06, 12));
		education.setStartdate(LocalDate.of(2010, 04, 21));
		education.setInstitution("VMG");
		education.setResumeID("RID123");
		education.setScore("90%");
		
		list.add(education);
		
		 Mockito.lenient().when(service.getEducationDetailsByResumeId("RID123")).thenReturn(list);
		 
		 JobSeekerController controller=new JobSeekerController(service);
		 assertEquals(1,controller.displayAllEducationDetailsByResumeId("RID123").size());

		
	}

	@Test
	public void testDisplayAllExperienceDetailsByResumeId() {
		
		
ArrayList<ExperienceDetails> list = new ArrayList<ExperienceDetails>();
		

   ExperienceDetails experience = new ExperienceDetails();
		experience.setCompanyName("ABC");
		experience.setDescription("Worked Hard played hard");
		experience.setExpId((long)1);
		experience.setNoOfYears("2");
		experience.setPosition("Designer");
		experience.setResumeId("RID100");
	
		list.add(experience);
		
		Mockito.lenient().when(service.getExperienceDetails("RID100")).thenReturn(list);
		 JobSeekerController controller=new JobSeekerController(service);
		 
		 assertEquals(1,controller.displayAllExperienceDetailsByResumeId("RID100").size());
		
	}

	@Test 
	public void testDisplayAllSkillsDetailsByResumeId() {
		
ArrayList<Skills> list = new ArrayList<Skills>();
		
  Skills skill = new Skills();
		skill.setResumeId("RID100");
		skill.setSkills("XYZ");
		skill.setSkillsId((long)1);
		
        list.add(skill);
		
		Mockito.lenient().when(service.getSkillsDetails("RID100")).thenReturn(list);
		 JobSeekerController sc=new JobSeekerController(service);
		 
		 assertEquals(1,sc.displayAllSkillsDetailsByResumeId("RID100").size());
		
		
	}
	
	@Test
	public void testDisplayAllResumeDetailsById() {
		
		ArrayList<Resume> list = new ArrayList<Resume>();
		
		Resume resume = new Resume();
		resume = new Resume();
		resume.setResumeId("RID100");
		resume.setContact("2018-10-12");
		resume.setDob(LocalDate.of(1996,10,10));
		resume.setEmail("abc@123");
		resume.setGender("Male");
		resume.setName("NRJ");
		resume.setSeekerId("SEK100");
		
		list.add(resume);
		
		 Mockito.lenient().when(service.getResumeDetails("RID100")).thenReturn(list);
		 JobSeekerController controller=new JobSeekerController(service);
		 assertNotNull(controller.displayResumeDetails("RID100"));
		
		
		
	}

//	@Test
//	public void testAddEducationDetails() {
//		
//		Resume resume = new Resume();
//		resume.setResumeId("RID100");
//		resume.setContact("2018-10-12");
//		resume.setDob(LocalDate.of(1996,10,10));
//		resume.setEmail("abc@123");
//		resume.setGender("Male");
//		resume.setName("NRJ");
//		resume.setSeekerId("SEK100");
//		
//		 Mockito.lenient().when(service.addResume(resume)).thenReturn(resume);
//		 JobSeekerController controller=new JobSeekerController(service);
//		 ResponseEntity<Object> result = controller.addResumeDetails(resume);
//		 Object object = result.getBody();
//		 assertEquals(object,result);
//
//		
//	}

	@Test
	public void testAddExperienceDetails() {
	
	}

	@Test
	public void testAddSkillsDetails() {
		
	}

}
