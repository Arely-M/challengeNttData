package com.challenge.arcam.controller;

import com.challenge.arcam.dto.dtoClientRequest;
import com.challenge.arcam.dto.dtoClientResponse;
import com.challenge.arcam.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
@RequiredArgsConstructor
public class ClientController {

    private final IClientService iClientService;

    @GetMapping("/list")
    public ResponseEntity<List<dtoClientResponse>> listAll(){
        return ResponseEntity.ok(iClientService.listAll());
    }
    @GetMapping("/{idClient}")
    public ResponseEntity<dtoClientResponse> listById(@PathVariable int idClient){
        dtoClientResponse client = iClientService.listById(idClient);
        return ResponseEntity.ok(client);
    }

    @PostMapping("/create")
    public ResponseEntity<dtoClientResponse> create(@RequestBody dtoClientRequest client){
        dtoClientResponse personCreate = iClientService.create(client);
        return ResponseEntity.ok(personCreate);
    }

    @PutMapping("/update/{idClient}")
    public ResponseEntity<dtoClientResponse> update(@PathVariable int idClient, @RequestBody dtoClientRequest client){
        return ResponseEntity.ok(iClientService.update(idClient, client));
    }

    @DeleteMapping("/delete/{idClient}")
    public ResponseEntity<dtoClientResponse> deleteById(@PathVariable int idClient){
        iClientService.deleteById(idClient);
        return ResponseEntity.ok(null);
    }
}
