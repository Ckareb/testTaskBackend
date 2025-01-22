package com.example.controllers;

import com.example.dto.LotDTO;
import com.example.service.LotService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/lots")
public class LotController {

    private final LotService lotService;

    // Внедрение зависимости через конструктор
    public LotController(LotService lotService) {
        this.lotService = lotService;
    }

    // Эндпоинт для добавления нового лота
    @PostMapping("/add")
    public ResponseEntity<String> addLot(@RequestBody LotDTO lotDTO) {
        lotService.addLot(lotDTO);
        return ResponseEntity.ok("Lot added successfully");
    }

    // Эндпоинт для получения всех лотов
    @GetMapping("/list")
    public ResponseEntity<List<LotDTO>> getAllLots() {
        List<LotDTO> lots = lotService.getAllLots();
        return ResponseEntity.ok(lots);
    }

    // Эндпоинт для получения лотов по имени
    @GetMapping("/name/{lotName}")
    public ResponseEntity<List<LotDTO>> getLotsByName(@PathVariable String lotName) {
        List<LotDTO> lots = lotService.getLotsByName(lotName);
        return ResponseEntity.ok(lots);
    }

    // Эндпоинт для обновления лота по имени
    @PutMapping("/update/{lotName}")
    public ResponseEntity<String> updateLot(@PathVariable String lotName, @RequestBody LotDTO lotDTO) {
        lotService.updateLotByName(lotName, lotDTO);
        return ResponseEntity.ok("Lot updated successfully");
    }

    // Эндпоинт для удаления лота по имени
    @DeleteMapping("/delete/{lotName}")
    public ResponseEntity<String> deleteLot(@PathVariable String lotName) {
        lotService.deleteLotByName(lotName);
        return ResponseEntity.ok("Lot deleted successfully");
    }
}

