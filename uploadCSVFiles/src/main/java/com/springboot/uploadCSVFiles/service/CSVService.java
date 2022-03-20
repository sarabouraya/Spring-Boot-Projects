package com.springboot.uploadCSVFiles.service;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.springboot.uploadCSVFiles.helper.CSVHelper;
import com.springboot.uploadCSVFiles.model.Tutorial;
import com.springboot.uploadCSVFiles.repository.TutorialRepository;

@Service
public class CSVService {
  @Autowired
  TutorialRepository repository;
  public void save(MultipartFile file) {
    try {
      List<Tutorial> tutorials = CSVHelper.csvToTutorials(file.getInputStream());
      repository.saveAll(tutorials);
    } catch (IOException e) {
      throw new RuntimeException("fail to store csv data: " + e.getMessage());
    }
  }
  public List<Tutorial> getAllTutorials() {
    return repository.findAll();
  }
}