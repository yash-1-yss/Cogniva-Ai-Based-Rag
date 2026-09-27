package com.cogniva.backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "document_metadata")
@Data
@AllArgsConstructor
@Builder
@RequiredArgsConstructor
public class DocumentMetadata {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(nullable = false)
    private String filename;
    @Column(nullable = false)
    private String contentType;
    private long fileSize;
    private Integer totalPages;
    private Integer totalChunks;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime updatedAt;


    @Enumerated(EnumType.STRING)
    @Column(nullable = false)

    private DocumentStatus status;
    @Column(length = 1000)
    private String errorMessage;


}
