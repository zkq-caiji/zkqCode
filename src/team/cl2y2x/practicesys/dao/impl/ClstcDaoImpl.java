package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.ClstcDao;
import team.cl2y2x.practicesys.vo.ClstcVO;

public class ClstcDaoImpl implements ClstcDao {
	
	private Connection conn;
	
	public ClstcDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public List<ClstcVO> selectBySno(String sno) throws Exception {
		String sql="select * from clstc where sno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, sno);
        ResultSet rs=    stmt.executeQuery();// 执行SQL语句
        List<ClstcVO> sl = new ArrayList<ClstcVO>();
    	while(rs.next()) {
    		ClstcVO student = new ClstcVO();
    		student.setCno(rs.getString("cno"));
    		student.setTno(rs.getString("tno"));
    		student.setClno(rs.getString("clno"));
    		student.setSno(rs.getString("sno"));
    		sl.add(student);
    	}
		return sl;
	}

	public ClstcVO selectByTno(String tno) throws Exception {
		String sql="select * from clstc where tno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, tno); 
        ResultSet rs=    stmt.executeQuery();// 执行SQL语句
        ClstcVO teacher = new ClstcVO();
        while(rs.next()) {
			teacher.setCno(rs.getString("cno"));
			teacher.setTno(rs.getString("tno"));
			teacher.setClno(rs.getString("clno"));
			teacher.setSno(rs.getString("sno"));
        }
		return teacher;
	}
	
}
