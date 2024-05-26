package bg.softuni.pathfinder.model.dto.binding;

import bg.softuni.pathfinder.validation.annotation.FileAnnotation;
import org.springframework.web.multipart.MultipartFile;

public class UploadRoutePictureBindingModel {
    private long id;
    @FileAnnotation(contentTypes = {"image/png", "image/jpeg"})
    private MultipartFile picture;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MultipartFile getPicture() {
        return picture;
    }
}
