//package com.edutech.progressive.dao;

// import java.util.ArrayList;
// import java.util.List;

// import com.edutech.progressive.entity.Cricketer;

// public class CricketerDAOImpl implements CricketerDAO{

//     @Override
//     public int addCricketer(Cricketer cricketer) {
//         // TODO Auto-generated method stub
//         return -1;
//     }

//     @Override
//     public void deleteCricketer(int cricketerId) {
//         // TODO Auto-generated method stub
        
//     }

//     @Override
//     public List<Cricketer> getAllCricketers() {
//         // TODO Auto-generated method stub
//         return new ArrayList<>();
//     }

//     @Override
//     public Cricketer getCricketerById(int cricketerId) {
//         // TODO Auto-generated method stub
//         return null;
//     }

//     @Override
//     public void updateCricketer(Cricketer cricketer) {
//         // TODO Auto-generated method stub
        
//     }
    

// }


package com.edutech.progressive.dao;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.model.Cricketer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CricketerDAOImpl implements CricketerDAO {

    @Override
    public int addCricketer(Cricketer cricketer) throws SQLException {

        String sql = "INSERT INTO cricketer(name, experience, team_id) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, cricketer.getName());
            ps.setInt(2, cricketer.getExperience());
            ps.setInt(3, cricketer.getTeamId());

            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            return rs.next() ? rs.getInt(1) : 0;
        }
    }

    @Override
    public Cricketer getCricketerById(int id) throws SQLException {

        String sql = "SELECT * FROM cricketer WHERE id=?";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return new Cricketer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("experience"),
                        rs.getInt("team_id")
                );
            }
        }
        return null;
    }

    @Override
    public void updateCricketer(Cricketer cricketer) throws SQLException {

        String sql = "UPDATE cricketer SET name=?, experience=?, team_id=? WHERE id=?";

        try (Connection con = DatabaseConnectionManager.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, cricketer.getName());
            ps.setInt(2, cricketer.getExperience());
            ps.setInt(3, cricketer.getTeamId());
            ps.setInt(4, cricketer.getId());

            ps.executeUpdate();
        }
    }

    @Override
    public void deleteCricketer(int id) throws SQLException {

        String sql = "DELETE FROM cricketer WHERE id=?";

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
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Cricketer(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("experience"),
                        rs.getInt("team_id")
                ));
            }
        }
        return list;
    }
}
