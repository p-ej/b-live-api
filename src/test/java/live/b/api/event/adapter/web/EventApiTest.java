package live.b.api.event.adapter.web;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

class EventApiTest extends ApiDocumentationTest {

    @Test
    void events() {
        mockMvcTester.get().uri("/api/v1/events")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .hasStatus2xxSuccessful()
                .apply(document("events",
                                getDocumentRequest(),
                                getDocumentResponse(),
                                responseFields(
                                        fieldWithPath("[].eventId").type(NUMBER).description("이벤트 ID"),
                                        fieldWithPath("[].eventName").type(STRING).description("이벤트 이름"),
                                        fieldWithPath("[].eventCategory").type(STRING).description("이벤트 카테고리"),
                                        fieldWithPath("[].eventImageUrl").type(STRING).description("이벤트 이미지 주소")
                                )
                        )
                )
                .bodyJson()
                .hasPath("$[0].eventId")
                .hasPath("$[0].eventName")
                .hasPath("$[0].eventCategory")
                .hasPath("$[0].eventImageUrl");
    }

}