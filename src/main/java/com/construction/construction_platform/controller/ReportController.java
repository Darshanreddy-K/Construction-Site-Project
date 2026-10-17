package com.construction.construction_platform.controller;

import com.construction.construction_platform.service.PdfReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    @Autowired
    private PdfReportService pdfReportService;

    @PostMapping("/generate-po")
    public ResponseEntity<String> triggerPdfGeneration(
            @RequestParam Long procurementId,
            @RequestParam String materialName,
            @RequestParam int quantity,
            @RequestParam String status) {

        // This triggers asynchronously in the background without blocking the HTTP response thread
        pdfReportService.generateProcurementReport(procurementId, materialName, quantity, status);

        return ResponseEntity.ok("Async PDF generation initiated successfully for Procurement ID: " + procurementId);
    }
}