package com.challenge.arcam2.controller;

import com.challenge.arcam2.dto.dtoTransactionRequest;
import com.challenge.arcam2.dto.dtoTransactionResponse;
import com.challenge.arcam2.model.entity.Report;
import com.challenge.arcam2.service.ITransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionService iTransactionService;

    @GetMapping("/list")
    public ResponseEntity<List<dtoTransactionResponse>> listAll(){
        return ResponseEntity.ok(iTransactionService.listAll());
    }

    @GetMapping("/{idTransaction}")
    public ResponseEntity<dtoTransactionResponse> listById(@PathVariable int idTransaction){
        dtoTransactionResponse transaction = iTransactionService.listById(idTransaction);
        return ResponseEntity.ok(transaction);
    }

    @PostMapping("/create")
    public ResponseEntity<dtoTransactionResponse> create(@RequestBody dtoTransactionRequest transaction){
        dtoTransactionResponse transactionCreate = iTransactionService.create(transaction);
        return ResponseEntity.ok(transactionCreate);
    }

    @PutMapping("/update/{idTransaction}")
    public ResponseEntity<dtoTransactionResponse> update(@PathVariable int idTransaction, @RequestBody dtoTransactionRequest transaction){
        return ResponseEntity.ok(iTransactionService.update(idTransaction, transaction));
    }

    @DeleteMapping("/delete/{idTransaction}")
    public ResponseEntity<dtoTransactionResponse> deleteById(@PathVariable int idTransaction){
        iTransactionService.deleteById(idTransaction);
        return ResponseEntity.ok(null);
    }

    @GetMapping("/reports")
    public ResponseEntity<List<Report>> generateReport(@RequestParam("clientId") int clientId,
                                                       @RequestParam("startDate") Date startDate,
                                                       @RequestParam("endDate") Date endDate) {
        return ResponseEntity.ok(iTransactionService.generateReport(clientId, startDate, endDate));
    }
}
