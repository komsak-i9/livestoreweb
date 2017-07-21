package com.example.livestore.controller;

import com.example.livestore.data.ItemDAOMySQL;
import com.example.livestore.data.ItemDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShopController {

    @Autowired
    ItemDAOMySQL doa;
    
    @RequestMapping("/shop")
    public ModelAndView url2() {
        List<ItemDTO> item = doa.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("items", item);
        return modelAndView;
    }
}
