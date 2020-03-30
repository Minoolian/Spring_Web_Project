package org.zerock.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

//(200330) chap6.3.3 객체리스트:객체타입을 여러개 처리해야 한다면 객체리스트를 설계
@Data
public class SampleDTOList {

		private List<SampleDTO> list;
		
		public SampleDTOList() {
			list=new ArrayList<>();
		}

}
