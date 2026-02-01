package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Cricketer;
import com.edutech.progressive.service.CricketerService;

import java.sql.SQLException;
import java.util.List;

public interface CricketerService {

    List<Cricketer> getAllCricketers() throws SQLException;

    Integer addCricketer(Cricketer cricketer) throws SQLException;

    List<Cricketer> getAllCricketersSortedByExperience() throws SQLException;

    default void emptyArrayList() {
        // placeholder
    }

    default void updateCricketer(Cricketer cricketer) throws SQLException {
        // should not be implemented in ArrayList service
    }

    default void deleteCricketer(int cricketerId) throws SQLException {
        // should not be implemented in ArrayList service
    }

    default Cricketer getCricketerById(int cricketerId) throws SQLException {
        return null;
    }

    default List<Cricketer> getCricketersByTeam(int teamId) {
        return null;
    }
}
