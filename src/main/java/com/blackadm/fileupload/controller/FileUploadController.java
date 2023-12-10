package com.blackadm.fileupload.controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blackadm.fileupload.config.FileUploadProperties;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/api/files")
public class FileUploadController {

    private final Path fileUploadLocation;

    public FileUploadController(FileUploadProperties fileUploadProperties) {
        this.fileUploadLocation = 
            Paths.get(fileUploadProperties.getUploadDir())
            .toAbsolutePath().normalize();
    }

    @PostMapping("/uploads")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
    
        try {
            Path targetLocation  = fileUploadLocation.resolve(fileName);
            file.transferTo(targetLocation);

            String fileDownloadUri = ServletUriComponentsBuilder
                .fromCurrentContextPath()
                .path("/api/files/download/")
                .path(fileName)
                .toUriString();

                return ResponseEntity.ok("Upload finalizado! link do download" + fileDownloadUri);
        } catch (IOException err) {
            return ResponseEntity.badRequest().build();
        }
    }
    
}
