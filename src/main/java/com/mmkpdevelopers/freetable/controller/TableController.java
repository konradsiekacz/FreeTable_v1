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

    @PutMapping("/updateTable/{id}")
    @ResponseBody
    private Table update(@RequestBody Table table, @PathVariable("id") int id)
    {
        tableService.updateTable(table, id);
        return table;
    }
}
