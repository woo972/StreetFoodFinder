package com.wowls.sff.service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.wowls.sff.ImageStorageConfig;
import com.wowls.sff.mapper.ImageStorageMapper;

@Service
public class ImageStorageServiceImpl {

	@Autowired
	private ImageStorageMapper imageStorageMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(ImageStorageServiceImpl.class);
    private final Path imageStorageLocation;

    @Autowired
    public ImageStorageServiceImpl(ImageStorageConfig imageStorageConfig) {
        this.imageStorageLocation = Paths.get(imageStorageConfig.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.imageStorageLocation);
        } catch (Exception e) {
        	logger.error("Could not create the directory where the uploaded images will be stored.");
        }
    }
    
    public int saveImageList(Map<String, Object> imageMap) { 
    	String storeId = (String) imageMap.get("storeId");
    	MultipartFile[] imageArr = (MultipartFile[]) imageMap.get("imageArr");
    	imageMap.remove("imageArr");   
    	Pattern extensionPattern = Pattern.compile("(.+)\\.(jpg|jpeg|png|gif|bmp|heif)");
    	for(int order=0; order<imageArr.length; order++) {
            // Normalize image name
            String imageName = StringUtils.cleanPath(imageArr[order].getOriginalFilename());
            // check image extenstion
            Matcher extensionPatternMatcher = extensionPattern.matcher(imageName.toLowerCase());
            String extension;
            if(extensionPatternMatcher.matches()) {
            	extension = extensionPatternMatcher.group(2);            	
            	imageName = storeId + "_" + (order+1) + "."+ extension; 
            	try {
            		// Copy image to the target location (Replacing existing image with the same name)
            		Path targetLocation = this.imageStorageLocation.resolve(imageName);
            		Files.copy(imageArr[order].getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            		
            		imageMap.put("imageName", imageName);
            		imageMap.put("imageOrder", order+1);
            		imageStorageMapper.saveImage(imageMap);
            	} catch (IOException ex) {
            		logger.error("Could not store image " + imageName + ". Please try again!");
            		return 0;
            	}	 
            }else {
            	return 0;
            }
    	}
    	return imageArr.length;
    }

    public Resource showImage(Map<String,Object> imageMap) {
    	String imageName = imageStorageMapper.showImageNameByImageOrder(imageMap);
    	Path normalizedImageName = this.imageStorageLocation.resolve(imageName).normalize(); 
    	Resource imageResource;
		try {
			imageResource = new UrlResource(normalizedImageName.toUri());
		} catch (MalformedURLException e) {
			return null;
		}
    	return imageResource;
    }
    
    public int modifyImage(Map<String,Object> imageMap) {
    	String storeId = (String)imageMap.get("storeId");
    	String imageName = (String)imageMap.get("imageName");
    	if(imageName.equals(imageStorageMapper.showImageNameByImageName(imageMap))){
    		MultipartFile image = (MultipartFile)imageMap.get("imageArr");
    		try {
    			Path targetLocation = this.imageStorageLocation.resolve(imageName);
    			Files.copy(image.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
    		} catch (IOException ex) {
    			logger.error("Could not store image " + imageName + ". Please try again!");
    			return 0;
    		}	 
    	}else{
        	return 0;
        }
    	return 1;
    }    
    public int removeImage(Map<String,Object> imageMap) {
    	String imageName = (String)imageMap.get("imageName");
    	if(imageName.equals(imageStorageMapper.showImageNameByImageName(imageMap))){
    		if(imageStorageMapper.removeImage(imageMap) > 0) {
    			try {
    				Path targetLocation = this.imageStorageLocation.resolve(imageName);
    				Files.delete(targetLocation);
    			} catch (IOException ex) {
    				logger.error("Could not store image " + imageName + ". Please try again!");
    				return 0;
    			}	 
    		}else {
    			return 0;
    		}
    	}else{
    		return 0;
    	}
    	return 1;
    }    
}
