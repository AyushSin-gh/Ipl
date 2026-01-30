package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.edutech.progressive.entity.Team;
import com.edutech.progressive.service.TeamService;

public class TeamServiceImplArraylist implements TeamService  {
   List<Team> list=new ArrayList<>();

   @Override
   public List<Team> getAllTeams() {
       return list;
   }
   @Override
   public int addTeam(Team team) {
       list.add(team);
       return -1;
   }
   @Override
   public List<Team> getAllTeamsSortedByName() {
       List<Team> l= new ArrayList<>(list);
       l.sort(Comparator.comparing(Team::getTeamName));
       return l;
   }
   @Override
   public void emptyArrayList() {
       TeamService.super.emptyArrayList();
       list.clear();
   }
   

}