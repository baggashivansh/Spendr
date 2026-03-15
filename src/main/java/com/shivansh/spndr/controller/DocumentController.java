package com.shivansh.spndr.controller;

import com.shivansh.spndr.service.DocumentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/documents")
public class DocumentController {

    private final DocumentService documentService;

    public DocumentController(DocumentService documentService) {
        this.documentService = documentService;
    }

    @GetMapping("/generate/{userId}")
    public ResponseEntity<String> generateDocument(@PathVariable Long userId) {

        String filePath = documentService.generateExpenseDocument(userId);

        return ResponseEntity.ok("Document generated at: " + filePath);
    }
}