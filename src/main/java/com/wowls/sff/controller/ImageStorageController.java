package com.wowls.sff.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wowls.sff.service.ImageStorageServiceImpl;

@RestController
@RequestMapping("/image-storage")
public class ImageStorageController {
	
	@Autowired
	private ImageStorageServiceImpl imageStorageService;
	
	@PostMapping("/stores/{storeId}")	
    public ResponseEntity<Void> saveImageList(@PathVariable("storeId") String storeId,
    										 @RequestBody MultipartFile[] imageArr) {
		Map<String,Object> imageMap = new HashMap<String,Object>();
		imageMap.put("storeId", storeId);
		imageMap.put("imageArr", imageArr);
		int rsltCode = imageStorageService.saveImageList(imageMap);
		if (rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }
	
    @GetMapping("/stores/{storeId}")
    public ResponseEntity<List<String>> showImageList(@PathVariable("storeId") String storeId) {
    	Map<String,String> imageMap = new HashMap<String,String>();
    	imageMap.put("storeId", storeId);
        return new ResponseEntity<List<String>>(imageStorageService.showImageList(imageMap),HttpStatus.OK);
    }	
}
