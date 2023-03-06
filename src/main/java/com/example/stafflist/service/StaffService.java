package com.example.stafflist.service;

import com.example.stafflist.model.Staff;

import java.sql.SQLException;
import java.util.List;

public interface StaffService {
    List<Staff> findAll();
    void save(Staff staff) throws SQLException;
    Staff findById(int id);
    boolean updateStaff(Staff staff) throws SQLException;
    boolean deleteStaff(int id) throws SQLException;
}
