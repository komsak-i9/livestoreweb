package com.example.livestore.controller;

import com.example.livestore.data.ItemDAO;
import com.example.livestore.data.ItemDTO;
import java.util.List;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyServiceRestController {

    @Autowired
    ItemDAO dao;

    @RequestMapping(path = "/items", method = {RequestMethod.GET})
    public List<ItemDTO> items() {
        return dao.getAll();
    }

    @RequestMapping(path = "/items", method = {RequestMethod.DELETE})
    public String deleteItems(int id) {
        dao.delete(id);
        return "success";
    }

    @RequestMapping(path = "/items", method = {RequestMethod.POST}, consumes = { MediaType.APPLICATION_JSON_VALUE})
    public String updateItems(HttpServletRequest request, @RequestBody ItemDTO model) {
        dao.update(model);
        return "sucess";
    }
}
