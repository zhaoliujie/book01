package com.oraclewdp.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.book.dao.BigTypeDao;
import com.oraclewdp.book.util.DBUtil;
import com.oraclewdp.book.model.BigType;

public class BigTypeDaoImpl implements BigTypeDao {

	@Override
	public boolean save(String name) {
		Connection conn=null;
		PreparedStatement stmt=null;
		
		  try {
			conn=DBUtil.getConnection();
			String sql="insert into t_big_type values(default,?)";
			stmt=conn.prepareStatement(sql);
			stmt.setString(1, name);
		int len=stmt.executeUpdate();
			if(len>0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, conn);
		}
		return false;
	}

	@Override
	public List<BigType> findAll() {
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		    try {
				conn=DBUtil.getConnection();
				stmt=conn.createStatement();
				
				rs=stmt.executeQuery("select * from t_big_type");
				List<BigType> ls=new ArrayList<>();
				while(rs.next()) {
				BigType bigType=new BigType();
				   bigType.setId(rs.getInt("id"));
				   bigType.setName(rs.getString("name"));
				   ls.add(bigType);
				}
				return ls;
				
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				DBUtil.free(rs, stmt, conn);
			}
		
		
		return null;
	}

}
