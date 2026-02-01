package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.dao.TeamDAOImpl;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

import java.sql.SQLException;
import java.util.List;

public class TeamServiceImplJdbc implements TeamService {

    private TeamDAO teamDAO = new TeamDAOImpl();

    @Override
    public List<Team> getAllTeams() throws SQLException {
        return teamDAO.getAllTeams();
    }

    @Override
    public int addTeam(Team team) throws SQLException {
        return teamDAO.addTeam(team);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() throws SQLException {
        List<Team> teams = teamDAO.getAllTeams();
        teams.sort((t1, t2) -> t1.getTeamName().compareToIgnoreCase(t2.getTeamName()));
        return teams;
    }

    @Override
    public Team getTeamById(int teamId) throws SQLException {
        return teamDAO.getTeamById(teamId);
    }

    @Override
    public void updateTeam(Team team) throws SQLException {
        teamDAO.updateTeam(team);
    }

    @Override
    public void deleteTeam(int teamId) throws SQLException {
        teamDAO.deleteTeam(teamId);
    }
}
