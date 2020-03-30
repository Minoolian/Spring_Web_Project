/*(200326) Controller 작성 시 파라미터 자동 수집 -> 매번 request.getParameter() 이용하지 않아도 된다*/

package org.zerock.domain;

import lombok.Data;

//(200330) chap6.4.1 @ModelAttribute: MVC의 Controller는 기본적으로 Java Beans 규칙(생성자,getter/setter를 가진 클래스의 객체들)에 맞는 객체는 다시 화면으로 객체를 전달.
//getter, setter, equals(), toString()등 자동생성 하는 Lombok
@Data
public class SampleDTO {

	private String name;
	private int age;
	
}
