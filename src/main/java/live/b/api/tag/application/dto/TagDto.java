package live.b.api.tag.application.dto;

public record TagDto(
        Long tagId,
        String tagType,
        String tagCode,
        String tagName
) {
}
