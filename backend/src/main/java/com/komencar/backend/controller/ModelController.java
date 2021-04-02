package com.komencar.backend.controller;

import com.komencar.backend.model.Model_Detail;
import com.komencar.backend.repository.ModelDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelDetailRepository modelDetailRepository;

    @GetMapping("/all_list")
    public List<Model_Detail> allModelList() {
        return modelDetailRepository.findAll();
    }
}
