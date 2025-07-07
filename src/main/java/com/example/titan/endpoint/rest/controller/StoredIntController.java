package com.example.titan.endpoint.rest.controller;

import com.example.titan.service.StoredIntService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class StoredIntController {
  public final StoredIntService storedIntService;

  @GetMapping("/stored-int")
  public String getStoredInt() {
    return storedIntService.getStoredInt();
  }
}
