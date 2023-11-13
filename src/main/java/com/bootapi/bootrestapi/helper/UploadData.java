package com.bootapi.bootrestapi.helper;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class UploadData {

    public final String pathUrl = new ClassPathResource("static/image/").getFile().getAbsolutePath(); // Dynamic Path
    
    public UploadData() throws IOException
    {
      
    }

    public boolean uploadUserData(MultipartFile userData) {
        System.out.println(pathUrl);

        try {
            
            Files.copy(userData.getInputStream(),
            Paths.get(pathUrl+File.separator+userData.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);

            
            System.out.println(userData.getOriginalFilename() + " Has Been Uploaded Succesfuly");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}


