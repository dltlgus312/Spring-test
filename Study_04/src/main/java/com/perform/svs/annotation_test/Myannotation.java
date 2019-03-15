package com.perform.svs.annotation_test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({
    ElementType.PACKAGE, // 패키지 선언시
    ElementType.TYPE, // 타입 선언시
    ElementType.CONSTRUCTOR, // 생성자 선언시
    ElementType.FIELD, // 멤버 변수 선언시
    ElementType.METHOD, // 메소드 선언시
    ElementType.ANNOTATION_TYPE, // 어노테이션 타입 선언시
    ElementType.LOCAL_VARIABLE, // 지역 변수 선언시
    ElementType.PARAMETER, // 매개 변수 선언시
})
@Retention(RetentionPolicy.RUNTIME)
public @interface Myannotation {
	
	public enum Quality {BAD, GOOD, VERYGOOD}
	
	public String name();
	public Quality quality() default Quality.GOOD;
}