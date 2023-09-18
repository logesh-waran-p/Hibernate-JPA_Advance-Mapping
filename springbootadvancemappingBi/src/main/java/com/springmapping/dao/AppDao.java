package com.springmapping.dao;

import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;

public interface AppDao {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetails findInstructorDetailsById(int theId);
	
	void deleteInstructorDetailById(int theId);
}
