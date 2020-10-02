package com.mmkpdevelopers.freetable.service;

import com.mmkpdevelopers.freetable.dao.TableRepository;
import com.mmkpdevelopers.freetable.model.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class TableService {

    @Autowired
    TableRepository tableRepository;

    public void saveTable(Table table){
        tableRepository.save(table);
    }

    public List<Table> getAllTable(){
        List<Table> tables = new ArrayList<Table>();
        tableRepository.findAll().forEach(table1 -> tables.add(table1));
        return tables;
    }

    public Table getTableById(int id){
        return tableRepository.findById((long) id).get();
    }

    public void deleteTableById(int id){
        tableRepository.deleteById((long) id);
    }

    public void updateTable(Table table, int id){
        tableRepository.save(table);
    }
}
