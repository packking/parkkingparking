package templetmethodTest;

import java.util.List;
import java.util.Set;

public interface DtoTest {
	//데이터 삽입하는 메소드
	public boolean insertCt (Ct ct);	//작업 성공 실패 여부
	
	//데이터 수정하는 메소드
	public boolean updateCt (Ct ct);
	
	//데이터 삭제하는 메소드	- 삭제할 때는 일부 자료만 제공 -> 기본키 위주	- 기본키가 num
	public boolean deleteCt (int num);
	
	//데이터 전체 읽어오는 메소드
	//데이터가 0개 이상이므로 list로 리턴하고 읽어 올 컬럼들을 저장할 클래스나 map으로 제네릭을 적용
	public List<Ct> allreadCt();
	
	//num을 가지고 조회	-	 중복 허용
	public List<Ct> nameCt(String name);
	
	//num을 가지고 조회	-	기본키라 중복x
	public Set<Ct> numCt(int num);
	
}
