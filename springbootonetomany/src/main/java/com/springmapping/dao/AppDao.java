package com.springmapping.dao;

import java.util.List;

import org.ietf.jgss.Oid;

import com.springmapping.entity.Course;
import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;

public interface AppDao {
	
	void save(Instructor theInstructor);
	
	Instructor findInstructorById(int theId);
	
	void deleteInstructorById(int theId);
	
	InstructorDetails findInstructorDetailsById(int theId);
	
	void deleteInstructorDetailById(int theId);
	
	List<Course> findCoursesByInstructorId(int theId);
	
	Instructor findInstructorByIdJoinFetch(int theId);
	
	void update(Instructor temInstructor);
	
	void updateCourses(Course tempCourse);
	
	Course findCourseById(int theId);
	
	void deleteCourseById(int theId);
}
