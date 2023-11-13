package com.bootapi.bootrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bootapi.bootrestapi.helper.UploadData;

@RestController
public class FileController {
    
    @Autowired
    private UploadData uploadData;

    @PostMapping("/upload")
    public ResponseEntity <String> fileUpload(@RequestParam("file") MultipartFile getFile) {

       boolean result = uploadData.uploadUserData(getFile);
       if(result==true)
       {
          return ResponseEntity.ok("File Uploaded Successfuly..!");
       }
       return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unable To Upload File..!");
    }
}
