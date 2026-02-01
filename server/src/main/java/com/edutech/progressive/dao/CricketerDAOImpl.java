package com.edutech.progressive.dao;
import java.util.ArrayList;
import java.util.List;
import com.edutech.progressive.entity.Cricketer;
import java.sql.*;
import java.util.*;

public class CricketerDAOImpl implements CricketerDAO {

    @Override
    public int addCricketer(Cricketer c) throws SQLException {
        String sql = "INSERT INTO cricketer(team_id, cricketer_name, age, nationality, experience, role, total_runs, total_wickets) VALUES(?,?,?,?,?,?,?,?)";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, c.getTeamId());
            ps.setString(2, c.getCricketerName());
            ps.setInt(3, c.getAge());
            ps.setString(4, c.getNationality());
            ps.setInt(5, c.getExperience());
            ps.setString(6, c.getRole());
            ps.setInt(7, c.getTotalRuns());
            ps.setInt(8, c.getTotalWickets());

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : -1;
        }
    }

    @Override
    public Cricketer getCricketerById(int id) throws SQLException {
        String sql = "SELECT * FROM cricketer WHERE cricketer_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cricketer(
                        rs.getInt("cricketer_id"),
                        rs.getInt("team_id"),
                        rs.getString("cricketer_name"),
                        rs.getInt("age"),
                        rs.getString("nationality"),
                        rs.getInt("experience"),
                        rs.getString("role"),
                        rs.getInt("total_runs"),
                        rs.getInt("total_wickets")
                );
            }
            return null;
        }
    }

    @Override
    public void updateCricketer(Cricketer c) throws SQLException {
        String sql = "UPDATE cricketer SET experience=?, total_runs=?, total_wickets=? WHERE cricketer_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, c.getExperience());
            ps.setInt(2, c.getTotalRuns());
            ps.setInt(3, c.getTotalWickets());
            ps.setInt(4, c.getCricketerId());
            ps.executeUpdate();
        }
    }

    @Override
    public void deleteCricketer(int id) throws SQLException {
        String sql = "DELETE FROM cricketer WHERE cricketer_id=?";
        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public List<Cricketer> getAllCricketers() throws SQLException {
        List<Cricketer> list = new ArrayList<>();
        String sql = "SELECT * FROM cricketer";

        try (Connection con = DatabaseConnectionManager.getConnection();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                list.add(new Cricketer(
                        rs.getInt("cricketer_id"),
                        rs.getInt("team_id"),
                        rs.getString("cricketer_name"),
                        rs.getInt("age"),
                        rs.getString("nationality"),
                        rs.getInt("experience"),
                        rs.getString("role"),
                        rs.getInt("total_runs"),
                        rs.getInt("total_wickets")
                ));
            }
        }
        return list;
    }
}
