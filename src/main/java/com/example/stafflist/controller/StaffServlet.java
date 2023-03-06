package com.example.stafflist.controller;

import com.example.stafflist.model.Staff;
import com.example.stafflist.service.StaffServiceSQL;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serial;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "StaffServlet", value = "/employees")
public class StaffServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 1L;
    private StaffServiceSQL staffServiceSQL;

    public void init() {
        staffServiceSQL = new StaffServiceSQL();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create" -> showCreateForm(request, response);
                case "edit" -> showEditForm(request, response);
                case "delete" -> showDeleteForm(request, response);
                case "view" -> viewStaff(request, response);
                default -> listEmployees(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create" -> createStaff(request, response);
                case "edit" -> updateStaff(request, response);
                case "delete" -> deleteStaff(request, response);
            }
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    private void listEmployees(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        List<Staff> employees = staffServiceSQL.findAll();
        request.setAttribute("employees", employees);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/list.jsp");
            dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        dispatcher.forward(request, response);
    }

    private void createStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        String staff_code = request.getParameter("staff_code");
        String staff_name = request.getParameter("staff_name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");

        Staff newStaff = new Staff(staff_code, staff_name, id_card, phone_number, address, email, note);
        staffServiceSQL.save(newStaff);
        RequestDispatcher dispatcher = request.getRequestDispatcher("staff/create.jsp");
        request.setAttribute("message", "New staff was created");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffServiceSQL.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404/jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");

        }
        dispatcher.forward(request, response);
    }

    private void updateStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String staff_code = request.getParameter("staff_code");
        String staff_name = request.getParameter("staff_name");
        String id_card = request.getParameter("id_card");
        String phone_number = request.getParameter("phone_number");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String note = request.getParameter("note");
        Staff staff = staffServiceSQL.findById(id);
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
            staffServiceSQL.updateStaff(staff);
            request.setAttribute("staff", staff);
            request.setAttribute("message", "Staff information was updated");
            dispatcher = request.getRequestDispatcher("staff/edit.jsp");
        }
        dispatcher.forward(request, response);
    }

    private void showDeleteForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffServiceSQL.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/delete.jsp");
        }
        dispatcher.forward(request, response);
    }

    public void deleteStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffServiceSQL.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            staffServiceSQL.deleteStaff(id);
            response.sendRedirect("/employees");
        }
    }

    private void viewStaff(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, SQLException, IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Staff staff = staffServiceSQL.findById(id);
        RequestDispatcher dispatcher;
        if (staff == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("staff", staff);
            dispatcher = request.getRequestDispatcher("staff/view.jsp");
        }
        dispatcher.forward(request, response);
    }

}
