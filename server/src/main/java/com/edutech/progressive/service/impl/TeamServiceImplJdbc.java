package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplJdbc implements TeamService  {
    TeamDAO teamDAO;
    @Override
    public List<Team> getAllTeams() {
        return teamDAO.getAllTeams();
    }

    @Override
    public int addTeam(Team team) {
        teamDAO.addTeam(team);
        return -1;
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        List<Team> l= new ArrayList<>(teamDAO.getAllTeams());
        l.sort(Comparator.comparing(Team::getTeamName));
        return l;
    }
    @Override
    public Team getTeamById(int teamId) {
        
            TeamService.super.getTeamById(teamId);
            return teamDAO.getTeamById(teamId);
    }
    @Override
    public void updateTeam(Team team) {
        TeamService.super.updateTeam(team);
        teamDAO.updateTeam(team);
    }
    @Override
    public void deleteTeam(int teamId) {
        TeamService.super.deleteTeam(teamId);
        teamDAO.deleteTeam(teamId);
    }

}