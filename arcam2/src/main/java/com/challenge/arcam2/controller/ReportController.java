package com.challenge.arcam2.controller;

import com.challenge.arcam2.model.entity.Report;
import com.challenge.arcam2.service.ITransactionService;
import com.challenge.arcam2.service.impl.TransactionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class ReportController {

    private final TransactionServiceImpl transactionServiceImpl;

   /* @GetMapping("/reports")
    public ResponseEntity<Report> generateReport(@RequestParam("clientId") int clientId,
                                                 @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
                                                 @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate) {
        Report report = transactionServiceImpl.generateReport(clientId, startDate, endDate);
        return ResponseEntity.ok(report);
    }*/
}
