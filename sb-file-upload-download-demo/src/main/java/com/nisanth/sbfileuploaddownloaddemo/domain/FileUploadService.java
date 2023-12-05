package com.nisanth.sbfileuploaddownloaddemo.domain;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@AllArgsConstructor
public class FileUploadService
{
    @Autowired
   private  FileUploadRepository uploadRepository;
   public FileUpload saveFile(MultipartFile file) throws Exception
   {
       String fileName= StringUtils.cleanPath(file.getOriginalFilename());

       // validate the file
       try {
               if(fileName.contains(".."))
               {
                   throw new Exception("The file name is invalid" + fileName);
               }
               // if  file valid
               FileUpload fileUpload=new FileUpload(fileName,file.getContentType(),file.getBytes());
               return uploadRepository.save(fileUpload);
           }
           catch (Exception e)
           {
               throw new Exception("File could not be save"+e.getMessage());
           }
   }

   public FileUpload downloadFile(String fileId) throws Exception
    {
       return uploadRepository.findById(fileId)
               .orElseThrow(()->new Exception("File with id : "+fileId+ "  could not find"));
   }
}
