package com.springmapping.dao;

import com.springmapping.entity.Instructor;

public interface AppDao {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
}
