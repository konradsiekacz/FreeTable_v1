package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.dao.TableRepository;
import com.mmkpdevelopers.freetable.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;

@Controller
public class TableController {

    @Autowired
    TableRepository tableRepository;

    public TableController(TableRepository tableRepository) {
        this.tableRepository = tableRepository;
    }

    @GetMapping("/addTable")
    @ResponseBody
    public void addTable(){
        tableRepository.save(new Table(5, 2));
        tableRepository.save(new Table(6, 2));
    }

    @GetMapping("/getTable")
    @ResponseBody
    public List<Table> getTable(){
        return tableRepository.findAll();
    }

    @GetMapping("/deleteTable/{id}")
    @ResponseBody
    public void deleteTable(@PathVariable String id){
        tableRepository.deleteById(Integer.parseInt(id));
    }
}
