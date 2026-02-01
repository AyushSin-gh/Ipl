

package com.edutech.progressive.service;

import com.edutech.progressive.dao.CricketerDAO;
import com.edutech.progressive.dao.CricketerDAOImpl;
import com.edutech.progressive.model.Cricketer;

import java.sql.SQLException;
import java.util.Comparator;
import java.util.List;
import java.sql.SQLException;
import java.util.*;

public class CricketerServiceImplJdbc {

    private CricketerDAO cricketerDAO = new CricketerDAOImpl();

    public List<Cricketer> getAllCricketers() throws SQLException {
        return cricketerDAO.getAllCricketers();
    }

    public Integer addCricketer(Cricketer cricketer) throws SQLException {
        return cricketerDAO.addCricketer(cricketer);
    }

    public List<Cricketer> getAllCricketersSortedByExperience() throws SQLException {
        List<Cricketer> list = cricketerDAO.getAllCricketers();
        list.sort(Comparator.comparingInt(Cricketer::getExperience));
        return list;
    }

    public void updateCricketer(Cricketer cricketer) throws SQLException {
        cricketerDAO.updateCricketer(cricketer);
    }

    public void deleteCricketer(int id) throws SQLException {
        cricketerDAO.deleteCricketer(id);
    }

    public Cricketer getCricketerById(int id) throws SQLException {
        return cricketerDAO.getCricketerById(id);
    }
}

