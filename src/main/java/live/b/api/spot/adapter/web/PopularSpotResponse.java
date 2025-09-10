package live.b.api.spot.adapter.web;

public record PopularSpotResponse(
        Long spotId,
        String spotName,
        String spotImageUrl
) {
}
