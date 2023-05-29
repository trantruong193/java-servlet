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

@WebServlet(name = "InsertCustomer", value = "/InsertCustomer")
public class InsertCustomer extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
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
        if(CustomerDao.insertCustomer(c)){
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }else {
            request.setAttribute("err","Add Fail");
            request.getRequestDispatcher("insertCustomer.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
