package com.example.stafflist.model;

public class Staff {
    private int id;
    private String staff_code;
    private String staff_name;
    private String id_card;
    private String phone_number;
    private String address;
    private String email;
    private String note;

    public Staff() {
    }

    public Staff(String staff_code, String staff_name, String id_card, String phone_number,
                 String address, String email, String note)
    {
        super();
        this.staff_code = staff_code;
        this.staff_name = staff_name;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.note = note;
    }

    public Staff(int id, String staff_code, String staff_name, String id_card, String phone_number,
                            String address, String email, String note)
    {
        super();
        this.id = id;
        this.staff_code = staff_code;
        this.staff_name = staff_name;
        this.id_card = id_card;
        this.phone_number = phone_number;
        this.address = address;
        this.email = email;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStaff_code() {
        return staff_code;
    }

    public void setStaff_code(String staff_code) {
        this.staff_code = staff_code;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getId_card() {
        return id_card;
    }

    public void setId_card(String id_card) {
        this.id_card = id_card;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
