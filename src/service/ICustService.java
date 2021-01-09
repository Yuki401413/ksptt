package service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import vo.Cust;

public interface ICustService {
	public boolean insert(Cust vo) throws Exception;//增
	
	public boolean dalete(String coding) throws Exception;//删
	
	public boolean update(Cust vo) throws Exception;//改
	
	public Cust get(String coding) throws Exception;//具体查询
	
	public List<Cust> list() throws Exception;//全部查询
	
	public Map<String,Object> listSplit(String column,String keyWord,int currentPage
			,int lineSize) throws Exception;//模糊查找
}
