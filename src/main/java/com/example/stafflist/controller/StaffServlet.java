package com.example.stafflist.controller;

import com.example.stafflist.model.Staff;
import com.example.stafflist.service.StaffService;
import com.example.stafflist.service.StaffServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/employees")
public class StaffServlet extends HttpServlet {
    private final StaffService staffService = new StaffServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create"   -> showCreateForm(request, response);
            case "edit"     -> showEditForm(request, response);
            case "delete"   -> showDeleteForm(request, response);
            case "view"     -> viewStaff(request, response);
            default         -> listEmployees(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create"   -> createStaff(request, response);
            case "edit"     -> updateStaff(request, response);
            case "delete"   -> deleteStaff(request, response);
            case "view"     -> viewStaff(request, response);
            default         -> listEmployees(request, response);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response) {
        List<Staff> employees = this.staffService.findAll();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response) {
        String staff_code = request.getParameter("staff_code");
        String staff_name = request.getParameter("staff_name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        int id = (int) (Math.random() * 10000);

        Staff staff = new Staff(id, staff_code, staff_name, id_card, phone_number, address, email, note);
        this.staffService.save(staff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        request.setAttribute("message", "New staff was created");
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404/jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");

        }
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String staff_code = request.getParameter("staff_code");
        String staff_name = request.getParameter("staff_name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            staff.setStaff_code(staff_code);
            staff.setStaff_name(staff_name);
            staff.setId_card(id_card);
            staff.setPhone_number(phone_number);
            staff.setAddress(address);
            staff.setEmail(email);
            staff.setNote(note);
            this.staffService.update(id, staff);
            request.setAttribute("staff", staff);
            request.setAttribute("message", "Staff information was updated");
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.staffService.delete(id);
            try {
                response.sendRedirect("/employees");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void viewStaff(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = this.staffService.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/view.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
