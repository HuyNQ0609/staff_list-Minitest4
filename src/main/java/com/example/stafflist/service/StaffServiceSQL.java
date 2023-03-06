package com.example.stafflist.service;

import com.example.stafflist.connect.StaffConnection;
import com.example.stafflist.model.Staff;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StaffServiceSQL implements StaffService {
    StaffConnection staffConnection = new StaffConnection();

    private static final String ADD_STAFF_SQL;
    private static final String SELECT_STAFF_BY_ID;
    private static final String SELECT_ALL_EMPLOYEES;
    private static final String UPDATE_STAFF_SQL;
    private static final String DELETE_STAFF_SQL;

    static {
        ADD_STAFF_SQL = "insert into Employees (id, staff_code, staff_name, id_card, phone_number, address, email, note)" +
                        "values (?, ?, ?, ?, ?, ?, ?, ?)";
        SELECT_STAFF_BY_ID = "select id, staff_code, staff_name, id_card, phone_number, address, email, note " +
                        "from Employees where id = ?";
        SELECT_ALL_EMPLOYEES = "select * from Employees";
        UPDATE_STAFF_SQL = "update Employees set staff_code = ?, staff_name = ?, id_card = ?, phone_number = ?, address = ?, note = ?" +
                        "where id = ?";
        DELETE_STAFF_SQL = "delete from employees where id = ?";
    }

    public StaffServiceSQL() {

    }

    @Override
    public List<Staff> findAll() {
        List<Staff> employees = new ArrayList<>();
        try (Connection con = staffConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(SELECT_ALL_EMPLOYEES)) {
            System.out.println(pre);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                int id = res.getInt("id");
                String staff_code = res.getString("staff_code");
                String staff_name = res.getString("staff_name");
                String id_card = res.getString("id_card");
                String phone_number = res.getString("phone_number");
                String address = res.getString("address");
                String email = res.getString("email");
                String note = res.getString("note");
                employees.add(new Staff(id, staff_code, staff_name, id_card, phone_number, address, email, note));
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return employees;
    }

    @Override
    public void save(Staff staff) throws SQLException {
        System.out.println(ADD_STAFF_SQL);
        try (Connection con = staffConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(ADD_STAFF_SQL)) {
            pre.setString(1, staff.getStaff_code());
            pre.setString(2, staff.getStaff_name());
            pre.setString(3, staff.getId_card());
            pre.setString(4, staff.getPhone_number());
            pre.setString(5, staff.getAddress());
            pre.setString(6, staff.getEmail());
            pre.setString(7, staff.getNote());
            System.out.println(pre);
            pre.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Staff findById(int id) {
        Staff staff = null;
        try (Connection con = staffConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(SELECT_STAFF_BY_ID)) {
            pre.setInt(1, id);
            System.out.println(pre);
            ResultSet res = pre.executeQuery();
            while (res.next()) {
                String staff_code = res.getString("staff_code");
                String staff_name = res.getString("staff_name");
                String id_card = res.getString("id_card");
                String phone_number = res.getString("phone_number");
                String address = res.getString("address");
                String email = res.getString("email");
                String note = res.getString("note");
                staff = new Staff(id, staff_code, staff_name, id_card, phone_number, address, email, note);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return staff;
    }

    @Override
    public boolean updateStaff(Staff staff) throws SQLException {
        boolean rowUpdated;
        try (Connection con = staffConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(UPDATE_STAFF_SQL)) {
            pre.setString(1, staff.getStaff_code());
            pre.setString(2, staff.getStaff_name());
            pre.setString(3, staff.getId_card());
            pre.setString(4, staff.getPhone_number());
            pre.setString(5, staff.getAddress());
            pre.setString(6, staff.getEmail());
            pre.setString(7, staff.getNote());
            rowUpdated = pre.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public boolean deleteStaff(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection con = staffConnection.getConnection();
             PreparedStatement pre = con.prepareStatement(DELETE_STAFF_SQL)) {
            pre.setInt(1, id);
            rowDeleted = pre.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
