package com.shop.biz.UploadFile;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("fileService")
public class FileServiceImpl implements FileService {

	
	@Autowired
	private FileDAO fileDAO;
	
	@Override
	public int insertFile(FileVO file) {

		return fileDAO.insertFile(file);
	}

}
