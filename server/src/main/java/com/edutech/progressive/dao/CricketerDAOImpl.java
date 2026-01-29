package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;

public class CricketerDAOImpl implements CricketerDAO{
    List<Cricketer> list= new ArrayList<>();
   @Override
   public int addCricketer(Cricketer cricketer) {
       list.add(cricketer);
       return 1;
   }
   @Override
   public Cricketer getCricketerById(int cricketerId) {
      for(Cricketer c:list){
        if(c.getCricketerId() == cricketerId){
            return c;
        }
      }
      return null;
   }
   @Override
   public void updateCricketer(Cricketer cricketer) {
    for(int i=0;i<list.size();i++){
        if(list.get(i).getCricketerId() == cricketer.getCricketerId()){
            list.set(i, cricketer);
            return;
        }
    }
   }
   @Override
   public void deleteCricketer(int cricketerId) {
      for(Cricketer c:list){
        if(c.getCricketerId() == cricketerId){
            list.remove(cricketerId);
        }
      } 
       
   }
   @Override
   public List<Cricketer> getAllCricketers() {
       return list;
   }
}
