package com.oraclewdp.book.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.oraclewdp.book.dao.BookDao;
import com.oraclewdp.book.util.DBUtil;
import com.oraclewdp.book.util.PageConstant;
import com.oraclewdp.book.model.Book;


public class BookDaoImpl implements BookDao {


	@Override
	public boolean save(Book book) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
//			String sql="insert into t_book values(?,?,?,?,?,?,?,?)";
			stmt = con.prepareStatement("insert into t_book(name,price,author,cbs,cbDate,descri,sid,photo) values(?,?,?,?,?,?,?,?)");
			stmt.setString(1, book.getName());
			stmt.setDouble(2, book.getPrice());
			stmt.setString(3, book.getAuthor());
			stmt.setString(4, book.getCbs());
			stmt.setDate(5, new java.sql.Date((book.getCbDate().getTime())));
			stmt.setString(6, book.getDescri());
			stmt.setInt(7, book.getSid());
			stmt.setString(8, book.getPhoto());
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(stmt, con);
		}

		return false;
	}

	@Override
	public List<Book> findAll(int currentPage, String name, int sid) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
					/*	String sql="select * from t_book order by id desc limit " ;
					//4zhiong 
					if((name==null||name.equals(""))&&sid==-1) {
					//不限定
						
					}
					//限定name
					if((name!=null&&!name.equals(""))&&sid==-1) {
						sql+="where name like '%"+name+"%' ";
					}
					
					//限定sid
					if((name==null||name.equals(""))&&sid!=-1) {
						sql+=" where sid="+sid;
					}
					//都限定
					if((name!=null&&!name.equals(""))&&(sid!=-1)) {
						sql+="where name like '%"+name+"%' and sid="+sid;
					}*/
			String sql = "select * from t_book  where 1=1";
			//限定name
			if ((name != null && !name.equals(""))) {
				sql += " and name like '%" + name + "%' ";
			}
			if (sid != -1) {
				sql += " and sid=" + sid;
			}
			sql += " order by id desc limit " + ((currentPage - 1) * PageConstant.PAGE_SIZE + 1 - 1) + "," + PageConstant.PAGE_SIZE;//偏移量
			rs = st.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			while (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setCbs(rs.getString("cbs"));
				book.setCbDate(rs.getDate("cbDate"));
				book.setDescri(rs.getString("descri"));
				book.setSid(rs.getInt("sid"));
				book.setPhoto(rs.getString("photo"));
				ls.add(book);
			}
			System.out.println(ls);
			return ls;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, st, conn);
		}
		return null;
	}


	@Override
	public int total(String name, int sid) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String sql = "select  count(*) from t_book where 1=1";
			//限定name
			if ((name != null && !name.equals(""))) {
				sql += " and name like '%" + name + "%' ";
			}
			if (sid != -1) {
				sql += " and sid=" + sid;
			}
			rs = st.executeQuery(sql);
			if (rs.next()) {
				return rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, st, conn);
		}
		return 0;
	}

	@Override
	public int del(int id) {
		Connection con=null;
		PreparedStatement stmt=null;

		try {
			con=DBUtil.getConnection();

			stmt=con.prepareStatement("delete from t_book where id= "+id);

			int r=stmt.executeUpdate();
			return r;

		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.free(stmt, con);
		}
		return 0;
	}
	@Override
	public Book find(int id) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.getConnection();
			st = conn.createStatement();
			String sql="select * from t_book where id="+id;

			rs = st.executeQuery(sql);
			List<Book> ls = new ArrayList<>();
			if (rs.next()) {
				Book book = new Book();
				book.setId(rs.getInt("id"));
				book.setName(rs.getString("name"));
				book.setPrice(rs.getDouble("price"));
				book.setAuthor(rs.getString("author"));
				book.setCbs(rs.getString("cbs"));
				book.setCbDate(rs.getDate("cbDate"));
				book.setDescri(rs.getString("descri"));
				book.setSid(rs.getInt("sid"));
				book.setPhoto(rs.getString("photo"));
				return book;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(rs, st, conn);
		}
		return null;
	}

	@Override
	public boolean update(Book book) {
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = DBUtil.getConnection();
			if(book.getPhoto()==null){
				stmt = con.prepareStatement("update  t_book set (name,price,author,cbs,cbDate,descri,sid) values(?,?,?,?,?,?,?,?) where id=?");
				stmt.setString(1, book.getName());
				stmt.setDouble(2, book.getPrice());
				stmt.setString(3, book.getAuthor());
				stmt.setString(4, book.getCbs());
				stmt.setDate(5, new java.sql.Date((book.getCbDate().getTime())));
				stmt.setString(6, book.getDescri());
				stmt.setInt(7, book.getSid());
				stmt.setInt(8, book.getId());
			}else{
				stmt = con.prepareStatement("insert into t_book(name,price,author,cbs,cbDate,descri,sid,photo) values(?,?,?,?,?,?,?,?) where id=?");
				stmt.setString(1, book.getName());
				stmt.setDouble(2, book.getPrice());
				stmt.setString(3, book.getAuthor());
				stmt.setString(4, book.getCbs());
				stmt.setDate(5, new java.sql.Date((book.getCbDate().getTime())));
				stmt.setString(6, book.getDescri());
				stmt.setInt(7, book.getSid());
				stmt.setString(8, book.getPhoto());
				stmt.setInt(9, book.getId());
			}
			int r = stmt.executeUpdate();
			if (r > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.free(stmt, con);
		}

		return false;
	}

}
