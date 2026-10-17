package com.construction.construction_platform.procurement;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProcurementService {

    private final ProcurementRepository procurementRepository;

    public ProcurementService(ProcurementRepository procurementRepository) {
        this.procurementRepository = procurementRepository;
    }

    public ProcurementRequest createDraft(Long itemId, Integer quantity, Double estimatedCost, String requestedBy) {
        ProcurementRequest request = new ProcurementRequest();
        request.setItemId(itemId);
        request.setQuantity(quantity);
        request.setEstimatedCost(estimatedCost);
        request.setRequestedBy(requestedBy);
        request.setStatus(ProcurementStatus.DRAFT);
        return procurementRepository.save(request);
    }

    @Transactional
    public ProcurementRequest updateStatus(Long id, ProcurementStatus newStatus) {
        ProcurementRequest request = procurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procurement request not found with ID: " + id));

        // Simple state transition logic can be guarded here if needed
        request.setStatus(newStatus);
        return procurementRepository.save(request);
    }

    public ProcurementRequest getById(Long id) {
        return procurementRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Procurement request not found with ID: " + id));
    }
}