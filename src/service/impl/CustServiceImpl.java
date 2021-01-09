package service.impl;

import java.util.List;
import java.util.Map;

import dbc.Connect3;
import service.ICustService;
import factory.DAOFactory;
import vo.Cust;



public class CustServiceImpl implements ICustService {
	private Connect3 dbc=new Connect3();
	public boolean insert(Cust vo) throws Exception {
		try {
			if(DAOFactory.getICustDAOInstance(this.dbc.getConnection()).findByld(vo.getCoding())==null) {
				return DAOFactory.getICustDAOInstance(this.dbc.getConnection()).doCreate(vo);
			}
			return false;
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
		
	}

	@Override
	public boolean dalete(String coding) throws Exception {
		try {
			if(coding.length()==0) {
				return false;
			}
			return DAOFactory.getICustDAOInstance(this.dbc.getConnection()).doRemove(coding);
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public boolean update(Cust vo) throws Exception {
		try {
			return DAOFactory.getICustDAOInstance(this.dbc.getConnection()).doUpdate(vo);
		} catch (Exception e) {
			throw e;
		}finally {
			this.dbc.close();
		}
	}

	@Override
	public Cust get(String id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Cust> list() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> listSplit(String column, String keyWord, int currentPage, int lineSize)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
