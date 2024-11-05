/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import Model.Seller;
import java.sql.ResultSet;

/**
 *
 * @author gabri
 */
public class SellerDAO {
    PreparedStatement pst;
    String sql;
    
    public void Save(Seller seller) throws SQLException 
    {
        sql = "insert into seller values(?,?,?,?)";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, 0);
        pst.setString(2, seller.getRole());
        pst.setString(3, seller.getCity());
        pst.setString(4, seller.getPhone());
        pst.execute();
        pst.close();
    }
    
    public Seller SearchSellerId(String id) throws SQLException 
    {
        sql = "select * from seller where id = " + id;
        pst = Conexao.getInstance().prepareStatement(sql);
        ResultSet rs = pst.executeQuery();
        Seller sell = null;
        while (rs.next())
        {
            sell = new Seller (rs.getInt("Id"), rs.getString("Role"), rs.getString("City"), rs.getString("Phone"));
        }
        pst.close();
        return sell;
    }
    
    public void Delete(Seller seller) throws SQLException 
    {
        sql = "delete from seller where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setInt(1, seller.getId());
        pst.execute();
        pst.close();
    }
    
    public void Edit(Seller seller) throws SQLException 
    {
        sql = "update seller set role=?, city=?, phone=? where id=?";
        pst = Conexao.getInstance().prepareStatement(sql);
        pst.setString(1, seller.getRole());
        pst.setString(2, seller.getCity());
        pst.setString(3, seller.getPhone());
        pst.setInt(4, seller.getId());
        pst.execute();
        pst.close();
    }
}
