package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.MistakeDao;
import team.cl2y2x.practicesys.vo.MistakeVO;
import team.cl2y2x.practicesys.vo.QqbVO;
import team.cl2y2x.practicesys.vo.StudentVO;

public class MistakeDaoImpl implements MistakeDao {
	
	private Connection conn;
	
	public MistakeDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public List<QqbVO> selectAll(StudentVO stu) throws Exception {
		String sql="select stem from mistake,qqb where mistake.qno=qqb.qno and sno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, stu.getSno());
        ResultSet rs=    stmt.executeQuery();// 执行SQL语句
        List<QqbVO> mistakeList = new ArrayList<QqbVO>();
    	while(rs.next()) {
    		QqbVO mistake = new QqbVO();
    		mistake.setStem(rs.getString("stem"));   
    		mistakeList.add(mistake);
    	}
		return mistakeList;
	}

	public MistakeVO selectByMistake(MistakeVO m) throws Exception {
		String sql="select * from mistake where sno=? and qno=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, m.getSno());
        stmt.setObject(2, m.getQno());
        ResultSet rs=    stmt.executeQuery();// 执行SQL语句
    	MistakeVO mistake = null;
		if(rs.next()) {
			mistake = new MistakeVO();
    		mistake.setSno(rs.getString("sno"));
    		mistake.setQno(rs.getString("qno"));
    	}
		return mistake;
	}

	public boolean insert(MistakeVO m) throws Exception {
		String sql="insert into mistake values(?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, m.getSno());
        stmt.setObject(2, m.getQno());
        int num =    stmt.executeUpdate();// 执行SQL语句
		if(num > 0) {
    		return true;
    	} else return false;
	}

}
