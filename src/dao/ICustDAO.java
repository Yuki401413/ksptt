package dao;
import java.util.List;

import vo.Cust; 
//针对Cust表的标准
public interface ICustDAO {
	public boolean doCreate(Cust vo) throws Exception;//增
	
	public boolean doRemove(String coding) throws Exception;//删
	
	public boolean doUpdate(Cust vo) throws Exception;//改
	
	public Cust findByld(String coding) throws Exception;//根据编号查行信息
	
	public List<Cust> findAll() throws Exception;//查询数据表中全部数据
	
	public List<Cust> findAllSplit(String column,String keyWord,Integer currentPage
			,Integer lineSize) throws Exception;//模糊查找
}
