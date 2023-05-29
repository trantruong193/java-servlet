package servlet;

import dao.CustomerDao;
import entity.Customer;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PreUpdate", value = "/PreUpdate")
public class PreUpdate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String cusId = request.getParameter("cusId");
        String cusName = request.getParameter("cusName");
        boolean gender = Boolean.parseBoolean(request.getParameter("gender"));
        Date birthday = null;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            birthday = simpleDateFormat.parse(request.getParameter("birthday"));
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String telephone = request.getParameter("telephone");
        Customer c = new Customer(cusId,cusName,gender,birthday,address,email,telephone);

        if(CustomerDao.updateCustomer(c)){
            List<Customer> list = CustomerDao.loadCustomer();
            request.setAttribute("list",list);
            request.getRequestDispatcher("listCustomer.jsp").forward(request,response);
        }else {
            request.setAttribute("err","Update Fail");
            request.getRequestDispatcher("updatecustomer.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
