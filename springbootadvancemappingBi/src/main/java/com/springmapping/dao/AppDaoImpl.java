package com.springmapping.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDaoImpl implements AppDao{

	//define entity manager
	private EntityManager entityManager;
	
	//Inject entity manager
	@Autowired
	public AppDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}
	
	@Override
	@Transactional
	public void save(Instructor theInstructor) {
		entityManager.persist(theInstructor);
		
	}

	@Override
	public Instructor findInstructorById(int theId) {
		return entityManager.find(Instructor.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorById(int theId) {
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);		
		entityManager.remove(tempInstructor);
		
	}

	@Override
	public InstructorDetails findInstructorDetailsById(int theId) {
		return entityManager.find(InstructorDetails.class, theId);
	}

	@Override
	@Transactional
	public void deleteInstructorDetailById(int theId) {
		InstructorDetails tempInstructorDetails = entityManager.find(InstructorDetails.class, theId);
		
		tempInstructorDetails.getInstructor().setInstructorDetails(null);
		
		entityManager.remove(tempInstructorDetails);
	}

}
