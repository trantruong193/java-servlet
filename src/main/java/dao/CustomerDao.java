package dao;

import database.JDBCUtil;
import entity.Customer;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CustomerDao {
    public static List<Customer> loadCustomer(){
        List<Customer> list = new ArrayList<>();
        Connection c = JDBCUtil.openConnection();
        try {
            PreparedStatement pst =  c.prepareStatement("SELECT * FROM Customers");
            ResultSet rss =  pst.executeQuery();
            while (rss.next()){
                Customer customer = new Customer();
                customer.setCusId(rss.getString(1));
                customer.setCusName(rss.getString(2));
                customer.setGender(rss.getBoolean(3));
                SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    customer.setBirthday(sf.parse(rss.getString(4)));
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                customer.setAddress(rss.getString(5));
                customer.setEmail(rss.getString(6));
                customer.setTelephone(rss.getString(7));
                list.add(customer);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.closeConnect(c);
        }
        return list;
    }
    public static boolean insertCustomer(Customer customer){
        boolean kq = false;
        Connection c = JDBCUtil.openConnection();
        try {
            PreparedStatement pst = c.prepareStatement("INSERT INTO Customers(CusId,CusName,Gender,Birthday,Address,Email,Telephone) VALUES (?,?,?,?,?,?,?)");
            pst.setString(1,customer.getCusId());
            pst.setString(2,customer.getCusName());
            pst.setBoolean(3,customer.isGender());
            pst.setDate(4,new Date(customer.getBirthday().getTime()));
            pst.setString(5,customer.getAddress());
            pst.setString(6,customer.getEmail());
            pst.setString(7,customer.getTelephone());
            kq = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.closeConnect(c);
        }
        return kq;
    }

    public static Customer findCustomer(String cusId){
        Customer customer = new Customer();
        Connection c = JDBCUtil.openConnection();
        try {
            PreparedStatement pst = c.prepareStatement("SELECT * FROM Customers WHERE CusId = ?");
            pst.setString(1,cusId);
            ResultSet resultSet = pst.executeQuery();
            if(resultSet.next()){
                customer.setCusId(resultSet.getString(1));
                customer.setCusName(resultSet.getString(2));
                customer.setGender(resultSet.getBoolean(3));
                customer.setBirthday(resultSet.getDate(4));
                customer.setAddress(resultSet.getString(5));
                customer.setEmail(resultSet.getString(6));
                customer.setTelephone(resultSet.getString(7));
            }
        }catch (Exception exception){
            exception.printStackTrace();
        }finally {
            JDBCUtil.closeConnect(c);
        }
        return customer;
    }
    public static boolean deleteCustomer(String cusId){
        boolean ketQua = false;
        Connection c = JDBCUtil.openConnection();
        try {
            PreparedStatement pst = c.prepareStatement("DELETE FROM Customers WHERE CusId = ?");
            pst.setString(1,cusId);
            ketQua = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.closeConnect(c);
        }
        return ketQua;
    }
    public static boolean updateCustomer(Customer customer){
        boolean ketQua = false;
        Connection c = JDBCUtil.openConnection();
        try {
            PreparedStatement pst = c.prepareStatement("UPDATE Customers SET CusName=?,Gender=?,Birthday=?,Address=?,Email=?,Telephone=? WHERE CusId=?");
            pst.setString(1,customer.getCusName());
            pst.setBoolean(2,customer.isGender());
            pst.setDate(3,new Date(customer.getBirthday().getTime()));
            pst.setString(4,customer.getAddress());
            pst.setString(5,customer.getEmail());
            pst.setString(6,customer.getTelephone());
            pst.setString(7,customer.getCusId());
            ketQua = pst.executeUpdate() != 0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtil.closeConnect(c);
        }
        return ketQua;
    }
}
