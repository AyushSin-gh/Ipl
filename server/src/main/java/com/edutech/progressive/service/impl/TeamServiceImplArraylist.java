package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService  {
    private List<Team> list=new ArrayList<>();
    @Override
    public int addTeam(Team team) {
        // TODO Auto-generated method stub
        list.add(team);
        return list.size();
    }

    @Override
    public void emptyArrayList() {
        // TODO Auto-generated method stub
        //TeamService.super.emptyArrayList();
        list.clear();
    }

    @Override
    public List<Team> getAllTeams() {
        // TODO Auto-generated method stub
        return new ArrayList<>(list);
    }

    @Override
    public List<Team> getAllTeamsSortedByName() {
        // TODO Auto-generated method stub
        List<Team> sorted=new ArrayList<>(list);
        Collections.sort(sorted);
        return sorted;
    }
    
}