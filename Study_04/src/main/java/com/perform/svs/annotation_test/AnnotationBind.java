	package com.perform.svs.annotation_test;
	
	import java.lang.reflect.Field;
	
	public class AnnotationBind {
		public AnnotationBind() {
	
		}
		
		private <T> T invokeAnnonations(T instance) throws IllegalAccessException {
			Field[] fields = instance.getClass().getDeclaredFields();
			for (Field field : fields) {
				Myannotation annotation = field.getAnnotation(Myannotation.class);
				if (annotation != null && field.getType() == String.class) {
					field.setAccessible(true);
					field.set(instance, annotation.name());
				}
			}
			return instance;
		}
	
		/**
		 * 매개변수로 받은 클래스의 객체를 반환합니다.
		 * 
		 * @param clazz
		 * @param <T>
		 * @return
		 * @throws IllegalAccessException
		 * @throws InstantiationException
		 */
		@SuppressWarnings({ "unchecked", "rawtypes" })
		public <T> T get(Class clazz) throws IllegalAccessException, InstantiationException {
			T instance = (T) clazz.newInstance();
			instance = invokeAnnonations(instance);
			return instance;
		}
	}
