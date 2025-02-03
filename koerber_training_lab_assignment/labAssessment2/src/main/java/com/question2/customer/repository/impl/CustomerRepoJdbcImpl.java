package com.question2.customer.repository.impl;

import com.question2.customer.factory.ConnectionFactory;
import com.question2.customer.repository.Customer;
import com.question2.customer.repository.CustomerRepo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.question2.customer.factory.ConnectionFactory.connection;

public class CustomerRepoJdbcImpl implements CustomerRepo {
    private final Connection connection;
    public CustomerRepoJdbcImpl (){
        this.connection = ConnectionFactory.getConnection();
    }
    @Override
    public List<Customer> findAll() {
        List<Customer> customers=new ArrayList<>();
        try {

            Statement stmt=connection.createStatement();
            ResultSet rs=stmt.executeQuery("select * from cus");
            while (rs.next()){
                customers
                        .add(new Customer(
                                rs.getInt("id"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getLong("phoneNumber")));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("select * from cus where id=?");
            preparedStatement.setInt(1,id);

            ResultSet rs=preparedStatement.executeQuery();
            if (rs.next()){
                customer=new Customer(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getLong("phoneNumber"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public Customer save(Customer customer) {
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("insert into cus(name, address, phoneNumber) values(?,?,?)");

            preparedStatement.setString(1,customer.getName());
            preparedStatement.setString(2,customer.getAddress());
            preparedStatement.setLong(2,customer.getPhoneNumber());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customer;
    }

    @Override
    public void deleteById(int id) {
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("delete from cus where id=?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(int id, Customer customer) {
        try {
            PreparedStatement preparedStatement=connection
                    .prepareStatement("UPDATE cus SET name=?,address=?,phoneNumber=? WHERE id=?");
            preparedStatement.setString(1, customer.getName());         // Set name
            preparedStatement.setString(2, customer.getAddress());      // Set address
            preparedStatement.setLong(3, customer.getPhoneNumber());    // Set phoneNumber (use setLong for long type)
            preparedStatement.setInt(4, id);
            int noOfRecordEffected= preparedStatement.executeUpdate();

            System.out.println(noOfRecordEffected);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
