package com.example.taskboardbackend.Infrastructure.MemoryUtility;

import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Service
public class SaveImageInMemoryCase {

    public String execute(BufferedImage image, Long userId) throws RuntimeException{
        try {
            UUID uuid = UUID.randomUUID();
            String destPath = "src/main/resources/user-images";
            File filePath = new File(destPath);
            String name = uuid + "-" + userId + ".jpeg";
            File dest = new File(filePath.getAbsolutePath(), name);
            ImageIO.write(image, "jpeg", dest);
            return destPath+"/"+name;
        }catch (IOException e){
            throw new RuntimeException("Error with saving image");
        }
    }
}
