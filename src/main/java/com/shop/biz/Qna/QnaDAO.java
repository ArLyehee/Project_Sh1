package com.shop.biz.Qna;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("QnaDAO")
public class QnaDAO extends SqlSessionDaoSupport{
	
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}
	public List<QnaVO> listQna(QnaVO vo){
		return getSqlSession().selectList("QnaDAO.listQna", vo);
	}
	
	public QnaVO getQna(int seq) {
		return getSqlSession().selectOne("QnaDAO.getQna", seq);
	}
	
	public void insertQna(QnaVO vo) {
		getSqlSession().insert("QnaDAO.insertQna", vo);
	}
	
	public void deleteQna(int qseq) {
		getSqlSession().delete("QnaDAO.deleteQna", qseq);
	}
	
	public List<QnaVO> getListQna(){
		
		return getSqlSession().selectList("QnaDAO.getListQna");
	}
	public void updateQna(QnaVO vo) {
		getSqlSession().update("QnaDAO.updateQna", vo);
	}
}
