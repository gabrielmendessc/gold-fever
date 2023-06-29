package gapherd.com.util;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {

    public enum ImageType {

        SPRITE("/img/sprite/"),
        TILESET("/img/tileset/");

        private String path;

        ImageType(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
    }

    public static BufferedImage loadImage(ImageType imageType, String imageName) {

        String path = imageType.getPath().concat(imageName).concat(".png");

        InputStream inputStream = ImageUtils.class.getResourceAsStream(path);

        try {

            assert inputStream != null;
            return ImageIO.read(inputStream);

        } catch (IOException e) {

            throw new RuntimeException(e);

        }

    }

}
