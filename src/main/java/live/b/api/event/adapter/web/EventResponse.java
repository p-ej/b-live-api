package live.b.api.event.adapter.web;

public record EventResponse(
        Long eventId,
        String eventCategory,
        String eventImageUrl,
        String eventName
) {
}
