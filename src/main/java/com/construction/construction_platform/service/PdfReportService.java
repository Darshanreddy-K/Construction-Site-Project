package com.construction.construction_platform.service;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;

@Service
public class PdfReportService {

    private final String STORAGE_DIR = "./generated-reports/";

    @Async
    public CompletableFuture<String> generateProcurementReport(Long procurementId, String materialName, int quantity, String status) {
        try {
            // Ensure directory exists
            Path path = Paths.get(STORAGE_DIR);
            if (!Files.exists(path)) {
                Files.createDirectories(path);
            }

            String fileName = STORAGE_DIR + "Procurement_Invoice_" + procurementId + ".pdf";
            Document document = new Document();
            PdfWriter.getInstance(document, new FileOutputStream(fileName));

            document.open();

            // Add Title
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18);
            document.add(new Paragraph("Construction Operations Platform - Purchase Order", titleFont));
            document.add(new Paragraph("---------------------------------------------------------------------------------"));

            // Add Details
            document.add(new Paragraph("Procurement ID: " + procurementId));
            document.add(new Paragraph("Material Name: " + materialName));
            document.add(new Paragraph("Requested Quantity: " + quantity));
            document.add(new Paragraph("Current Status: " + status));
            document.add(new Paragraph("Generated Date: " + java.time.LocalDate.now()));

            document.close();

            System.out.println("Async PDF generated successfully at: " + fileName);
            return CompletableFuture.completedFuture("PDF generated: " + fileName);

        } catch (IOException | com.lowagie.text.DocumentException e) {
            System.err.println("Error generating PDF asynchronously: " + e.getMessage());
            return CompletableFuture.completedFuture("Failed to generate PDF");
        }
    }
}