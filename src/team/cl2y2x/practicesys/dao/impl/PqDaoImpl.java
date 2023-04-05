package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import team.cl2y2x.practicesys.dao.PqDao;
import team.cl2y2x.practicesys.vo.PqVO;

public class PqDaoImpl implements PqDao {
	
	private Connection conn;
	
	public PqDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean insert(PqVO pq) throws Exception {
		String sql="insert into pq(pno,qno) values (?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, pq.getPno());// 为预编译sql设置参数
        stmt.setObject(2, pq.getQno());
        int num=    stmt.executeUpdate();// 执行SQL语句
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

}
