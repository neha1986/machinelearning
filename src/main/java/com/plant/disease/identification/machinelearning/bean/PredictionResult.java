package com.plant.disease.identification.machinelearning.bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
@Service
public class PredictionResult {
    private String disease;

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    // You can add more fields such as confidence score, etc., if needed
    public PredictionResult() {
        
    }
    // Constructor
    public PredictionResult(String disease) {
        this.disease = disease;
    }

    // Static method to create ResponseEntity<PredictionResult>
    public static ResponseEntity<PredictionResult> createResponseEntity(String disease) {
        PredictionResult predictionResult = new PredictionResult(disease);
        return new ResponseEntity<>(predictionResult, HttpStatus.OK);
    }
}

