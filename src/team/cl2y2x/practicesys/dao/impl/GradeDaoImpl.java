package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.GradeDao;
import team.cl2y2x.practicesys.vo.GradeVO;
import team.cl2y2x.practicesys.vo.PaperVO;

public class GradeDaoImpl implements GradeDao {
	
	private Connection conn;
	
	public GradeDaoImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean insert(GradeVO g) throws Exception {
		String sql="insert into grade(grade,pno,sno,times) values (?,?,?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, g.getGrade());// 为预编译sql设置参数
        stmt.setObject(2, g.getPno());
        stmt.setObject(3, g.getSno());
        stmt.setObject(4, g.getTimes());
        int num=    stmt.executeUpdate();// 执行SQL语句
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public boolean update(GradeVO g) throws Exception {
		String sql="update grade set grade=? where sno=? and pno=? and times=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象       
        stmt.setObject(1, g.getGrade());
        stmt.setObject(2, g.getSno());// 为预编译sql设置参数
        stmt.setObject(3, g.getPno());
        stmt.setObject(4, g.getTimes());
        int num=    stmt.executeUpdate();// 执行SQL语句
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}

	public GradeVO selectBySpt(GradeVO g) throws Exception {
		String sql="select * from grade where sno=? and pno=? and times=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, g.getSno());// 为预编译sql设置参数
        stmt.setObject(2, g.getPno());
        stmt.setObject(3, g.getTimes());
        ResultSet rs =    stmt.executeQuery();// 执行SQL语句
        GradeVO grade = null;
        if(rs.next()) {
        	grade = new GradeVO();
        	grade.setSno(rs.getString("sno"));       
        	grade.setPno(rs.getString("pno"));       
        	grade.setTimes(rs.getInt("times")); 
        	grade.setGrade(rs.getInt("grade"));
    	}
        return grade;
	}

	public List<GradeVO> selectByPno(PaperVO p) throws Exception {
		String sql="select * from grade,paper where grade.pno=paper.pno and grade.times=paper.times and grade.pno=? and grade.times=?";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象       
        stmt.setObject(1, p.getPno());// 为预编译sql设置参数
        stmt.setObject(2, p.getTimes());
        ResultSet rs =    stmt.executeQuery();// 执行SQL语句
        List<GradeVO> g = new ArrayList<GradeVO>();
        while(rs.next()) {
        	GradeVO grade = new GradeVO();
        	grade.setSno(rs.getString("sno"));       
        	grade.setPno(rs.getString("pno"));       
        	grade.setTimes(rs.getInt("times")); 
        	grade.setGrade(rs.getInt("grade"));
        	g.add(grade);
    	}
        return g;
	}

}
