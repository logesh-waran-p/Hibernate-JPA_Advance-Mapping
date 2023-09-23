package com.springmapping.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmapping.entity.Course;
import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
		//retrive the instructor
		Instructor tempInstructor = entityManager.find(Instructor.class, theId);
		
		//get the courses
		List<Course> tempCourses = tempInstructor.getCourses();
		//break the association
		for(Course course : tempCourses) {
			course.setInstructor(null);
		}
		//delete the instructor
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

	@Override
	public List<Course> findCoursesByInstructorId(int theId) {
		//create query
		TypedQuery<Course> query = entityManager.createQuery(
				"from Course where instructor.id=:data",Course.class);
		query.setParameter("data", theId);
		
		//execute the query
		List<Course> courses = query.getResultList();
		return courses;		
		
	}

	@Override
	public Instructor findInstructorByIdJoinFetch(int theId) {
		//create query
		//this code will still retrive instructor and courses 
		TypedQuery<Instructor> query = entityManager.createQuery(
				"select i from Instructor i "
				+"JOIN FETCH i.courses "
				+"JOIN FETCH i.instructorDetails "
				+"where i.id = :data", Instructor.class);
		
		query.setParameter("data", theId);
		
		Instructor instructor = query.getSingleResult();
		return instructor;
		
	}

	@Override
	@Transactional
	public void update(Instructor temInstructor) {
		entityManager.merge(temInstructor);
		
	}

	@Override
	@Transactional
	public void updateCourses(Course tempCourse) {
		entityManager.merge(tempCourse);
		
	}

	@Override
	public Course findCourseById(int theId) {
		
		return entityManager.find(Course.class, theId);
	}

	@Override
	@Transactional
	public void deleteCourseById(int theId) {
		Course tempCourse = entityManager.find(Course.class, theId);
		
		entityManager.remove(tempCourse);
		
	}

	@Override
	@Transactional
	public void saveCourse(Course theCourse) {
		entityManager.persist(theCourse);		
	}

	@Override
	public Course findCourseAndReviewByCourseId(int theId) {		
		//create query
		TypedQuery<Course> query = entityManager
				.createQuery("select c from Course c "
							+"JOIN FETCH c.reviews "
							+"where c.id = :data ", Course.class);
				query.setParameter("data", theId);
		//execute the query
				Course course = query.getSingleResult();
				return course;
		
	}

}
