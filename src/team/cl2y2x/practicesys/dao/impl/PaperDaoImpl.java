package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.PaperDao;
import team.cl2y2x.practicesys.vo.PaperVO;

public class PaperDaoImpl implements PaperDao {
	
	private Connection conn;
	
	public PaperDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public List<PaperVO> selectByCno(String cno) throws Exception {
		String sql="select * from paper where cno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, cno);// ΪԤ����sql���ò���
        ResultSet rs=    stmt.executeQuery();// ִ��SQL���
        List<PaperVO> pl = new ArrayList<PaperVO>();
    	while(rs.next()) {
    		PaperVO p = new PaperVO();
    		p.setPno(rs.getString("pno"));
    		p.setTimes(rs.getInt("times"));
    		p.setCno(rs.getString("cno"));
    		p.setFlag(rs.getString("flag"));
    		pl.add(p);
    	}
		return pl;
	}

	public List<PaperVO> selectByCnoF(String cno) throws Exception {
		String sql="select * from paper where flag='NOK' and cno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, cno);// ΪԤ����sql���ò���
        ResultSet rs=    stmt.executeQuery();// ִ��SQL���
        List<PaperVO> pl = new ArrayList<PaperVO>();
    	while(rs.next()) {
    		PaperVO p = new PaperVO();
    		p.setPno(rs.getString("pno"));
    		p.setTimes(rs.getInt("times"));       
    		p.setFlag(rs.getString("flag")); 
    	    p.setCno(rs.getString("cno"));
    		pl.add(p);
    	}
		return pl;
	}

	public boolean insert(PaperVO p) throws Exception {
		String sql="insert into paper(pno,times,flag,cno) values (?,?,?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, p.getPno());// ΪԤ����sql���ò���
        stmt.setObject(2, p.getTimes());
        stmt.setObject(3, p.getFlag());
        stmt.setObject(4, p.getCno());
        int num=    stmt.executeUpdate();// ִ��SQL���
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public boolean delete(PaperVO p) throws Exception {
		String sql="delete from paper where pno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, p.getPno());// ΪԤ����sql���ò���
        int num=    stmt.executeUpdate();// ִ��SQL���
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

}
