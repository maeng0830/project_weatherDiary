package maeng0830.weather;

import maeng0830.weather.domain.Memo;
import maeng0830.weather.repository.JpaMemoRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional // 테스트 코드의 Transaction은 DB에 커밋 되지 않도록 설정되어 있음.
public class JpaMemoRepositoryTest {

    @Autowired
    JpaMemoRepository jpaMemoRepository;

    @Test
    void insertMemoTest() {
        // given
        Memo newMemo = new Memo(10, "insertMemoTest");
        // when
        jpaMemoRepository.save(newMemo);
        // then
        List<Memo> memoList = jpaMemoRepository.findAll();
        assertTrue(memoList.size() > 0);
    }

    @Test
    void findByIdTest() {
        // given
        Memo newMemo = new Memo(11, "jpa");
        // when

        // db에서 id 값을 직접 관리하기 때문에, 우리가 지정해준 id 값 11은 의미가 없다.
        // 따라서 데이터를 저장하고 반환된 객체의 id 값을 사용해서 비교해야한다.
        Memo memo = jpaMemoRepository.save(newMemo);
        Optional<Memo> result = jpaMemoRepository.findById(memo.getId());

        // then

        assertEquals(result.get(), memo);

    }
}
