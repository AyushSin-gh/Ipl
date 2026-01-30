package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Match;

public class MatchDAOImpl implements MatchDAO{
    List<Match> list=new ArrayList<>();
   @Override
   public int addMatch(Match match) {
      list.add(match);
      return -1;
   }
   @Override
   public Match getMatchById(int matchId) {
       for(Match m:list){
         if(m.getMatchId() == matchId){
            return m;
         }
       }
       return null;
   }

   @Override
   public void updateMatch(Match match) {
    for(int i=0;i<list.size();i++){
        if(list.get(i).getMatchId() == match.getMatchId()){
          list.set(i, match);
          return;
        }
    }
   }

   @Override
   public void deleteMatch(int matchId) {
       for(Match m:list){
            if(m.getMatchId() == matchId){
                list.remove(m);
            }
       }
   }
   @Override
   public List<Match> getAllMatches() {
       return list;
   }
}
