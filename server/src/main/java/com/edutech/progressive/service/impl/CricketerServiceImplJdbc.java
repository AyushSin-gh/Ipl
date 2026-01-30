package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.dao.CricketerDAOImpl;
import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplJdbc implements CricketerService  {
    private CricketerDAO cricketerDAO=new CricketerDAOImpl();

    @Override
    public Integer addCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public void deleteCricketer(int cricketerId) {
        // TODO Auto-generated method stub
       // CricketerService.super.deleteCricketer(cricketerId);
    }

    @Override
    public List<Cricketer> getAllCricketers() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) {
        // TODO Auto-generated method stub
        //CricketerService.super.updateCricketer(cricketer);
    }
    
}