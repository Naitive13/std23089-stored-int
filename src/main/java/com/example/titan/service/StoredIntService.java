package com.example.titan.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Scanner;
import java.util.Set;
import org.springframework.stereotype.Service;

@Service
public class StoredIntService {
  public String getStoredInt() {
    try {
      File file = new File("stored-int.txt");
      int randomInt = (int) (Math.random() * 10);

      if (file.createNewFile()) {
        Path path = Paths.get("stored-int.txt");
        Set<PosixFilePermission> permissions = PosixFilePermissions.fromString("rw-rw-rw-");
        Files.setPosixFilePermissions(path, permissions);
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(String.valueOf(randomInt));
        fileWriter.close();
        return "Created file with value: " + randomInt;
      }

      Scanner fileReader = new Scanner(file);
      String content = null;
      if (fileReader.hasNextLine()) {
        content = fileReader.nextLine();
      }
      return "Read file with value: " + content;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
