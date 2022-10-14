package com.connectors.service;

import com.connectors.model.Connection;
import com.connectors.repository.ConnectionRepository;
import com.connectors.test.Campus_Details;
import com.connectors.test.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Service
public class ConnectorService {

    @Autowired
    private ConnectionRepository connectionRepository;


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

}
