package tn.cnrps.ws.rest.white.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import tn.cnrps.ws.rest.white.models.Exam;
import tn.cnrps.ws.rest.white.models.Student;
import tn.cnrps.ws.rest.white.models.StudentRequest;
import tn.cnrps.ws.rest.white.models.WhiteTestResponse;

@Service
public class WhiteService {
	
public WhiteTestResponse register(StudentRequest request) {
	WhiteTestResponse response = null;
		List<String> issues = new ArrayList<String>();
		
		if(request.getStudentId() > 10)
			issues.add("Student ID not found");
		
		try {
			Integer.parseInt(request.getExamCode());
		} catch (NumberFormatException e) {
			issues.add("Exam Code not found or not valid");
		}
		
		if(issues.isEmpty()) {
			Student student = new Student();
			student.setId(request.getStudentId());
			student.setName("TestStudent");
			student.setAddress("TestAddress");
			
			Exam exam = new Exam();
			exam.setCode(request.getExamCode());
			exam.setName("TestExam");
			
			
			
			LocalDateTime localDateTime = LocalDateTime.of(2020, 9, 25,14,30);
			 
			
			
			
		
		
		 response = WhiteTestResponse.builder()
									.student(student)
									.exam(exam)
									.date(localDateTime)
									.build();
		}
		else
		{
			 response = WhiteTestResponse.builder()
										.badRequests(issues)
										.build();
		}
														
		return response;
	}

}
