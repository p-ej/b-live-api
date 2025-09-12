package live.b.api.weather.adapter.webapi;

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

@WebMvcTest(WeatherApi.class)
class WeatherApiTest extends ApiDocumentationTest {

    @Autowired
    MockMvcTester mockMvcTester;
    
    @Test
    void weather() {
        mockMvcTester.get().uri("/api/v1/weather")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .hasStatus2xxSuccessful()
                .apply(document("weather",
                        getDocumentRequest(),
                        getDocumentResponse(),
                        responseFields(
                                fieldWithPath("temperature").description("온도"))))
                .bodyJson()
                .extractingPath("temperature")
                .isEqualTo("23");
    }
}
