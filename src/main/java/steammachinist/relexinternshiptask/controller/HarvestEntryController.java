package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import steammachinist.relexinternshiptask.dto.request.AddHarvestEntryRequest;
import steammachinist.relexinternshiptask.service.persistence.HarvestEntryService;

@RestController
@RequestMapping("/harvest")
@RequiredArgsConstructor
public class HarvestEntryController {
    private final HarvestEntryService harvestEntryService;

    @PostMapping("/add")
    public ResponseEntity<Void> addHarvestEntry(@RequestBody AddHarvestEntryRequest request) {
        harvestEntryService.add(request);
        return ResponseEntity.ok().build();
    }
}
