package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist implements CricketerService {
    private List<Cricketer> list=new ArrayList<>();
    @Override
    public Integer addCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        list.add(cricketer);
        return list.size();
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //CricketerService.super.emptyArrayList();
        list.clear();
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        // TODO Auto-generated method stub
        return new ArrayList<>(list);
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // TODO Auto-generated method stub
        List<Cricketer> sorted=new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }

}