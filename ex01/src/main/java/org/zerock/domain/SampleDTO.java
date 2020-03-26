/*(200326) Controller 작성 시 파라미터 자동 수집 -> 매번 request.getParameter() 이용하지 않아도 된다*/

package org.zerock.domain;

import lombok.Data;

//getter, setter, equals(), toString()등 자동생성 하는 Lombok
@Data
public class SampleDTO {

	private String name;
	private int age;
	
}
