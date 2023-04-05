package team.cl2y2x.practicesys.dao;

import java.util.List;

import team.cl2y2x.practicesys.vo.GradeVO;
import team.cl2y2x.practicesys.vo.PaperVO;

public interface GradeDao {
    /**
     * ����ѧ���Ծ������Ϣ
     * @param g GradeVO ����
     * @return 
     * @throws Exception 
     */
	boolean insert(GradeVO g) throws Exception;

	boolean update(GradeVO g) throws Exception;

	GradeVO selectBySpt(GradeVO g) throws Exception;
	
	List<GradeVO> selectByPno(PaperVO p) throws Exception;
	
}
