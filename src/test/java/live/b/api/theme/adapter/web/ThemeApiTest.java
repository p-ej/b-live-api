package live.b.api.theme.adapter.web;

import live.b.api.support.ApiDocumentationTest;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;

class ThemeApiTest extends ApiDocumentationTest {

    @Test
    void themes() {
        mockMvcTester.get()
                .uri("/api/v1/themes")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .apply(document("themes",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("[].themeName").description("테마 명"),
                                fieldWithPath("[].imageUrl").description("이미지 주소"),
                                fieldWithPath("[].imageName").description("이미지 이름"))))
                .hasStatus2xxSuccessful()
                .bodyJson()
                .hasPath("$[0].themeName")
                .hasPath("$[0].imageUrl")
                .hasPath("$[0].imageName");
    }
}
