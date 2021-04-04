package com.komencar.backend.controller;

import com.komencar.backend.model.Model_Detail;
import com.komencar.backend.model.Option;
import com.komencar.backend.repository.ModelDetailRepository;
import com.komencar.backend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public List<Option> optionListByMd_Id(int md_id){ return optionRepository.findByModelDetail_Id(md_id); }

    @GetMapping("/info/{md_id}")
    public Optional<Model_Detail> getModelDetail(@PathVariable int md_id){
        return modelDetailRepository.findById(md_id);
    }
    @GetMapping("/similar_price/{md_id}")
    public List<Model_Detail> findModelDetailByPriceBetween(@PathVariable int md_id){
        Optional<Model_Detail> m_detail = modelDetailRepository.findById(md_id);
        int price = m_detail.get().getOptionList().get(0).getPrice();
        System.out.println(price);

//        return modelDetailRepository.
        return null;
    }

    @GetMapping("/same_segment/{md_id}")
    public List<Model_Detail> findModelDetailBySameSegment(@PathVariable int md_id){
        return null;
    }


}
