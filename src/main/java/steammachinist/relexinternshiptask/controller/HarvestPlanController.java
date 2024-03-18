package steammachinist.relexinternshiptask.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import steammachinist.relexinternshiptask.dto.request.AddHarvestPlanRequest;

@RestController
@RequestMapping("/plan")
@RequiredArgsConstructor
public class HarvestPlanController {
    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String addHarvestPlan(@RequestBody AddHarvestPlanRequest request) {
        return "Hello, manager!";
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ROLE_MANAGER')")
    public String getAllHarvestPlansProgress() {
        return "Hello, manager!";
    }

    @GetMapping("/get")
    public String getUserHarvestPlanProgress() {
        return "Hello, manager!";
    }
}
