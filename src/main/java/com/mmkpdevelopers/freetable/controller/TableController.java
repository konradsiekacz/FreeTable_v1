package com.mmkpdevelopers.freetable.controller;

import com.mmkpdevelopers.freetable.model.Table;
import com.mmkpdevelopers.freetable.service.TableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class TableController {

    @Autowired
    TableService tableService;

    @PostMapping("/saveTable")
    @ResponseBody
    private int saveTable(@RequestBody Table table){
        tableService.saveTable(table);
        return table.getId().intValue();
    }

    @GetMapping("/getTables")
    @ResponseBody
    private List<Table> getTables(){
        return tableService.getAllTable();
    }

    @GetMapping("/getTable/{id}")
    @ResponseBody
    private Table getTale(@PathVariable("id") int id)
    {
        return tableService.getTableById(id);
    }

    @DeleteMapping("/deleteTable/{id}")
    @ResponseBody
    private void deleteTable(@PathVariable("id") int id)
    {
        tableService.deleteTableById(id);
    }

    @PutMapping("/updateTable")
    @ResponseBody
    private Table update(@RequestBody Table table)
    {
        tableService.saveTable(table);
        return table;
    }
//
//    @Autowired
//    TableRepository tableRepository;
//
//    public TableController(TableRepository tableRepository) {
//        this.tableRepository = tableRepository;
//    }
//
//    @GetMapping("/addTable")
//    @ResponseBody
//    public void addTable(){
//        tableRepository.save(new Table(5, 2));
//        tableRepository.save(new Table(6, 2));
//    }
//
//    @GetMapping("/getTable")
//    @ResponseBody
//    public List<Table> getTable(){
//        return tableRepository.findAll();
//    }
//
//    @GetMapping("/deleteTable/{id}")
//    @ResponseBody
//    public void deleteTable(@PathVariable String id){
//        tableRepository.deleteById(Long.parseLong(id));
//    }
}
