package com.connectors.controller;

import com.connectors.ConnectorsApplication;
import com.connectors.model.Connection;
import com.connectors.repository.ConnectionRepository;
import com.connectors.service.ConnectorService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class Controller {



    @Autowired
    private ConnectorService connectorService;

    @GetMapping("/campus")
    public String getCampus() {
        ArrayList<HashMap<String, Object>> campusList = connectorService.getAllCampusDetails();
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String campusJson = gson.toJson(campusList);
        return campusJson;
    }
}
