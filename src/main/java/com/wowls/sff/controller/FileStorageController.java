package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wowls.sff.service.FileStorageServiceImpl;

@RestController
@RequestMapping("/file-storage")
public class FileStorageController {
	
	@Autowired
	private FileStorageServiceImpl fileStorageService;
	
	@PostMapping("/stores/{storeId}")	
    public ResponseEntity<Void> saveFileList(@PathVariable("storeId") String storeId,
    										 @RequestBody MultipartFile[] fileArr) {
		Map<String,Object> fileMap = new HashMap<String,Object>();
		fileMap.put("storeId", storeId);
		fileMap.put("fileArr", fileArr);
		int rsltCode = fileStorageService.saveFileList(fileMap);
		if (rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }
}
