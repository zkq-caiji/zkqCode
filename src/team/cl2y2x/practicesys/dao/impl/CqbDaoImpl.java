package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.CqbDao;
import team.cl2y2x.practicesys.vo.CqbVO;

public class CqbDaoImpl implements CqbDao {
	
	private Connection conn;
	
	public CqbDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public Object select() throws Exception {
		String sql="select * from cqb";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        ResultSet rs=    stmt.executeQuery();// ִ��SQL���
        List<Object> objectList = new ArrayList<Object>();
    	if(rs.next()) {
    		CqbVO object = new CqbVO();
    		object.setCno(rs.getString("cno"));       
    		object.setQbno(rs.getString("qbno"));      
    		objectList.add(object);
    	}
		return objectList;
	}

	public boolean insert(Object object) throws Exception {
		String sql="insert into qbc(qbno,cno) values (?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, ((CqbVO) object).getQbno());// ΪԤ����sql���ò���
        stmt.setObject(2, ((CqbVO) object).getCno());
        int num=    stmt.executeUpdate();// ִ��SQL���
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

}
