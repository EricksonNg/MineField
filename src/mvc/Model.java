package mvc;

import tools.Publisher;

import java.io.Serializable;

public abstract class Model extends Publisher implements Serializable {
    private static final long serialVersionUID = 1L;

    private String fileName;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
