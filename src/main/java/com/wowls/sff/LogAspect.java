package com.wowls.sff;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAspect {
	
	private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
	
	
//	private BufferedWriter bw; 
//	private String filePath="";
//	private String fileName="StreeFoodFinder.log";
//	private Date d;
//	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	// public com.wowls.sff.controller.UserController.getUserList(Map<String,String> userMap) 형식
	// ..은 해당 경로 이하 모두 or 임의의 파라미터 개수를 의미함 
	@Before("execution(* com.wowls.sff.controller..*(..))")
	public void berforeLog(JoinPoint joinPoint) {
		logger.info("### method : {} / args : {}", 
					joinPoint.getSignature().toShortString(),
					Arrays.asList(joinPoint.getArgs()));
		
//		try {
//			bw = new BufferedWriter(new FileWriter(new File(filePath+fileName), true));
//			d = new Date();
//			bw.write(sdf.format(d));
//			bw.write("\n");
//			bw.write("method:"+joinPoint.getSignature().getName()
//							+" args:"+Arrays.asList(joinPoint.getArgs()));
//			bw.write("\n");
//		} catch (IOException e) {
//			System.out.println("IO exception:"+e.getMessage());
//		} finally {
//			if(bw!=null)
//				try {
//					bw.close();
//				} catch (IOException e) {
//					System.out.println("IO exception:"+e.getMessage());
//				}
//		}
		
		
	}
}
