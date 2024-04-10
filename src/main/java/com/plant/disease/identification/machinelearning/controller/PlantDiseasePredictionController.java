package com.plant.disease.identification.machinelearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.plant.disease.identification.machinelearning.bean.PredictionResult;
import com.plant.disease.identification.machinelearning.service.PlantDiseasePredictionService;

import java.io.IOException;
import java.net.URI;

@RestController
public class PlantDiseasePredictionController {

    @Autowired
    private PlantDiseasePredictionService plantDiseasePredictionService;
    @Autowired
    PredictionResult predictionResult;
    @PostMapping("/upload")
    public ResponseEntity<?> predictDisease(@RequestParam("file") MultipartFile file) throws IOException {
    	try {
        // Validate file
        if (file == null || file.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }

        // Perform prediction
        String disease = plantDiseasePredictionService.predictDisease(file);
        predictionResult.setDisease(disease);
        // You can add more information to the response, such as confidence score, etc.
        return ResponseEntity.ok().body(predictionResult);
    	}
    	catch(IOException e) {
    		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while processing the image.");
    	}
    	catch (Exception e) {
            // Handle other exceptions
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}
