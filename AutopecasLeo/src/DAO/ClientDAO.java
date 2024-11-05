/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Client;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class ClientDAO {
    PreparedStatement pst;
    String sql;
    
    public void Save(Client client) throws SQLException 
    {
        sql = "insert into client values(?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, client.getName());
        pst.setString(3, client.getAddress());
        pst.setString(4, client.getDistric());
        pst.execute();
        pst.close();
    }
    
    public Client SearchClientId(String id) throws SQLException 
    {
        sql = "select * from client where id = " + id;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Client cli = null;
        while (rs.next())
        {
            cli = new Client (rs.getInt("Id"), rs.getString("Name"), rs.getString("Address"), rs.getString("District"));
        }
        pst.close();
        return cli;
    }
    
    public void Delete(Client client) throws SQLException 
    {
        sql = "delete from client where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, client.getId());
        pst.execute();
        pst.close();
    }
    
    public void Edit(Client client) throws SQLException 
    {
        sql = "update client set name=?, address=?, district=? where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, client.getName());
        pst.setString(2, client.getAddress());
        pst.setString(3, client.getDistric());
        pst.setInt(4, client.getId());
        pst.execute();
        pst.close();
    }
}
