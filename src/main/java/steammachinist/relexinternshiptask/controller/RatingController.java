package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import steammachinist.relexinternshiptask.dto.request.AddRatingRequest;
import steammachinist.relexinternshiptask.dto.response.RatingListResponse;
import steammachinist.relexinternshiptask.service.persistence.RatingService;

import java.util.List;

@RestController
@RequestMapping("/rating")
@RequiredArgsConstructor
public class RatingController {
    private final RatingService ratingService;

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<Void> addRating(@RequestBody AddRatingRequest request) {
        ratingService.add(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public ResponseEntity<List<RatingListResponse>> getAllRatings() {
        return ResponseEntity.ok().body(ratingService.getAllResponse());
    }
}
