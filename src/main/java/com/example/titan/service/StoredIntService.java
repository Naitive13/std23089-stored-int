package com.example.titan.service;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StoredIntService {
  public String getStoredInt() {
    String filename = "stored-int.txt";
    int content = 0;
    try (Scanner file = new Scanner(filename)) {
      while (file.hasNextLine()) {
        content = Integer.parseInt(file.nextLine());
      }
      return "Read value from file: " + content;
    } catch (Exception e) {
      try (FileWriter file = new FileWriter(filename)) {
        content = (int) (Math.random() * 10);
        file.write(content);
      } catch (IOException ex) {
        throw new RuntimeException(ex);
      }
    }
    return "Created new file with value: " + content;
  }
}
