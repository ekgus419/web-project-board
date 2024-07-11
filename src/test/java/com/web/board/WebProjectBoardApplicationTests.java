package com.web.board;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

// @SpringBootTest는 초기 테스트 환경을 구성하면서 프로퍼티 파일의 설정을 참고한다.
@ActiveProfiles("local-test")
@SpringBootTest
class WebProjectBoardApplicationTests {

    @Test
    void contextLoads() {
    }

}
