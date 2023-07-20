package dao;

import java.util.List;

import vo.PhonebookVO;

public interface PhonebookDAO {

	public int insert(PhonebookVO pb);
	public List<PhonebookVO> findAll();
	public List<PhonebookVO> searchFind(String search);
	public PhonebookVO findOneById(int idx);
	public int update(int idx, PhonebookVO pb);
	public int delete(int idx);
}
