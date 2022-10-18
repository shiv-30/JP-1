package com.connectors.service;

import com.connectors.model.Connection;
import com.connectors.model.Message;
import com.connectors.repository.ConnectionRepository;
import com.connectors.test.Campus_Details;
import com.connectors.test.Employee;

import reactor.core.publisher.Mono;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectorService {

    @Autowired
    private ConnectionRepository connectionRepository;
    
    
    @Autowired
	WebClient webClient;


    private final RestTemplate restTemplate;


    private ArrayList<HashMap<String, Object>> connectionList = new ArrayList<>();

    private ArrayList<Connection> connectors;

    public ConnectorService() {
        restTemplate = new RestTemplate();
    }

    // fetching all records
    public ArrayList<HashMap<String, Object>> getAllCampusDetails() {

        connectors = (ArrayList<Connection>) connectionRepository.findAll();

        for(var connection : connectors) {
            HashMap<String, Object> connectionMap = new HashMap<>();

            String employeeUrl = "http://localhost:8020/employee/" + connection.getEmp_code();
            Object employee = restTemplate.getForObject(employeeUrl, Object.class);
            connectionMap.put("employee_code", employee);

            String employeeDetailsUrl = "http://localhost:8050/employeeDetails/" + connection.getEmployee_details_code();
            Object employeeDetails = restTemplate.getForObject(employeeDetailsUrl, Object.class);
            connectionMap.put("employee_details_code", employeeDetails);

            String joiningDetailsUrl = "http://localhost:8030/joiningDetail/" + connection.getJoining_details_code();
            Object joiningDetails = restTemplate.getForObject(joiningDetailsUrl, Object.class);
            connectionMap.put("joining_details_code", joiningDetails);

            String campusUrl = "http://localhost:8040/campus/" + connection.getCampus_code();
            Object campusDetails = restTemplate.getForObject(campusUrl, Object.class);
            connectionMap.put("campus_code", campusDetails);

            String batchDetailsUrl = "http://localhost:8060/batchs/" + connection.getBatch_details_code();
            Object batchDetails = restTemplate.getForObject(batchDetailsUrl, Object.class);
            connectionMap.put("batch_details_code", batchDetails);

            String AssessmentDetailsUrl = "http://localhost:8070/assessment/" + connection.getAssessment_details_code();
            Object assessmentDetails = restTemplate.getForObject(AssessmentDetailsUrl, Object.class);
            connectionMap.put("assessment_details_code", assessmentDetails);


            connectionList.add(connectionMap);

        }


       

        return connectionList;
    }
    
    public String update(HashMap<String, Object> campusMap, Integer employee_code) {
    	Optional<Connection> optional = connectionRepository.findById(employee_code);
    	Connection connection = optional.get();
    	Connection newConnection = new Connection();
    	newConnection.setEmp_code(employee_code);
    	
    	
    	
    	Message message = new Message();
    	
    	// Campus
    	Object campus = campusMap.get("campus_code");
    	String campusUrl = "http://localhost:8040/campus/" + connection.getCampus_code();
    	Mono<Integer> monoCampusCode = (Mono<Integer>) webClient.put()
    								.uri(campusUrl)
    								.body(Mono.just(campus), Object.class)
    								.retrieve()
    								.bodyToMono(Integer.class);
    	
    	Integer campusCode = monoCampusCode.block();
    	int campusCodeValue = campusCode.intValue();
    	newConnection.setCampus_code(campusCodeValue);
    	
    	// Assessment
    	Object  assessment = campusMap.get("assessment_details_code");
    	String assessmentUrl = "http://localhost:8070/assessment/" + connection.getAssessment_details_code();
    	Mono<Integer> monoAssessmentCode = (Mono<Integer>) webClient.put()
    								.uri(assessmentUrl)
    								.body(Mono.just(assessment), Object.class)
    								.retrieve()
    								.bodyToMono(Integer.class);
    	
    	Integer assessmentCode = monoAssessmentCode.block();
    	
    	newConnection.setAssessment_details_code(assessmentCode);
    	
    	// Batch
    	Object  batch = campusMap.get("batch_details_code");
    	String batchUrl = "http://localhost:8060/batchs/" + connection.getBatch_details_code();
    	Mono<Integer> monoBatchCode = (Mono<Integer>) webClient.put()
    								.uri(batchUrl)
    								.body(Mono.just(batch), Object.class)
    								.retrieve()
    								.bodyToMono(Integer.class);
    	
    	Integer batchCode = monoBatchCode.block();
    	
    	newConnection.setBatch_details_code(batchCode);
    	
    	// Employee
    	Object employee = campusMap.get("employee_code");
    	String employeeUrl = "http://localhost:8020/employee";
    	Mono<Integer> monoEmployeeCode = (Mono<Integer>) webClient.put()
										.uri(employeeUrl)
										.body(Mono.just(employee), Object.class)
										.retrieve()
										.bodyToMono(Integer.class);
    	
    	// employeeDetailsAPI
    	Object  employeeDetails = campusMap.get("employee_details_code");
    	String employeeDetailsUrl = "http://localhost:8050/employeeDetails/" + connection.getEmployee_details_code();
    	Mono<Integer> monoEmployeeDetailsCode = (Mono<Integer>) webClient.put()
    								.uri(employeeDetailsUrl)
    								.body(Mono.just(employeeDetails), Object.class)
    								.retrieve()
    								.bodyToMono(Integer.class);
    	
    	Integer employeeDetailsCode = monoEmployeeDetailsCode.block();
    	newConnection.setEmployee_details_code(employeeDetailsCode);
    	
    	// joining Details
    	Object  joiningDetails = campusMap.get("joining_details_code");
    	String joiningDetailsUrl = "http://localhost:8030/joiningDetail/" + connection.getJoining_details_code();
    	Mono<Integer> monoJoiningDetailsCode = (Mono<Integer>) webClient.put()
    								.uri(joiningDetailsUrl)
    								.body(Mono.just(joiningDetails), Object.class)
    								.retrieve()
    								.bodyToMono(Integer.class);
    	
    	Integer joiningDetailsCode = monoJoiningDetailsCode.block();
    	newConnection.setJoining_details_code(joiningDetailsCode);
    	
    	connectionRepository.save(newConnection);
    	
    	return "updated Successfully";
    }

}
