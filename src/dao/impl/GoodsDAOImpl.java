package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import dao.IGoodsDAO;
import vo.Goods;

public class GoodsDAOImpl implements IGoodsDAO{
	private Connection conn;
	private PreparedStatement pstmt;
	
	public GoodsDAOImpl(Connection conn) {
		this.conn=conn;
	}
	public Goods findByld(String gname) throws Exception {//具体查找
		Goods vo=new Goods();
		String sql="select gname,kind,details from goods where gname=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, gname);
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			vo=new Goods();
			vo.setGname(rs.getString(1));
			vo.setKind(rs.getString(2));
			vo.setDetails(rs.getString(3));
			
		}
		return vo;
	}

	public List<Goods> findAll() throws Exception {
		List<Goods> all=new ArrayList<Goods>();
		String sql="select gname,kind,details from goods";
		this.pstmt=this.conn.prepareStatement(sql);
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()){
			Goods vo=new Goods();
			vo.setGname(rs.getString(1));
			vo.setKind(rs.getString(2));
			vo.setDetails(rs.getString(3));
			all.add(vo);
			System.out.println("yyyyyyyyyyyyy");
		}	
		
		return all;
	}
	
	public List<Goods> fingAllSpilt(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {
		List<Goods> all=new ArrayList<Goods>();
		System.out.println("执行成功！");
		String sql="select* from"+"(select gname,kind,datiles,rownum rn "+"from goods where "
		+column+"like ? and rownum<=?) temp "+"where temp.rn>?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, "%"+keyWord+"%");
		this.pstmt.setInt(2, currentPage*lineSize);
		this.pstmt.setInt(3, (currentPage-1)*lineSize);
		
		ResultSet rs=this.pstmt.executeQuery();
		while(rs.next()) {
			Goods vo=new Goods();
			vo.setGname(rs.getString(1));
			vo.setKind(rs.getString(2));
			vo.setDetails(rs.getString(3));
			all.add(vo);
		}
		
 		return all;
	}

	public Integer getAllCount(String column, String keyWord) throws Exception {
		
		String sql="select count(*) from goods where"+column+"like ?";
		this.pstmt=this.conn.prepareStatement(sql);
		
		this.pstmt.setString(1, "%"+keyWord+"%");
		//System.out.println("执行成功！");
		ResultSet rs=this.pstmt.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return null;
	}
	
	
}
