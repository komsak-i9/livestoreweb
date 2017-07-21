package com.example.livestore;

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
        ItemDTO item = doa.get(1);
        model.addAttribute("item", item);
        return "shop";
    }
}
