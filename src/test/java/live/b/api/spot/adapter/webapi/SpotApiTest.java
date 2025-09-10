package live.b.api.spot.adapter.webapi;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

@WebMvcTest(SpotApi.class)
class SpotApiTest extends ApiDocumentationTest {

    @Autowired
    MockMvcTester mockMvcTester;

    @Test
    void popular() {
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
