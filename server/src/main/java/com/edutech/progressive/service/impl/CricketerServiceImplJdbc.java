package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplJdbc implements CricketerService  {
    CricketerDAO cricketerDAO;
    @Override
    public List<Cricketer> getAllCricketers() {
       List<Cricketer>li= cricketerDAO.getAllCricketers();
        return li;
    }
    @Override
    public Integer addCricketer(Cricketer cricketer) {
        cricketerDAO.addCricketer(cricketer);
        return -1;
    }
    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        List<Cricketer> list=new ArrayList<>(cricketerDAO.getAllCricketers());

     list.sort(Comparator.comparing(Cricketer::getExperience));
     return list;

    }
    @Override
    public void updateCricketer(Cricketer cricketer) {
        CricketerService.super.updateCricketer(cricketer);
        cricketerDAO.updateCricketer(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        CricketerService.super.deleteCricketer(cricketerId);
        cricketerDAO.deleteCricketer(cricketerId);
    }
    @Override
    public Cricketer getCricketerById(int cricketerId) {
         CricketerService.super.getCricketerById(cricketerId);
         return cricketerDAO.getCricketerById(cricketerId);
    }
}