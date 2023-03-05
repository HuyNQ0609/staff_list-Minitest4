package com.example.stafflist.service;

import com.example.stafflist.model.Staff;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StaffServiceImpl implements StaffService {
    private static final Map<Integer, Staff> employees;

    static {
        employees = new HashMap<>();
        employees.put(1, new Staff(1, "NVFT23301", "Bao Duong", "035736823756",
                "0932878773", "Thanh Hoa", "duongbao@gmail.com", "Full time"));
        employees.put(2, new Staff(2, "NVPT09233", "Quoc Trieu", "035872852859",
                "0966423135", "Nghe An", "trieuquoc@gmail.com", "Part time"));
        employees.put(3, new Staff(3,"NVFT16867", "Tien Luc", "030014302199",
                "0865774283", "Ha Tinh", "luctien@gmail.com", "Full time"));
        employees.put(4, new Staff(4, "NVPT16602", "Anh Tuan", "034012664378",
                "0912763289", "Quang Binh", "tuananh@gmail.com", "Part time"));
        employees.put(5, new Staff(5, "NVFT09712", "Van Nam", "033923256783",
                "0966723539", "Da Nang", "namvan@gmail.com", "Full time"));
        employees.put(6, new Staff(6, "NVPT14365", "Van Doan", "034201007731",
                "0944276643", "Ha Noi", "doanvan@gmail.com", "Part time"));
    }

    @Override
    public List<Staff> findAll() {
        return new ArrayList<>(employees.values());
    }

    @Override
    public void save(Staff staff) {
        employees.put(staff.getId(), staff);
    }

    @Override
    public Staff findById(int id) {
        return employees.get(id);
    }

    @Override
    public void update(int id, Staff staff) {
        employees.put(id, staff);
    }

    @Override
    public void delete(int id) {
        employees.remove(id);
    }
}
