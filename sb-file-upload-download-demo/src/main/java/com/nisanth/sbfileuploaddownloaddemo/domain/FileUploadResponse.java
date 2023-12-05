package com.nisanth.sbfileuploaddownloaddemo.domain;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FileUploadResponse
{
    private String fileName;
    private String downloadUrl;
    private String fileType;
    private long fileSize;
}
