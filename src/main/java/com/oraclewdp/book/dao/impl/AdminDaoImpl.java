package com.oraclewdp.book.dao.impl;

import com.oraclewdp.book.dao.AdminDao;
import com.oraclewdp.book.model.Admin;
import com.oraclewdp.book.model.BigType;
import com.oraclewdp.book.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDaoImpl implements AdminDao {
    @Override
    public boolean findAdmin(Admin admin) {
        Connection conn=null;
        PreparedStatement stmt=null;
        ResultSet rs=null;

        try {
            conn= DBUtil.getConnection();
            String sql="select * form t_admin where name=? and pwd=?";
            stmt=conn.prepareStatement(sql);
            stmt.setString(1,admin.getName());
            stmt.setString(2,admin.getPwd());
            rs=stmt.executeQuery();

            if(rs.next()) {
             return true;
            }
       } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.free(rs, stmt, conn);
        }
        return false;
    }
}
