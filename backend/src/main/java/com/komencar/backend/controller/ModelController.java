package com.komencar.backend.controller;

import com.komencar.backend.model.Model;
import com.komencar.backend.model.Model_Detail;
import com.komencar.backend.model.Option;
import com.komencar.backend.repository.ModelDetailRepository;
import com.komencar.backend.repository.ModelRepository;
import com.komencar.backend.repository.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/model")
public class ModelController {

    @Autowired
    ModelDetailRepository modelDetailRepository;

    @Autowired
    OptionRepository optionRepository;

    @Autowired
    ModelRepository modelRepository;



    @GetMapping("/all_list")
    public List<Model_Detail> allModelList() {
        return modelDetailRepository.findAll();
    }


    @GetMapping("/option_list")
    public List<Option> optionListByMd_Id(int md_id){ return optionRepository.findByModelDetail_Id(md_id); }


    @GetMapping("/latest_model")
    public Model_Detail modelDetailListByM_Id(int m_id){

        List<Model_Detail> modelDetailList = modelDetailRepository.findByModel_id(m_id);
        Model_Detail result = modelDetailList.get(modelDetailList.size() - 1);

        return result;
    }


    @GetMapping("/search_list")
    public List<Model> modelListByKeyword(String keyword) {return modelRepository.findByNameLike("%"+keyword+"%");}


    @GetMapping("/search/{md_name}")
    public Model getModelDetailByName(@PathVariable String md_name){
        Model_Detail resultModelDetail =  modelDetailRepository.findModel_DetailByName(md_name);
        Model resultModel = resultModelDetail.getModel();

        List<Model_Detail> resultModelDetailList = new ArrayList<>();
        resultModelDetailList.add(resultModelDetail);
        resultModel.setModelDetailList(resultModelDetailList);

        return resultModel;
    }


    @GetMapping("/info/{md_id}")
    public Optional<Model_Detail> getModelDetail(@PathVariable int md_id){
        return modelDetailRepository.findById(md_id);
    }


    @GetMapping("/similar_price/{md_id}")
    public List<Model> findModelDetailByPriceBetween(@PathVariable int md_id){

        int price = modelDetailRepository.findById(md_id).get().getOptionList().get(0).getPrice();

        List<Model> tempModelList = modelRepository.findAll();
        List<Model> resultModelList = new ArrayList<>();

        for(Model model : tempModelList) {
            List<Model_Detail> tempModelDetailList = model.getModelDetailList();
            List<Model_Detail> resultModelDetailList = new ArrayList<>();

            Model_Detail resultModelDetail = tempModelDetailList.get(tempModelDetailList.size() - 1);

            List<Option> resultOptionList = new ArrayList<>();
            resultOptionList.add(resultModelDetail.getOptionList().get(0));
            resultModelDetail.setOptionList(resultOptionList);

            int currPrice = resultOptionList.get(0).getPrice();
            if(currPrice < price - 10000000 || currPrice > price + 10000000) continue;

            resultModelDetailList.add(resultModelDetail);
            Model resultModel = new Model(model.getId(), model.getName(), model.getManufacturer(), model.getSegment(), resultModelDetailList);

            resultModelList.add(resultModel);
        }

        return resultModelList;
    }


    @GetMapping("/same_segment/{md_id}")
    public List<Model> findModelDetailBySameSegment(@PathVariable int md_id){

        long s_id =  modelDetailRepository.findById(md_id).get().getModel().getSegment().getId();

        List<Model> tempModelList = modelRepository.findBySegment_Id(s_id);
        List<Model> resultModelList = new ArrayList<>();

        for(Model model : tempModelList) {
            List<Model_Detail> tempModelDetailList = model.getModelDetailList();
            List<Model_Detail> resultModelDetailList = new ArrayList<>();

            Model_Detail resultModelDetail = tempModelDetailList.get(tempModelDetailList.size() - 1);

            List<Option> resultOptionList = new ArrayList<>();
            resultOptionList.add(resultModelDetail.getOptionList().get(0));
            resultModelDetail.setOptionList(resultOptionList);

            resultModelDetailList.add(resultModelDetail);
            Model resultModel = new Model(model.getId(), model.getName(), model.getManufacturer(), model.getSegment(), resultModelDetailList);

            resultModelList.add(resultModel);
        }

        return resultModelList;
    }
}
