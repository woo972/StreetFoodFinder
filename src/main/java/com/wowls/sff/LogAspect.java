package com.wowls.sff;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
//	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	
	private BufferedWriter bw; 
	private String filePath="";
	private String fileName="StreeFoodFinder.log";
	private Date d;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	// 컨트롤러가 정의한 모든 메서드
	@Before("execution(* com.wowls.sff.controller..*(..))")
	public void berforeLog(JoinPoint joinPoint) {
		System.err.println("method:"+joinPoint.getSignature().getName()
							+" args:"+Arrays.asList(joinPoint.getArgs())); 
		
		try {
			bw = new BufferedWriter(new FileWriter(new File(filePath+fileName), true));
			d = new Date();
			bw.write(sdf.format(d));
			bw.write("\n");
			bw.write("method:"+joinPoint.getSignature().getName()
							+" args:"+Arrays.asList(joinPoint.getArgs()));
			bw.write("\n");
		} catch (IOException e) {
			System.out.println("IO exception:"+e.getMessage());
		} finally {
			if(bw!=null)
				try {
					bw.close();
				} catch (IOException e) {
					System.out.println("IO exception:"+e.getMessage());
				}
		}
		
		
	}
}
