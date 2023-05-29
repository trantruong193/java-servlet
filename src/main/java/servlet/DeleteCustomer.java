package servlet;

import dao.CustomerDao;
import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "DeleteCustomer", value = "/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String cusId = request.getParameter("cusId");
        if(CustomerDao.deleteCustomer(cusId)){
            request.setAttribute("success","Delete Success!");
        }else {
            request.setAttribute("err","Delete Fail!");
        }
        List<Customer> list = CustomerDao.loadCustomer();
        request.setAttribute("list",list);
        request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
