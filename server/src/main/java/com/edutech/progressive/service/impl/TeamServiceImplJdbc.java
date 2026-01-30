package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.dao.TeamDAO;
import com.edutech.progressive.dao.TeamDAOImpl;
import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplJdbc  implements TeamService{
    private TeamDAO teamDAO=new TeamDAOImpl();

    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        return -1;
    }

    @Override
    public void deleteTeam(int teamId) {
        // TODO Auto-generated method stub
        //TeamService.super.deleteTeam(teamId);
    }

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        // TODO Auto-generated method stub
        return new ArrayList<>();
    }

    @Override
    public Team getTeamById(int teamId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void updateTeam(Team team) {
        // TODO Auto-generated method stub
        //TeamService.super.updateTeam(team);
    };
    

}