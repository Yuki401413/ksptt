package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import dao.ICustDAO;
import vo.Cust;

public class CustDAOImpl implements ICustDAO {
	private Connection conn;//数据库连接对象
	private PreparedStatement pstmt;//操作对象
	private PreparedStatement pstmt2;
	public CustDAOImpl(Connection conn) {//构造方法
		this.conn=conn;
	}
	
	@Override
	public boolean doCreate(Cust vo) throws Exception {//增
		String sql="insert into cust(coding,name,age,time,money,rnumber) values(?,?,?,?,?,?)";//使用占位符定义插入语句
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, vo.getCoding());
		this.pstmt.setString(2, vo.getName());
		this.pstmt.setInt(3, vo.getAge());
		this.pstmt.setString(4, vo.getTime());
		this.pstmt.setInt(5, vo.getMoney());
		this.pstmt.setInt(6, vo.getRnumber());
		
		return this.pstmt.executeUpdate()>0;//==1代表更新记录成功
	}

	public boolean doRemove(String coding) throws Exception {//删
		String sql="delete from cust where coding=?";
		String sql2="insert into history(coding,name,age,time,money,rnumber) values(?,?,?,?,?,?)";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt2=this.conn.prepareStatement(sql2);
		pstmt.setString(1, coding);//传参，将参数给予数据库，让数据库知道
		return this.pstmt.executeUpdate()>0;
	}

	public boolean doUpdate(Cust vo) throws Exception {//改
		String sql="update cust set name=?,age=?,time=?,money=?,rnumber=? where coding=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(6, vo.getCoding());
		this.pstmt.setString(1, vo.getName());
		this.pstmt.setInt(2, vo.getAge());
		this.pstmt.setString(3, vo.getTime());
		this.pstmt.setInt(4, vo.getMoney());
		this.pstmt.setInt(5, vo.getRnumber());
		
		return this.pstmt.executeUpdate()>0;//==1代表更新记录成功	
		
	}

	public Cust findByld(String id) throws Exception {//根据主键查找
		Cust vo=null;
		String sql="select coding,name,age,time,money from cust where coding=?";
		this.pstmt=this.conn.prepareStatement(sql);
		this.pstmt.setString(1, id);
		ResultSet rs=this.pstmt.executeQuery();//结果集储存查询结果
		if(rs.next()) {
			vo=new Cust();
			vo.setCoding(rs.getString(1));
			vo.setName(rs.getString(2));
			vo.setAge(rs.getInt(3));
			vo.setTime(rs.getString(4));
			vo.setMoney(rs.getInt(5));
			vo.setRnumber(rs.getInt(6));
		}
		return vo;
	}

	@Override
	public List<Cust> findAll() throws Exception {//查询表中全部数据
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cust> findAllSplit(String column, String keyWord, Integer currentPage, Integer lineSize)
			throws Exception {//模糊查找
		
		return null;
	}

//	@Override
//	public boolean doRemove(String id) throws Exception {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
