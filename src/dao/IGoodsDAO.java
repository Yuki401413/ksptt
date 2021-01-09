package dao;
import java.util.List;

import vo.Goods;

public interface IGoodsDAO {
	public Goods findByld(String gname) throws Exception;//具体查找
	public List<Goods> findAll() throws Exception;//全部查找
	public List<Goods> fingAllSpilt(String column,String KryWord,Integer currentPage
			,Integer lineSize) throws Exception;//模糊查找
	public Integer getAllCount(String column,String keyWord) throws Exception;
}
