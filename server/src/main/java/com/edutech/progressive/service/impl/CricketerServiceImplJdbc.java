// package com.edutech.progressive.service.impl;

// import java.util.ArrayList;
// import java.util.List;

// import com.edutech.progressive.dao.CricketerDAO;
// import com.edutech.progressive.dao.CricketerDAOImpl;
// import com.edutech.progressive.entity.Cricketer;
// import com.edutech.progressive.service.CricketerService;

// public class CricketerServiceImplJdbc implements CricketerService  {
//     private CricketerDAO cricketerDAO=new CricketerDAOImpl();

//     @Override
//     public Integer addCricketer(Cricketer cricketer) {
//         // TODO Auto-generated method stub
//         return -1;
//     }

//     @Override
//     public void deleteCricketer(int cricketerId) {
//         // TODO Auto-generated method stub
//        // CricketerService.super.deleteCricketer(cricketerId);
//     }

//     @Override
//     public List<Cricketer> getAllCricketers() {
//         // TODO Auto-generated method stub
//         return new ArrayList<>();
//     }

//     @Override
//     public List<Cricketer> getAllCricketersSortedByExperience() {
//         // TODO Auto-generated method stub
//         return new ArrayList<>();
//     }

//     @Override
//     public Cricketer getCricketerById(int cricketerId) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void updateCricketer(Cricketer cricketer) {
//         // TODO Auto-generated method stub
//         //CricketerService.super.updateCricketer(cricketer);
//     }
    
// }

package com.edutech.progressive.service;

import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.dao.CricketerDAOImpl;
import com.edutech.progressive.model.Cricketer;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;

public class CricketerServiceImplJdbc implements CricketerService {

    private CricketerDAO cricketerDAO = new CricketerDAOImpl();

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        return cricketerDAO.getAllCricketers();
    }

    @Override
    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        return cricketerDAO.addCricketer(cricketer);
    }

    @Override
    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        List<Cricketer> list = cricketerDAO.getAllCricketers();
        list.sort(Comparator.comparingInt(Cricketer::getExperience).reversed());
        return list;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {
        cricketerDAO.updateCricketer(cricketer);
    }

    @Override
    public void deleteCricketer(int cricketerId) throws SQLException {
        cricketerDAO.deleteCricketer(cricketerId);
    }

    @Override
    public Cricketer getCricketerById(int cricketerId) throws SQLException {
        return cricketerDAO.getCricketerById(cricketerId);
    }
}
