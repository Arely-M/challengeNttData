package com.challenge.arcam.controller;

import com.challenge.arcam.dto.dtoAccountRequest;
import com.challenge.arcam.dto.dtoAccountResponse;
import com.challenge.arcam.service.IAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {

    private final IAccountService iAccountService;

    @GetMapping("/list")
    public ResponseEntity<List<dtoAccountResponse>> listAll(){
        return ResponseEntity.ok(iAccountService.listAll());
    }
    @GetMapping("/{idAccount}")
    public ResponseEntity<dtoAccountResponse> listById(@PathVariable int idAccount){
        dtoAccountResponse account = iAccountService.listById(idAccount);
        return ResponseEntity.ok(account);
    }

    @PostMapping("/create")
    public ResponseEntity<dtoAccountResponse> create(@RequestBody dtoAccountRequest account){
        dtoAccountResponse accountCreate = iAccountService.create(account);
        return ResponseEntity.ok(accountCreate);
    }

    @PutMapping("/update/{idAccount}")
    public ResponseEntity<dtoAccountResponse> update(@PathVariable int idAccount, @RequestBody dtoAccountRequest account){
        return ResponseEntity.ok(iAccountService.update(idAccount, account));
    }

    @DeleteMapping("/delete/{idAccount}")
    public ResponseEntity<dtoAccountResponse> deleteById(@PathVariable int idAccount){
        iAccountService.deleteById(idAccount);
        return ResponseEntity.ok(null);
    }
}
