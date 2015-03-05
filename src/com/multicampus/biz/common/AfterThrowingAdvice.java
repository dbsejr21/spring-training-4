package com.multicampus.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

//@Service("afterThrowing")
@Aspect
public class AfterThrowingAdvice {

	@AfterThrowing(pointcut="PointcutCommon.allPointcut()", throwing="exceptObj")
	public void exceptionLog(JoinPoint jp, Exception exceptObj) {
		String method = jp.getSignature().getName();
		
		if(exceptObj instanceof EmptyResultDataAccessException) {
			System.out.println("�˻� ����� �ݵ�� �ϳ��� �־�� �մϴ�.");
		} else {
			System.out.println("[���� ó��] " + method + 
					"() �޼ҵ忡�� �߻��� ���� �޽��� : " + 
						exceptObj.getMessage());
		}
	}
}
