package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Team;

public class TeamDAOImpl implements TeamDAO{
  List<Team> list= new ArrayList<>();
    @Override
    public int addTeam(Team team) {
          list.add(team);
        return -1;
    }
    @Override
    public Team getTeamById(int teamId) {
        for(Team t:list){
           if(t.getTeamId() == teamId){
            return t;
           }
        }
        return null;
    }

    @Override
    public void updateTeam(Team team) {
        for(int i=0;i<list.size();i++){
            if(list.get(i).getTeamId() == team.getTeamId()){
                list.set(i, team);
                return;
            }
        }
    }

    @Override
    public void deleteTeam(int teamId) {
        for(Team t:list){
            if(t.getTeamId() == teamId){
                list.remove(t);
                return;
            }
        }
    }

    @Override
    public List<Team> getAllTeams() {
        return list;
    }



}
