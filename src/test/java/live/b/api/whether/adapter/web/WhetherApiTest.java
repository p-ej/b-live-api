package live.b.api.whether.adapter.web;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

class WhetherApiTest extends ApiDocumentationTest {

    @Test
    void whether() {
        mockMvcTester.get().uri("/api/v1/whether")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .hasStatus2xxSuccessful()
                .apply(document("whether",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("temperature").description("온도"))))
                .bodyJson()
                .extractingPath("temperature")
                .isEqualTo("23");
    }
}
