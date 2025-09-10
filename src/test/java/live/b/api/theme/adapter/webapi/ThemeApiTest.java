package live.b.api.theme.adapter.webapi;

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

@WebMvcTest(ThemeApi.class)
class ThemeApiTest extends ApiDocumentationTest {

    @Autowired
    public MockMvcTester mockMvcTester;

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
                                fieldWithPath("[].themeImageUrl").description("테마 이미지 주소"),
                                fieldWithPath("[].themeImageName").description("테마 이미지 이름"))))
                .hasStatus2xxSuccessful()
                .bodyJson()
                .hasPath("$[0].themeName")
                .hasPath("$[0].themeImageUrl")
                .hasPath("$[0].themeImageUrl");
    }
}
