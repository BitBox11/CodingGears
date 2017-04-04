package org.zerock.persistence;

public class BoardDAO extends AbstractDAO {
	//컨트롤러가 사용하기 전에 초기화함. 리스너를 이용해서 얘를 만들어 놓으면 서브 컨트롤러들이 자기들이 원할 떄 찾아서 씀. 그 구조자체가 한 세트임.
	//개발의 전제 : jsp 는 EL과 JSTL, 모든 호출은 모델 2방식을 씀.
	public BoardDAO() throws Exception {
		super();
		
	}

}
