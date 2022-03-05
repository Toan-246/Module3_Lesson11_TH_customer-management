package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.service.CustomerService;
import com.codegym.service.ICustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", value = "/customers")
public class CustomerServlet extends HttpServlet {
    ICustomerService customerService = new CustomerService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = customerService.findById(id);
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/delete.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "edit": {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = customerService.findById(id);
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/edit.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "view": {
                int id = Integer.parseInt(request.getParameter("id"));
                Customer customer = customerService.findById(id);
                request.setAttribute("customer", customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/view.jsp");
                dispatcher.forward(request, response);
                break;
            }
            default: {
                List<Customer> customers = customerService.findAll();
                request.setAttribute("listCustomer", customers);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/list.jsp");
                dispatcher.forward(request, response);
                break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                Customer customer = new Customer(id, name, email, address);
                customerService.create(customer);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/customer/create.jsp");
                dispatcher.forward(request, response);
                break;
            }
            case "delete": {
                int id = Integer.parseInt(request.getParameter("id"));
                customerService.remote(id);
                response.sendRedirect("/customers");
                break;
            }
            case "edit": {
                int id = Integer.parseInt(request.getParameter("id"));
                String name = request.getParameter("name");
                String email = request.getParameter("email");
                String address = request.getParameter("address");
                Customer customer = new Customer(id, name, email, address);
                customerService.update(id, customer);
                response.sendRedirect("/customers");
                break;
            }
        }
    }
}
