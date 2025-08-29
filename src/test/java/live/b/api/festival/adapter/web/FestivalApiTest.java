package live.b.api.festival.adapter.web;

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

class FestivalApiTest extends ApiDocumentationTest {

    @Test
    void festivals() {
        mockMvcTester.get().uri("/api/v1/festivals")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .hasStatus2xxSuccessful()
                .apply(document("festivals",
                                getDocumentRequest(),
                                getDocumentResponse(),
                                responseFields(
                                        fieldWithPath("[].festivalId").type(NUMBER).description("행사 ID"),
                                        fieldWithPath("[].festivalImageUrl").type(STRING).description("행사 이미지 주소")
                                )
                        )
                )
                .bodyJson()
                .hasPath("$[0].festivalId")
                .hasPath("$[0].festivalImageUrl");
    }

}