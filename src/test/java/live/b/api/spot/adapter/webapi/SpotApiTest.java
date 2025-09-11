package live.b.api.spot.adapter.webapi;

import live.b.api.spot.application.SpotDto;
import live.b.api.spot.application.provided.SpotFinder;
import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

@WebMvcTest(SpotApi.class)
class SpotApiTest extends ApiDocumentationTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @MockitoBean
    SpotFinder spotFinder;

    @Test
    void popular() {
        when(spotFinder.findPopular(anyInt())).thenReturn(List.of(
                new SpotDto(1L, "여행지1", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(2L, "여행지2", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(3L, "여행지3", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg"),
                new SpotDto(4L, "여행지4", "https://static.hubzum.zumst.com/hubzum/2024/03/25/14/a1aacd92e67e4b46802d082c47f07706.jpg")
        ));

        mockMvcTester.get().uri("/api/v1/spots/popular")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .apply(document("spots",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("[].spotId").description("여행지 ID"),
                                fieldWithPath("[].spotName").description("여행지 이름"),
                                fieldWithPath("[].spotImageUrl").description("여행지 이미지 주소"))))
                .hasStatus2xxSuccessful()
                .bodyJson()
                .hasPath("$[0].spotId")
                .hasPath("$[0].spotName")
                .hasPath("$[0].spotImageUrl");
    }
}
