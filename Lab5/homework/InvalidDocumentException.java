package homework;

import java.nio.file.FileAlreadyExistsException;

public class InvalidDocumentException extends Exception{
    public InvalidDocumentException(FileAlreadyExistsException ex) {
        super("Document already exists" , ex);

    }
}
