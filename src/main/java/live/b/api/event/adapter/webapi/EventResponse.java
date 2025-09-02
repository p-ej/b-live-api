package live.b.api.event.adapter.webapi;

public record EventResponse(
        Long eventId,
        String eventCategory,
        String eventImageUrl,
        String eventName
) {
}
