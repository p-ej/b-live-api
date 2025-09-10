package live.b.api.spot.application;

public record SpotDto(
        Long spotId,
        String spotName,
        String spotImageUrl
) {
}
