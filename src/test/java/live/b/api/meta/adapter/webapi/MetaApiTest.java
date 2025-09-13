package live.b.api.meta.adapter.webapi;

import live.b.api.region.application.dto.RegionDto;
import live.b.api.region.application.provided.RegionFinder;
import live.b.api.support.ApiDocumentationTest;
import live.b.api.tag.application.dto.TagDto;
import live.b.api.tag.application.provided.TagFinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.assertj.MockMvcTester;

import java.util.List;
import java.util.Locale;

import static live.b.api.support.ApiDocumentUtils.getDocumentRequest;
import static live.b.api.support.ApiDocumentUtils.getDocumentResponse;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;

@WebMvcTest(MetaApi.class)
class MetaApiTest extends ApiDocumentationTest {

    @Autowired
    public MockMvcTester mockMvcTester;

    @MockitoBean
    RegionFinder regionFinder;

    @MockitoBean
    TagFinder tagFinder;

    @Test
    void getMeta() {
        when(regionFinder.findAll(any(Locale.class))).thenReturn(List.of(new RegionDto(1L, "regionName", "imageUrl")));
        when(tagFinder.findAll(any(Locale.class))).thenReturn(List.of(new TagDto(1L, "tagType", "tagCode", "tagLabel")));

        mockMvcTester.get().uri("/api/v1/meta")
                .contentType(MediaType.APPLICATION_JSON)
                .assertThat()
                .apply(document("meta",
                                getDocumentRequest(),
                                getDocumentResponse(),
                                responseFields(
                                        subsectionWithPath("regions").description("지역"),
                                        fieldWithPath("regions.[]").description(""),
                                        fieldWithPath("regions.[].regionId").description("지역 ID"),
                                        fieldWithPath("regions.[].regionName").description("지역 이름"),
                                        fieldWithPath("regions.[].regionImageUrl").description("지역 이미지 URL"),
                                        subsectionWithPath("tags").description("태그"),
                                        subsectionWithPath("tags.tagType.[]").description("태그타입"),
                                        fieldWithPath("tags.tagType.[].tagId").description("태그 ID"),
                                        fieldWithPath("tags.tagType.[].tagType").description("태그 타입"),
                                        fieldWithPath("tags.tagType.[].tagCode").description("태그 코드"),
                                        fieldWithPath("tags.tagType.[].tagLabel").description("태그 라벨")
                                )
                        )
                )
                .hasStatus2xxSuccessful()
                .bodyJson()
                .hasPath("$.regions[0].regionId")
                .hasPath("$.regions[0].regionName")
                .hasPath("$.regions[0].regionImageUrl")
                .hasPath("$.tags.tagType[0].tagId")
                .hasPath("$.tags.tagType[0].tagType")
                .hasPath("$.tags.tagType[0].tagCode")
                .hasPath("$.tags.tagType[0].tagLabel");
    }
}
