package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.QdetailDao;
import team.cl2y2x.practicesys.vo.PaperVO;
import team.cl2y2x.practicesys.vo.QdetailVO;

public class QdetailDaoImpl implements QdetailDao {
	
	private Connection conn;
	
	public QdetailDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public List<QdetailVO> selectByPaper(PaperVO p) throws Exception {
		String sql="select * from qdetail where times=? and pno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, p.getTimes());// ΪԤ����sql���ò���
        stmt.setObject(2, p.getPno());
        ResultSet rs=    stmt.executeQuery();// ִ��SQL���
        List<QdetailVO> qdl = new ArrayList<QdetailVO>();
    	while(rs.next()) {
    		QdetailVO qd = new QdetailVO();
    		qd.setQno(rs.getString("qno"));       
    		qd.setPno(rs.getString("pno"));       
    		qd.setTimes(rs.getInt("times")); 
    		qd.setWrong(rs.getInt("wrong"));
    		qd.setCorrect(rs.getInt("correct")); 
    		qdl.add(qd);
    	}
		return qdl;
		
	}

	public boolean insert(QdetailVO qd) throws Exception {
		String sql="insert into qdetail(qno,pno,times,correct,wrong) values (?,?,?,?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, qd.getQno());// ΪԤ����sql���ò���
        stmt.setObject(2, qd.getPno());
        stmt.setObject(3, qd.getTimes());
        stmt.setObject(4, qd.getCorrect());
        stmt.setObject(5, qd.getWrong());
        int num=    stmt.executeUpdate();// ִ��SQL���
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public boolean update(QdetailVO qd) throws Exception {
		String sql="update qdetail set wrong=?,correct=? where qno=? and pno=? and times=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����        
        stmt.setObject(1, qd.getWrong());// ΪԤ����sql���ò���
        stmt.setObject(2, qd.getCorrect());
        stmt.setObject(3, qd.getQno());
        stmt.setObject(4, qd.getPno());
        stmt.setObject(5, qd.getTimes());
        int num=    stmt.executeUpdate();// ִ��SQL���
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public QdetailVO selectByQdetail(QdetailVO qd) throws Exception {
		String sql="select * from qdetail where times=? and pno=? and qno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// �õ�PreparedStatement����
        stmt.setObject(1, qd.getTimes());// ΪԤ����sql���ò���
        stmt.setObject(2, qd.getPno());
        stmt.setObject(3, qd.getQno());
        ResultSet rs=    stmt.executeQuery();// ִ��SQL���
        QdetailVO qdetail = null;
    	if(rs.next()) {
    		qdetail = new QdetailVO();
    		qdetail.setQno(rs.getString("qno"));       
    		qdetail.setPno(rs.getString("pno"));       
    		qdetail.setTimes(rs.getInt("times")); 
    		qdetail.setWrong(rs.getInt("wrong"));
    		qdetail.setCorrect(rs.getInt("correct")); 
    	}
		return qdetail;
	}

}
