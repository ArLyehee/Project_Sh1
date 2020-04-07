package com.shop.biz.Qna;

import java.util.List;

public interface QnaService {

	List<QnaVO> listQna(QnaVO vo);

	QnaVO getQna(int seq);

	void insertQna(QnaVO vo);

	void deleteQna(int qseq);
	
	List<QnaVO> getListQna();
	
	void updateQna(QnaVO vo);
}