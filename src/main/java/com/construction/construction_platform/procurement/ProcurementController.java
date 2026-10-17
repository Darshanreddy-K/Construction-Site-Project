package com.construction.construction_platform.procurement;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/procurement")
public class ProcurementController {

    private final ProcurementService procurementService;

    public ProcurementController(ProcurementService procurementService) {
        this.procurementService = procurementService;
    }

    @PostMapping("/request")
    public ResponseEntity<ProcurementRequest> createRequest(@RequestBody ProcurementRequest request) {
        ProcurementRequest created = procurementService.createDraft(
                request.getItemId(),
                request.getQuantity(),
                request.getEstimatedCost(),
                request.getRequestedBy()
        );
        return ResponseEntity.ok(created);
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<ProcurementRequest> updateStatus(
            @PathVariable Long id,
            @RequestParam ProcurementStatus status) {
        ProcurementRequest updated = procurementService.updateStatus(id, status);
        return ResponseEntity.ok(updated);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProcurementRequest> getRequest(@PathVariable Long id) {
        return ResponseEntity.ok(procurementService.getById(id));
    }
}