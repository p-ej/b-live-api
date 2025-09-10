package live.b.api.festival.adapter.webapi;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.JsonFieldType.NUMBER;
import static org.springframework.restdocs.payload.JsonFieldType.STRING;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

@WebMvcTest(FestivalApi.class)
class FestivalApiTest extends ApiDocumentationTest {

    @Autowired
    MockMvcTester mockMvcTester;

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