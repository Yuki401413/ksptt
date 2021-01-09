package service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dbc.Connect3;
import factory.DAOFactory;
import factory.GoodsDAOFactory;
import service.IGoodsService;
import vo.Goods;

public class GoodsServiceImpl implements IGoodsService {
	
	private Connect3 dbc=new Connect3();

	public Goods get(String gname) throws Exception {
		try {
			return GoodsDAOFactory.getGoodsDAOInstance(this.dbc.getConnection()).findByld(gname);
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	public List<Goods> list() throws Exception {
		try {
			return GoodsDAOFactory.getGoodsDAOInstance(this.dbc.getConnection()).findAll();
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
		try {
			Map<String,Object> map=new HashMap<String, Object>();
			map.put("allGoods", DAOFactory.getICustDAOInstance(this.dbc.getConnection()).findAllSplit(column, keyWord, currentPage, lineSize));
			map.put("goodsCount", GoodsDAOFactory.getGoodsDAOInstance(this.dbc.getConnection()).getAllCount(column, keyWord));
			return map;
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

}
