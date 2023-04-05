package team.cl2y2x.practicesys.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import team.cl2y2x.practicesys.dao.CourseDao;
import team.cl2y2x.practicesys.vo.CourseVO;

public class CourseDaoImpl implements CourseDao {
	
	private Connection conn;
	
	public CourseDaoImpl(Connection conn) {
		this.conn = conn;
	}
	
	public Object select() throws Exception {
		String sql="select * from course";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        ResultSet rs=    stmt.executeQuery();// 执行SQL语句
        List<Object> objectList = new ArrayList<Object>();
    	if(rs.next()) {
    		CourseVO object = new CourseVO();
    		object.setCno(rs.getString("cno"));       
    		object.setCname(rs.getString("cname"));     
    		objectList.add(object);
    	}
		return objectList;
	}

	public boolean insert(Object object) throws Exception {
		String sql="insert into course(cno,cname) values (?,?)";
        PreparedStatement stmt= conn.prepareStatement(sql);// 得到PreparedStatement对象
        stmt.setObject(1, ((CourseVO) object).getCno());// 为预编译sql设置参数
        stmt.setObject(2, ((CourseVO) object).getCname());
        int num=    stmt.executeUpdate();// 执行SQL语句
        if(num > 0) {
        	return true;
        } else {
        	return false;
        }
	}
	
}
