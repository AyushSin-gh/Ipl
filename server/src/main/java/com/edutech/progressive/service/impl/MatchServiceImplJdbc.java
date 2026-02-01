package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Match;
import com.edutech.progressive.service.MatchService;

import java.sql.SQLException;
import java.util.List;

import java.sql.SQLException;
import java.util.List;

public class MatchServiceImplJdbc implements MatchService {

    private MatchDAO matchDAO = new MatchDAOImpl();

    @Override
    public List<Match> getAllMatches() throws SQLException {
        return matchDAO.getAllMatches();
    }

    @Override
    public Match getMatchById(int matchId) throws SQLException {
        return matchDAO.getMatchById(matchId);
    }

    @Override
    public Integer addMatch(Match match) throws SQLException {
        return matchDAO.addMatch(match);
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        matchDAO.updateMatch(match);
    }

    @Override
    public void deleteMatch(int matchId) throws SQLException {
        matchDAO.deleteMatch(matchId);
    }
}
deleteMatch(int id) throws SQLException {
        matchDAO.deleteMatch(id);
    }
}
