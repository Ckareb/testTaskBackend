package com.example.controllers;

import com.example.dto.CustomersDTO;
import com.example.service.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    private final CustomerService customerService;

    // Конструктор для внедрения зависимостей
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    // Эндпоинт для добавления нового клиента
    @PostMapping("/add")
    public ResponseEntity<String> addCustomer(@RequestBody CustomersDTO customerDTO) {
        customerService.addCustomer(customerDTO);
        return ResponseEntity.ok("Клиент добавлен успешно");
    }

    // Эндпоинт для получения всех клиентов
    @GetMapping("/list")
    public ResponseEntity<List<CustomersDTO>> getAllCustomers() {
        List<CustomersDTO> customers = customerService.getAllCustomers();
        return ResponseEntity.ok(customers);
    }

    // Эндпоинт для получения клиентов по имени
    @GetMapping("/codeMain/{customerCodeMain}")
    public ResponseEntity<CustomersDTO> getCustomerByCodeMain(@PathVariable String customerCodeMain) {
        CustomersDTO customer = customerService.getCustomerByCodeMain(customerCodeMain);
        if (customer != null) {
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(null); // Возвращаем 404, если клиент не найден
        }
    }


    // Эндпоинт для обновления клиента по CUSTOMER_CODE_MAIN
    @PutMapping("/update/{customerCodeMain}")
    public ResponseEntity<String> updateCustomer(@PathVariable String customerCodeMain, @RequestBody CustomersDTO customerDTO) {
        customerService.updateCustomerByCodeMain(customerCodeMain, customerDTO);
        return ResponseEntity.ok("Клиент обновлен успешно");
    }

    // Эндпоинт для удаления клиента по CUSTOMER_CODE_MAIN
    @DeleteMapping("/delete/{customerCodeMain}")
    public ResponseEntity<String> deleteCustomer(@PathVariable String customerCodeMain) {
        customerService.deleteCustomerByCodeMain(customerCodeMain);
        return ResponseEntity.ok("Клиент удален успешно");
    }
}
