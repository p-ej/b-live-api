package live.b.api.spot.adapter.webapi;

public record PopularSpotResponse(
        Long spotId,
        String spotName,
        String spotImageUrl
) {
}
