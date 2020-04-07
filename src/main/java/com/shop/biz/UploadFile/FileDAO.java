package com.shop.biz.UploadFile;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("fileDAO")
public class FileDAO extends SqlSessionDaoSupport{
	
	
	@Autowired
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	public int insertFile(FileVO file) {
		return getSqlSession().insert("fileDAO.insertFile", file);
	}
}

