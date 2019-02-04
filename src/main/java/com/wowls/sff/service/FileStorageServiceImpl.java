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

import com.wowls.sff.FileStorageConfig;
import com.wowls.sff.mapper.FileStorageMapper;

@Service
public class FileStorageServiceImpl {

	@Autowired
	private FileStorageMapper fileStorageMapper;
	
	private static final Logger logger = LoggerFactory.getLogger(FileStorageServiceImpl.class);
    private final Path fileStorageLocation;

    @Autowired
    public FileStorageServiceImpl(FileStorageConfig fileStorageConfig) {
        this.fileStorageLocation = Paths.get(fileStorageConfig.getUploadDir()).toAbsolutePath().normalize();
        try {
            Files.createDirectories(this.fileStorageLocation);
        } catch (Exception e) {
        	logger.error("Could not create the directory where the uploaded files will be stored.");
        }
    }
    
    public int saveFileList(Map<String, Object> fileMap) {
    	String storeId = (String) fileMap.get("storeId");
    	MultipartFile[] fileArr = (MultipartFile[]) fileMap.get("fileArr");
    	fileMap.remove("fileArr");
    	for(int order=0; order<fileArr.length; order++) {
    		// Normalize file name
            String fileName = StringUtils.cleanPath(fileArr[order].getOriginalFilename());
            
            // check file extenstion
            Pattern extensionPattern = Pattern.compile("(.+)\\.(jpg|jpeg|png|gif|bmp|heif)");
            Matcher extensionPatternMatcher = extensionPattern.matcher(fileName.toLowerCase());
            String extension;
            if(extensionPatternMatcher.matches()) {
            	extension = extensionPatternMatcher.group(2);            	
            	fileName = storeId + order + "."+ extension; 
            	try {
            		// Copy file to the target location (Replacing existing file with the same name)
            		Path targetLocation = this.fileStorageLocation.resolve(fileName);
            		Files.copy(fileArr[order].getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
            		
            		fileMap.put("fileName", fileName);
            		fileMap.put("fileOrder", order+1);
            		fileStorageMapper.saveFile(fileMap);
            	} catch (IOException ex) {
            		logger.error("Could not store file " + fileName + ". Please try again!");
            		return 0;
            	}	 
            }else {
            	return 0;
            }
    	}
    	return fileArr.length;
    }

    public Resource loadFileAsResource(String fileName) {
        try {
            Path filePath = this.fileStorageLocation.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());
            if(resource.exists()) {
                return resource;
            } else {
                return null;
            }
        } catch (MalformedURLException ex) {
            return null;
        }
    }	
}
