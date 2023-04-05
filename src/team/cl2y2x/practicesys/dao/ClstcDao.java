package team.cl2y2x.practicesys.dao;

import java.util.List;

import team.cl2y2x.practicesys.vo.ClstcVO;

public interface ClstcDao {
    /**
     * ��ѯѧ���γ̰༶��Ϣ
     * @param sno String ѧ��ѧ��
     * @return List<ClstcVO> �γ̰༶�б�
     */
	List<ClstcVO> selectBySno(String sno) throws Exception;
	/**
     * ��ѯ��ʦ�γ̰༶��Ϣ
     * @param tno String ��ʦ����
     * @return ClstcVO �γ̰༶
     */
	ClstcVO selectByTno(String tno) throws Exception;
}
