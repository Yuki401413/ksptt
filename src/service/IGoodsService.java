package service;

import java.util.List;
import java.util.Map;

import vo.Goods;

public interface IGoodsService {
	public Goods get(String gname) throws Exception;
	public List<Goods> list() throws Exception;
	public Map<String,Object> listSplit(String column,String keyWord,
			int currentPage,int lineSize) throws Exception;
	
}
