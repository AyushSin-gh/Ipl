package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;

import java.sql.SQLException;
import java.util.List;

public class MatchServiceImplJdbc {

    private MatchDAO matchDAO = new MatchDAOImpl();

    public List<Match> getAllMatches() throws SQLException {
        return matchDAO.getAllMatches();
    }

    public Match getMatchById(int id) throws SQLException {
        return matchDAO.getMatchById(id);
    }

    public Integer addMatch(Match match) throws SQLException {
        return matchDAO.addMatch(match);
    }

    public void updateMatch(Match match) throws SQLException {
        matchDAO.updateMatch(match);
    }

    public void deleteMatch(int id) throws SQLException {
        matchDAO.deleteMatch(id);
    }
}
