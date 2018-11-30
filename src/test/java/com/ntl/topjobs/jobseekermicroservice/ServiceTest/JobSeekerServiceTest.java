package com.ntl.topjobs.jobseekermicroservice.ServiceTest;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.MockitoRule;
import org.mockito.quality.Strictness;


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

public class JobSeekerServiceTest {
	
	public MockitoRule rule = MockitoJUnit.rule().strictness(Strictness.STRICT_STUBS);
	
	
	@Mock
	ResumeDao resumedb;
	@Mock
	EducationDao educationdb;
	@Mock
	ExperienceDao expdb;
	@Mock
	SkillsDao skilldb;
	
	Resume resume = new Resume();
	EducationDetails education = new EducationDetails();
	ExperienceDetails experience = new ExperienceDetails();
	Skills skill = new Skills();


	@Test
	public void testGetResumeDetails() {
		
		resume.setResumeId("RID100");
		resume.setContact("2018-10-12");
		resume.setDob(LocalDate.of(1996,10,10));
		resume.setEmail("abc@123");
		resume.setGender("Male");
		resume.setName("NRJ");
		resume.setSeekerId("SEK100");
		
		 Mockito.lenient().when(resumedb.findAll()).thenReturn(null);
		 JobSeekerService sc=new JobSeekerService(resumedb);
		 assertNull(sc.getResumeDetails());

		
	
	}
	
	@Test
	public void testGetResumeDetails1() {
		ArrayList<Resume> list = new ArrayList<Resume>();
		
		resume.setResumeId("RID100");
		resume.setContact("2018-10-12");
		resume.setDob(LocalDate.of(1996,10,10));
		resume.setEmail("abc@123");
		resume.setGender("Male");
		resume.setName("NRJ");
		resume.setSeekerId("SEK100");
		
		list.add(resume);
		
		 Mockito.lenient().when(resumedb.findAll()).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(resumedb);
		 
		 assertEquals(1,sc.getResumeDetails().size());

		
	
	}

	@Test
	public void testAddResume() {
		
		resume.setResumeId("RID100");
		resume.setContact("2018-10-12");
		resume.setDob(LocalDate.of(1996,10,10));
		resume.setEmail("abc@123");
		resume.setGender("Male");
		resume.setName("NRJ");
		resume.setSeekerId("SEK100");
		
		Mockito.lenient().when(resumedb.save(resume)).thenReturn(resume);
		
		JobSeekerService seekerService = new JobSeekerService(resumedb);
		
		assertEquals(resume, seekerService.addResume(resume));
		
		
	}

	@Test
	public void testGetEducationDetails() {
		
		ArrayList<EducationDetails> list = new ArrayList<EducationDetails>();
		
		education.setBoard("CBSE");
		education.setDegree("Xth");
		education.setEduID((long) 1);
		education.setEnddate(LocalDate.of(2012, 06, 12));
		education.setStartdate(LocalDate.of(2010, 04, 21));
		education.setInstitution("VMG");
		education.setResumeID("RID123");
		education.setScore("90%");
		
		list.add(education);
		
		 Mockito.lenient().when(educationdb.findAll()).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(educationdb);
		 
		 assertEquals(1,sc.getEducationDetails().size());
		
	}

	@Test
	public void testGetEducationDetailsByResumeId() {
		
ArrayList<EducationDetails> list = new ArrayList<EducationDetails>();
		
		education.setBoard("CBSE");
		education.setDegree("Xth");
		education.setEduID((long) 1);
		education.setEnddate(LocalDate.of(2012, 06, 12));
		education.setStartdate(LocalDate.of(2010, 04, 21));
		education.setInstitution("VMG");
		education.setResumeID("RID100");
		education.setScore("90%");
		
		list.add(education);
		
		 Mockito.lenient().when(educationdb.findAllByResumeID("RID100")).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(educationdb);
		 
		 assertEquals(1,sc.getEducationDetailsByResumeId("RID100").size());
		
	}

	@Test
	public void testAddEducation() {
		
		education.setBoard("CBSE");
		education.setDegree("Xth");
		education.setEduID((long) 1);
		education.setEnddate(LocalDate.of(2012, 06, 12));
		education.setStartdate(LocalDate.of(2010, 04, 21));
		education.setInstitution("VMG");
		education.setResumeID("RID123");
		education.setScore("90%");
		
Mockito.lenient().when(educationdb.save(education)).thenReturn(education);
		
		JobSeekerService seekerService = new JobSeekerService(educationdb);
		
		assertEquals(education, seekerService.addEducation(education));
		
		
	}

	@Test
	public void testGetExperienceDetails() {
		
		ArrayList<ExperienceDetails> list = new ArrayList<ExperienceDetails>();
		
		experience.setCompanyName("ABC");
		experience.setDescription("Worked Hard played hard");
		experience.setExpId((long)1);
		experience.setNoOfYears("2");
		experience.setPosition("Designer");
		experience.setResumeId("RID100");
	
		list.add(experience);
		
		Mockito.lenient().when(expdb.findAll()).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(expdb);
		 
		 assertEquals(1,sc.getExperienceDetails().size());
	}

	@Test
	public void testGetExperienceDetailsString() {
		
		ArrayList<ExperienceDetails> list = new ArrayList<ExperienceDetails>();
		experience.setCompanyName("ABC");
		experience.setDescription("Worked Hard played hard");
		experience.setExpId((long)1);
		experience.setNoOfYears("2");
		experience.setPosition("Designer");
		experience.setResumeId("RID100");
		
        list.add(experience);
		
		Mockito.lenient().when(expdb.findByresumeId("RID100")).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(expdb);
		 
		 assertEquals(1,sc.getExperienceDetails("RID100").size());
		

	
	}

	@Test
	public void testAddExperience() {
		
		experience.setCompanyName("ABC");
		experience.setDescription("Worked Hard played hard");
		experience.setExpId((long)1);
		experience.setNoOfYears("2");
		experience.setPosition("Designer");
		experience.setResumeId("RID100");
		
        Mockito.lenient().when(expdb.save(experience)).thenReturn(experience);
		
		JobSeekerService seekerService = new JobSeekerService(expdb);
		
		assertEquals(experience, seekerService.addExperience(experience));
		
	}

	@Test
	public void testGetSkillsDetails() {
		
		ArrayList<Skills> list = new ArrayList<Skills>();
		
		skill.setResumeId("RID100");
		skill.setSkills("XYZ");
		skill.setSkillsId((long)1);
		
        list.add(skill);
		
		Mockito.lenient().when(skilldb.findAll()).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(skilldb);
		 
		 assertEquals(1,sc.getSkillsDetails().size());
		
	}

	@Test
	public void testGetSkillsDetailsString() {
		
		ArrayList<Skills> list = new ArrayList<Skills>();
		skill.setResumeId("RID100");
		skill.setSkills("XYZ");
		skill.setSkillsId((long)1);
		
        list.add(skill);
		
		Mockito.lenient().when(skilldb.findByresumeId("RID100")).thenReturn(list);
		 JobSeekerService sc=new JobSeekerService(skilldb);
		 
		 assertEquals(1,sc.getSkillsDetails("RID100").size());
		
	}

	@Test
	public void testAddSkills() {
		
		skill.setResumeId("RID100");
		skill.setSkills("XYZ");
		skill.setSkillsId((long)1);

		Mockito.lenient().when(skilldb.save(skill)).thenReturn(skill);
       JobSeekerService seekerService = new JobSeekerService(skilldb);
	   assertEquals(skill, seekerService.addSkills(skill));
		
	}

	@Test
	public void testGenerateResumeId() {
		
		JobSeekerService seekerService = new JobSeekerService();
		assertNotNull(seekerService.generateResumeId());
		
		
		
		
	}

}
