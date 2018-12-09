package com.oraclewdp.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.book.dao.SmallTypeDao;
import com.oraclewdp.book.util.DBUtil;
import com.oraclewdp.book.model.SmallType;


public class SmallTypeDaoJdbcImpl implements SmallTypeDao {

	@Override
	public boolean save(SmallType smallType) {

		  Connection conn=null;
		  PreparedStatement st=null;
		     
		  
		   try {
			conn=DBUtil. getConnection();
			
			 st=conn.prepareStatement("insert into t_small_type(name,bid) values(?,?)");
			 st.setString(1,smallType.getName());
			 st.setInt(2, smallType.getBid());
			 int l=st.executeUpdate();
			 if(l>0) {
				 return true;
			 }
			 
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(st, conn);
		}
		
		
		return false;
	}

	@Override
	public List<SmallType> findAllByBid(int bid) {
		
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		
		  try {
			con=DBUtil. getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select * from t_small_type where bid="+bid);
			List<SmallType> ls=new ArrayList<>();
			while(rs.next()) {
				SmallType smallType=new SmallType();
				smallType.setId(rs.getInt("id"));
				smallType.setName(rs.getString("name"));
				smallType.setBid(rs.getInt("bid"));
				ls.add(smallType);
			}
			return ls;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, st, con);
		}
		
		
		return null;
	}

	@Override
	public int findBidById(int sid) {
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;

		try {
			con=DBUtil. getConnection();
			st=con.createStatement();
			rs=st.executeQuery("select bid from t_small_type where id="+sid);

			if(rs.next()) {
				return  rs.getInt(1);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(rs, st, con);
		}
		return 0;
	}

}
