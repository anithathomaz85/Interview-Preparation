package com.demo.swagger.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


//http://localhost:8080/swagger-ui/index.html

@RestController
@RequestMapping("/api/demo")
public class DemoController {

    @Operation(summary = "Welcome message")
    @GetMapping("/welcome")
    public ResponseEntity<String> welcome() {
        return ResponseEntity.ok("Welcome to the Swagger Demo Controller!");
    }

    @Operation(summary = "Square a number")
    @GetMapping("/square/{number}")
    public ResponseEntity<Integer> square(@PathVariable int number) {
        return ResponseEntity.ok(number * number);
    }

    @Operation(summary = "Send a JSON message")
    @PostMapping("/message")
    public ResponseEntity<String> postMessage(@RequestBody Map<String, String> message) {
        return ResponseEntity.ok("Received: " + message.toString());
    }

    @Operation(summary = "Check status")
    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok("Service is up and running");
    }
}
