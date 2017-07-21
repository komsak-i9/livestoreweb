package com.example.livestore.controller;

import com.example.livestore.data.ItemDAOMySQL;
import com.example.livestore.data.ItemDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopController {

    @Autowired
    ItemDAOMySQL doa;
    
    @RequestMapping("/shop")
    public String url2(Model model) {
        List<ItemDTO> item = doa.getAll();
        model.addAttribute("items", item);
        return "shop";
    }
}
