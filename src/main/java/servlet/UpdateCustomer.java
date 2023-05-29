package servlet;

import dao.CustomerDao;
import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "UpdateCustomer", value = "/UpdateCustomer")
public class UpdateCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cusId = request.getParameter("cusId");
        Customer customer = CustomerDao.findCustomer(cusId);
        request.setAttribute("c",customer);
        request.getRequestDispatcher("updatecustomer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
