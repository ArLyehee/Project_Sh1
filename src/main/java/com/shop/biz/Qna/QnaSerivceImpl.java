package com.shop.biz.Qna;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("QnaService")
public class QnaSerivceImpl implements QnaService {

	@Autowired
	private QnaDAO qnaDAO;
	
	@Override
	public List<QnaVO> listQna(QnaVO vo) {
		
		return qnaDAO.listQna(vo);
	}

	@Override
	public QnaVO getQna(int seq) {
		
		return qnaDAO.getQna(seq);
	}

	@Override
	public void insertQna(QnaVO vo) {
		qnaDAO.insertQna(vo);

	}
	
	@Override
	public void deleteQna(int qseq) {
		qnaDAO.deleteQna(qseq);
	}
	
	@Override
	public List<QnaVO> getListQna(){
		
		return qnaDAO.getListQna();
	}

	@Override
	public void updateQna(QnaVO vo) {
		qnaDAO.updateQna(vo);
		
	}

}
