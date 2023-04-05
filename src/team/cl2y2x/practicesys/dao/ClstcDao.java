package team.cl2y2x.practicesys.dao;

import java.util.List;

import team.cl2y2x.practicesys.vo.ClstcVO;

public interface ClstcDao {
    /**
     * 查询学生课程班级信息
     * @param sno String 学生学号
     * @return List<ClstcVO> 课程班级列表
     */
	List<ClstcVO> selectBySno(String sno) throws Exception;
	/**
     * 查询老师课程班级信息
     * @param tno String 老师工号
     * @return ClstcVO 课程班级
     */
	ClstcVO selectByTno(String tno) throws Exception;
}
