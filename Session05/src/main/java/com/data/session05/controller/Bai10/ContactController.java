package com.data.session05.controller.Bai10;

import com.data.session05.model.Bai10.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ContactController", value = "/contacts")
public class ContactController extends HttpServlet {
    private List<Contact> contacts = new ArrayList<>();
    private int nextId = 1;

    @Override
    public void init() throws ServletException {
        contacts.add(new Contact(nextId++, "An", "Nguyen", "an.nguyen@example.com", "0912345671"));
        contacts.add(new Contact(nextId++, "Binh", "Tran", "binh.tran@example.com", "0912345672"));
        contacts.add(new Contact(nextId++, "Cuong", "Le", "cuong.le@example.com", "0912345673"));
        contacts.add(new Contact(nextId++, "Dung", "Pham", "dung.pham@example.com", "0912345674"));
        contacts.add(new Contact(nextId++, "Hieu", "Hoang", "hieu.hoang@example.com", "0912345675"));
        contacts.add(new Contact(nextId++, "Khanh", "Vu", "khanh.vu@example.com", "0912345676"));
        contacts.add(new Contact(nextId++, "Long", "Do", "long.do@example.com", "0912345677"));
        contacts.add(new Contact(nextId++, "Minh", "Bui", "minh.bui@example.com", "0912345678"));
        contacts.add(new Contact(nextId++, "Nam", "Dang", "nam.dang@example.com", "0912345679"));
        contacts.add(new Contact(nextId++, "Phong", "Trinh", "phong.trinh@example.com", "0912345680"));
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) action = "";

        switch (action) {
            case "add":
                request.getRequestDispatcher("views/Bai10/form.jsp").forward(request, response);
                break;
            case "edit":
                int editId = Integer.parseInt(request.getParameter("id"));
                for (Contact c : contacts) {
                    if (c.getId() == editId) {
                        request.setAttribute("contact", c);
                        request.getRequestDispatcher("views/Bai10/form.jsp").forward(request, response);
                        return;
                    }
                }
                response.sendRedirect("contacts");
                break;
            default:
                request.setAttribute("contacts", contacts);
                request.getRequestDispatcher("views/Bai10/contact.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        switch (action) {
            case "create":
                Contact newContact = new Contact(
                        nextId++,
                        request.getParameter("firstName"),
                        request.getParameter("lastName"),
                        request.getParameter("email"),
                        request.getParameter("phone")
                );
                contacts.add(newContact);
                response.sendRedirect("contacts");
                break;

            case "update":
                int updateId = Integer.parseInt(request.getParameter("id"));
                for (Contact c : contacts) {
                    if (c.getId() == updateId) {
                        c.setFirstName(request.getParameter("firstName"));
                        c.setLastName(request.getParameter("lastName"));
                        c.setEmail(request.getParameter("email"));
                        c.setPhone(request.getParameter("phone"));
                        break;
                    }
                }
                response.sendRedirect("contacts");
                break;

            case "delete":
                int deleteId = Integer.parseInt(request.getParameter("id"));
                contacts.removeIf(c -> c.getId() == deleteId);
                response.sendRedirect("contacts");
                break;
        }
    }
}