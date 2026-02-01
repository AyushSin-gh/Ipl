package com.edutech.progressive.dao;

import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.entity.Match;

import java.sql.*;
import java.util.*;

public class MatchDAOImpl implements MatchDAO {

    @Override
    public int addMatch(Match m) throws SQLException {
        String sql = "INSERT INTO matches(first_team_id, second_team_id, match_date, venue, result, status, winner_team_id) VALUES(?,?,?,?,?,?,?)";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, m.getFirstTeamId());
            ps.setInt(2, m.getSecondTeamId());
            ps.setDate(3, Date.valueOf(m.getMatchDate()));
            ps.setString(4, m.getVenue());
            ps.setString(5, m.getResult());
            ps.setString(6, m.getStatus());
            ps.setInt(7, m.getWinnerTeamId());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    @Override
    public Match getMatchById(int id) throws SQLException {
        String sql = "SELECT * FROM matches WHERE match_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            return rs.next() ? new Match(rs) : null;
        }
    }

    @Override
    public void updateMatch(Match match) throws SQLException {
        String sql = "UPDATE matches SET status=?, result=?, winner_team_id=? WHERE match_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, match.getStatus());
            ps.setString(2, match.getResult());
            ps.setInt(3, match.getWinnerTeamId());
            ps.setInt(4, match.getMatchId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteMatch(int id) throws SQLException {
        String sql = "DELETE FROM matches WHERE match_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Match> getAllMatches() throws SQLException {
        List<Match> list = new ArrayList<>();
        String sql = "SELECT * FROM matches";

        try (Connection con = DatabaseConnectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Match(rs));
            }
        }
        return list;
    }
}
