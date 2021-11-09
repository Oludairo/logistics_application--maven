package african.semicolon.cheatah.controllers;

import african.semicolon.cheatah.data.models.TrackingInformation;
import african.semicolon.cheatah.dtos.requests.AddTrackingInfoRequest;
import african.semicolon.cheatah.services.TrackingService;
import african.semicolon.cheatah.services.TrackingServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class PackageTrackingController {
    private final TrackingService trackingService = new TrackingServiceImpl();

    @PatchMapping("/api/trackingInfo")
    public Object addTrackingInfo(@RequestBody AddTrackingInfoRequest addTrackingInfoRequest) {
        return trackingService.updateTrackingInfo(addTrackingInfoRequest);
    }

    @GetMapping("/api/trackingInfo/{id}")
    public TrackingInformation getTrackingInfo(@PathVariable("id") Integer trackingId) {
        return trackingService.trackPackage(trackingId);
    }
}
