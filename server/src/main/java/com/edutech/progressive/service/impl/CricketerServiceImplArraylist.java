package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

public class CricketerServiceImplArraylist  implements CricketerService {
   List<Cricketer> list=new ArrayList<>();

   @Override
   public List<Cricketer> getAllCricketers() {
       return list;
   }

   @Override
   public Integer addCricketer(Cricketer cricketer) {
       list.add(cricketer);
       return -1;
   }

   @Override
   public List<Cricketer> getAllCricketersSortedByExperience() {
       List<Cricketer> l= new ArrayList<>(list);
       l.sort(Comparator.comparing(Cricketer::getExperience));
       return l;
   }

   @Override
   public void emptyArrayList() {
       CricketerService.super.emptyArrayList();
       list.clear();
   }


}