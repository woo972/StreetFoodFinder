package com.wowls.sff.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.wowls.sff.service.ImageStorageServiceImpl;

@RestController
@RequestMapping("/image-storage")
public class ImageStorageController {
	
	private static final Logger logger = LoggerFactory.getLogger(ImageStorageServiceImpl.class);
	
	@Autowired
	private ImageStorageServiceImpl imageStorageService;
	@Autowired
	private ServletContext servletContext;
	
	
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
	
    @GetMapping("/stores/{storeId}/images")
    public ResponseEntity<Resource> showImage(@PathVariable("storeId") String storeId,
    									      @RequestParam(value="imageOrder") int imageOrder) {
    	Map<String,Object> imageMap = new HashMap<String,Object>();
    	imageMap.put("storeId", storeId);
    	imageMap.put("imageOrder", imageOrder);
    	Resource imageResource = imageStorageService.showImage(imageMap);
    	HttpHeaders header = new HttpHeaders();
        String contentType = null;
        try {
            contentType = servletContext.getMimeType(imageResource.getFile().getAbsolutePath());
        } catch (IOException e) {
            logger.info("Could not determine file type.");
        }
        // Fallback to the default content type if type could not be determined
        if(contentType == null) {
            contentType = "application/octet-stream";
        }
        header.setContentType(MediaType.parseMediaType(contentType));
    	header.add("Content-Disposition", "attachment; filename=\""+imageResource.getFilename()+"\"");
        
        return new ResponseEntity<Resource>(imageResource,header,HttpStatus.OK);
    }	
    
	@PutMapping("/stores/{storeId}/images/{imageName}")	
    public ResponseEntity<Void> modifyImage(@PathVariable("storeId") String storeId,
		    							  @PathVariable("imageName") String imageName,
		    							  @RequestBody MultipartFile[] image) {
		Map<String,Object> imageMap = new HashMap<String,Object>();
		imageMap.put("storeId", storeId);
		imageMap.put("imageName", imageName);
		imageMap.put("image", image);
		int rsltCode = imageStorageService.modifyImage(imageMap);
		if (rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }

	@DeleteMapping("/stores/{storeId}/images/{imageName}")	
    public ResponseEntity<Void> removeImage(@PathVariable("storeId") String storeId,
		    							  @PathVariable("imageName") String imageName) {
		Map<String,Object> imageMap = new HashMap<String,Object>();
		imageMap.put("storeId", storeId);
		imageMap.put("imageName", imageName);
		int rsltCode = imageStorageService.removeImage(imageMap);
		if (rsltCode > 0) {
			return new ResponseEntity<>(HttpStatus.OK);
		}else {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
    }
}
