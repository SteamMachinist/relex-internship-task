package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import steammachinist.relexinternshiptask.dto.response.HarvestStatisticsResponse;
import steammachinist.relexinternshiptask.service.persistence.HarvestEntryService;

@RestController
@RequestMapping("/harvest/stats")
@RequiredArgsConstructor
public class HarvestStatisticsController {
    private final HarvestEntryService harvestEntryService;

    @GetMapping("/by-employee")
    public ResponseEntity<HarvestStatisticsResponse> getStatsByEmployee(@RequestParam String email) {
        return ResponseEntity.ok(new HarvestStatisticsResponse());
    }

    @GetMapping("/by-date")
    public ResponseEntity<HarvestStatisticsResponse> getStatsByDate(@RequestParam String date) {
        return ResponseEntity.ok(harvestEntryService.byDate(date));
    }
}
