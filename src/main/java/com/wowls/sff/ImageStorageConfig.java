package com.wowls.sff;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="image")
public class ImageStorageConfig {
	private String uploadDir;
	public String getUploadDir() {
		return uploadDir;
	}
	public void setUploadDir(String uploadDir) {
		this.uploadDir = uploadDir;
	}
}
