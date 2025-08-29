package live.b.api.course.adapter.web;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

class CourseApiTest extends ApiDocumentationTest {

    @Test
    void popular() {
        mockMvcTester.get().uri("/api/v1/courses/popular")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .hasStatus2xxSuccessful()
                .apply(document("courses",
                                getDocumentRequest(),
                                getDocumentResponse(),
                                responseFields(
                                        fieldWithPath("[].courseId").type(NUMBER).description("코스 ID"),
                                        fieldWithPath("[].courseName").type(STRING).description("코스 이름"),
                                        fieldWithPath("[].courseTitle").type(STRING).description("코스 제목"),
                                        fieldWithPath("[].courseDescription").type(STRING).description("코스 설명"),
                                        fieldWithPath("[].durationHours").type(NUMBER).description("코스 소요 시간"),
                                        fieldWithPath("[].courseImageUrl").type(STRING).description("코스 이미지 주소"),
                                        subsectionWithPath("[].spots").type(ARRAY).description("여행지 목록"),
                                        fieldWithPath("[].spots[].spotId").type(NUMBER).description("여행지 ID"),
                                        fieldWithPath("[].spots[].spotName").type(STRING).description("여행지 이름")
                                )
                        )
                )
                .bodyJson()
                .hasPath("$[0].courseId")
                .hasPath("$[0].courseName")
                .hasPath("$[0].courseTitle")
                .hasPath("$[0].courseDescription")
                .hasPath("$[0].durationHours")
                .hasPath("$[0].courseImageUrl")
                .hasPath("$[0].spots[0].spotId")
                .hasPath("$[0].spots[0].spotName");
    }

}
