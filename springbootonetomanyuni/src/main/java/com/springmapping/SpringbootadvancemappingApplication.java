package com.springmapping;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springmapping.dao.AppDao;
import com.springmapping.entity.Course;
import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;
import com.springmapping.entity.Review;


@SpringBootApplication
public class SpringbootadvancemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootadvancemappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner ->{
		//createCourseAndReviews(appDao);
		//findCourseAndReviewByCourseId(appDao);
			deleteCourseAndReviewById(appDao);
		};
	}

	private void deleteCourseAndReviewById(AppDao appDao) {
		int theId=10;
		System.out.println("deleting the course and review by id: "+theId);
		appDao.deleteCourseById(theId);
		
		
	}

	private void findCourseAndReviewByCourseId(AppDao appDao) {
		//getting the course id
		int theId=10;
		System.out.println("finding the course id: "+theId);
		Course tempCourse = appDao.findCourseAndReviewByCourseId(theId);
		
		//print the coruse
		System.out.println("the course "+tempCourse);
		
		//print the review
		System.out.println(tempCourse.getReviews());
		System.out.println("done!");
	}

	private void createCourseAndReviews(AppDao appDao) {
		//create a course
		Course tempCourse = new Course("How to learn machine learning");
		
		//add some review
		tempCourse.addReviews(new Review("I learning from scratch!"));
		tempCourse.addReviews(new Review("the course helped me lot"));
		tempCourse.addReviews(new Review("hard to see the videos"));
		
		//save the course
		System.out.println("saving the course");
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
		
		appDao.saveCourse(tempCourse);
		System.out.println("done!");
		
	}

	private void deleteCourseById(AppDao appDao) {
		int theId = 10;
		System.out.println("delete the course id: "+theId);
		
		appDao.deleteCourseById(theId);
		System.out.println("deleted!");
		
	}

	private void updateCoursebyId(AppDao appDao) {
		int theId=10;
		//finding the course
		System.out.println("finding course id: "+theId);
		Course tempCourse = appDao.findCourseById(theId);
		
		//updating the course
		System.out.println("updating the course id: "+theId);
		System.out.println("old course title value: "+tempCourse.getTitle());
		tempCourse.setTitle("learning spring boot is easy");
		appDao.updateCourses(tempCourse);
		System.out.println("updated courses: "+tempCourse);
		System.out.println("done");
		
	}

	

	private void updateInstructor(AppDao appDao) {
		int theId=1;
		//find instructor
		System.out.println("finding Instructor ID: "+theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		//update the instructor
		System.out.println("updating the instructor id: "+theId);
		System.out.println("old Instructor value: "+tempInstructor.getEmail());
		tempInstructor.setEmail("abishakeediter@gmail.com");
		appDao.update(tempInstructor);
		System.out.println("updated instructor: "+tempInstructor);
		System.out.println("done!");
		
		
		
	}

	private void findInstructorWithCoursesJoinFetch(AppDao appDao) {
		int theId=1;
		System.out.println("finding instructor id: "+theId);
		
		Instructor tempInstructor = appDao.findInstructorByIdJoinFetch(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("the associated courses: "+tempInstructor.getCourses());
		
		System.out.println("done!");
		
	}

	private void findCourseForInstructor(AppDao appDao) {
		int theId=1;
		System.out.println("Find the instructor by id: "+theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		
		System.out.println("the instructor values: "+tempInstructor);
		
		//finding courses for instructor id
		System.out.println("Finding courses for instructor Id: "+theId);
		
		List<Course> courses = appDao.findCoursesByInstructorId(theId);
		
		System.out.println("the courses: "+courses);
		//associate the course
		tempInstructor.setCourses(courses);
		
		System.out.println("The associated courses: "+tempInstructor.getCourses());
		
		System.out.println("done!");
		
	}

	private void findInstructorWithCourse(AppDao appDao) {
		
		int theId=1;
		System.out.println("Find the instructor by id: "+theId);
		Instructor tempInstructor = appDao.findInstructorById(theId);
		
		System.out.println("the instructor values: "+tempInstructor);
		System.out.println("the associated course: "+tempInstructor.getCourses());
	}

	private void createInstructorWithCourses(AppDao appDao) {
		//create the instructor
		Instructor tempInstructor = new Instructor("hari", "kumar", "hari@gmail.com");
		
		//create instructor detail
		InstructorDetails tempDetails = new InstructorDetails("work", "business");

		//associate the object
		tempInstructor.setInstructorDetails(tempDetails);
		
		//create course
		
		Course tempcourse3=new Course("springboot");
		
		
		tempInstructor.add(tempcourse3);
		

		//save the instructor
		System.out.println("Saving Instructor: "+tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("saved!");
		
		
	}

	private void deleteInstructorDetailsById(AppDao appDao) {
		int theId = 6;
		System.out.println("delete the instructorDetailById: "+theId);
		
		appDao.deleteInstructorDetailById(theId);
		System.out.println("deleted");
	}

	private void findInstructorDetailsById(AppDao appDao) {
		int theId =4;
		System.out.println("find the instructorDetailsbyId: "+theId);
		
		InstructorDetails tempInstructorDetails = appDao.findInstructorDetailsById(theId);
		System.out.println("the associated instructor detail is: "+tempInstructorDetails.getInstructor());
		
	}

	private void deleteInstructorById(AppDao appDao) {			

			int theId=1;
			System.out.println("delete instructor by Id: "+theId);
			
			//delete instructor by id
			appDao.deleteInstructorById(theId);
			System.out.println("deleted!");
		}

	

private void createInstructor(AppDao appDao) {
//		//create the instructor
//		Instructor tempInstructor = new Instructor("chard", "kumar", "kumar@gmail.com");
//		
//		//create instructor detail
//		InstructorDetails tempDetails = new InstructorDetails("youtube.com", "coding");
		
		
		//create the instructor
				Instructor tempInstructor = new Instructor("abishake", "kumar", "abishake@gmail.com");
				
				//create instructor detail
				InstructorDetails tempDetails = new InstructorDetails("roaming", "editing");
		
		//associate the object
		tempInstructor.setInstructorDetails(tempDetails);
		
		//save the instructor
		System.out.println("Saving Instructor: "+tempInstructor);
		appDao.save(tempInstructor);
		System.out.println("saved!");
				
	}

	private void findInstructorById(AppDao appDao) {
		int theId =2;
		System.out.println("Finding Instructor By Id: "+theId);
		
		Instructor tempInstructor = appDao.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associated instructorDetail only: "+tempInstructor.getInstructorDetails());
	}

}
