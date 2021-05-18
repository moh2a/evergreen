package util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.web.multipart.MultipartFile;

public class FileUpload {
	public static void saveFile(String uploadDir, String fileName,
            MultipartFile multipartFile) throws IOException {
        Path uploadPath = Paths.get(uploadDir);
         
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }
         
        try (InputStream inputStream = multipartFile.getInputStream()) {
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ioe) {        
            throw new IOException("Could not save image file: " + fileName, ioe);
        }      
    }
    public static void deleteFile(String uploadDir){
        Path uploadPath = Paths.get(uploadDir);
        if(Files.exists(uploadPath)){
            try {
                File directory = new File(uploadDir);

                // list all the files in an array
                File[] files = directory.listFiles();

                // delete each file from the directory
                for(File file : files) {
                    System.out.println(file + " deleted.");
                    file.delete();
                }

                // delete the directory
                if(directory.delete()) {
                    System.out.println("Directory Deleted");
                }
                else {
                    System.out.println("Directory not Found");
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
        }
    }
}
