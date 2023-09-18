package com.springmapping;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.springmapping.dao.AppDao;
import com.springmapping.entity.Instructor;
import com.springmapping.entity.InstructorDetails;


@SpringBootApplication
public class SpringbootadvancemappingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootadvancemappingApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner(AppDao appDao) {
		return runner ->{
			//createInstructor(appDao);
			//findInstructorById(appDao);
			deleteInstructorById(appDao);
		};
	}

	private void deleteInstructorById(AppDao appDao) {			

			int theId=1;
			System.out.println("delete instructor by Id: "+theId);
			
			//delete instructor by id
			appDao.deleteInstructorById(theId);
			System.out.println("deleted!");
		}

	

/*	private void createInstructor(AppDao appDao) {
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
*/	
	private void findInstructorById(AppDao appDao) {
		int theId =2;
		System.out.println("Finding Instructor By Id: "+theId);
		
		Instructor tempInstructor = appDao.findInstructorById(theId);
		
		System.out.println("tempInstructor: "+tempInstructor);
		System.out.println("The associated instructorDetail only: "+tempInstructor.getInstructorDetails());
	}

}
