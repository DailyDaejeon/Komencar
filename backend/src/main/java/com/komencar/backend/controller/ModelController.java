package com.komencar.backend.controller;

import com.komencar.backend.model.Model_Detail;
import com.komencar.backend.model.Option;
import com.komencar.backend.repository.ModelDetailRepository;
import com.komencar.backend.repository.OptionRepository;
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

    @Autowired
    OptionRepository optionRepository;



    @GetMapping("/all_list")
    public List<Model_Detail> allModelList() {
        return modelDetailRepository.findAll();
    }

    @GetMapping("/option_list")
    public List<Option> optionListByMd_Id(long md_id){ return optionRepository.findByModelDetail_Id(md_id); }
}
