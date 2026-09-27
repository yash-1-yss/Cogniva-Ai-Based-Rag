package com.cogniva.backend.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import okhttp3.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api/v1/documents")
@Tag(name = "Document Management", description = "Controller for document/vector embedding upload and management")
public class DocumentController {
    @PostMapping
    @Operation(
            summary = "Upload a documen(Pdf,word,txt) for vector embedding and storage",
            description = "Endpoint to upload a document for vector embedding and storage."
    )
    public ResponseEntity<String> uploadDocument() {
        return ResponseEntity.ok("Document uploaded successfully");
    }

}
