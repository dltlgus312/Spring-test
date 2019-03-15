package com.Study_03.board.service;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.Study_03.board.dao.FileUploadDao;

@Service
public class FileUploadServiceImpl implements FileUploadService{
	
	@Autowired
	private FileUploadDao fileUploadDao;
	
//	private ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
//	private String contextPath = attr.getRequest().getContextPath(); 
	
	@Override
	public int insertFile(Map<String, Object> map, MultipartFile[] multipartFile) {
		int sortSn = 0;
		
		String relPath = "/resources";
		
		ServletContext context = (ServletContext)(map.get("context"));
		String strePath = context.getRealPath(relPath);
		
		File dir = new File(strePath);
		if (!dir.exists()) { 				
			dir.mkdirs();
		}

		for(MultipartFile f : multipartFile){

			String orgname = f.getOriginalFilename();
			String fileNm = orgname.substring(0, orgname.lastIndexOf("."));
			String exc = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());

			String streNm = "" + UUID.randomUUID();
			File strFile = new File(strePath + File.separator + streNm + "." + exc);
			
			try {
				
				map.put("sortOrdr", ++sortSn);
				map.put("streCours", relPath);
				map.put("streFileNm", streNm);
				map.put("orginlFileNm", fileNm);
				map.put("fileExtsn", exc);
				map.put("fileSize", f.getSize());
				
				f.transferTo(strFile);
				fileUploadDao.insertFile(map);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return 1;
	}

	@Override
	public int updateFile(Map<String, Object> map, MultipartFile[] multipartFile) {
		
		ServletContext context = (ServletContext)(map.get("context"));

		// 삭제
		map.put("tableSn", map.get("NOTICE_SN"));
		List<Map<String,Object>> fileList = fileUploadDao.selectListFile(map);
		
		for(Map<String, Object> i : fileList){
			String streFilePath = context.getRealPath((String)i.get("streCours")) + File.separator + (String)i.get("streFileNm") + "." + (String)i.get("fileExtsn");
			File file = new File(streFilePath);
			if(file.exists()){
				file.delete();
			}
		}

		
		String relPath = "/resources";
		String strePath = context.getRealPath(relPath);
		
		File dir = new File(strePath);
		if (!dir.exists()) { 				
			dir.mkdirs();
		}
		
		
		for(int i=0;i<multipartFile.length;i++){
			MultipartFile f = multipartFile[i];
			Map<String,Object> m = fileList.get(i);
			
			String orgname = f.getOriginalFilename();
			String fileNm = orgname.substring(0, orgname.lastIndexOf("."));
			String exc = orgname.substring(orgname.lastIndexOf(".") + 1, orgname.length());

			String streNm = "" + UUID.randomUUID();
			File strFile = new File(strePath + File.separator + streNm + "." + exc);
			
			try {
				map.put("atchFileSn", m.get("atchFileSn"));
				map.put("streCours", relPath);
				map.put("streFileNm", streNm);
				map.put("orginlFileNm", fileNm);
				map.put("fileExtsn", exc);
				map.put("fileSize", f.getSize());
				
				f.transferTo(strFile);
				return fileUploadDao.updateFile(map);
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		return 0;
	}

	@Override
	public Map<String, Object> selectFile(Map<String, Object> map) {
		return fileUploadDao.selectFile(map);
	}

	@Override
	public List<Map<String, Object>> selectListFile(Map<String, Object> map) {
		return fileUploadDao.selectListFile(map);
	}
	
	@Override
	public void deleteFile(int number, ServletContext context) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tableSn", number);
		map.put("tableNm", "BOARD");
		
		List<Map<String,Object>> fileList = fileUploadDao.selectListFile(map);
		
		for(Map<String, Object> i : fileList){
			String streFilePath = context.getRealPath((String)i.get("streCours")) + File.separator + (String)i.get("streFileNm") + "." + (String)i.get("fileExtsn");
			File file = new File(streFilePath);
			if(file.exists()){
				file.delete();
			}
		}
		fileUploadDao.deleteFile(map);
	}
	
}
