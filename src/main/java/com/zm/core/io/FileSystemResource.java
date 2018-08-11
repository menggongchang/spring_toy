package com.zm.core.io;

import org.springframework.util.Assert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 获取绝对路径下的文件输入流
 */
public class FileSystemResource implements Resource {

    private String path;
    private File file;

    public FileSystemResource(String path) {
        Assert.notNull(path, "path not null.");
        this.path = path;
        this.file = new File(path);
    }

    public FileSystemResource(File file) {
        Assert.notNull(file, "file not null.");
        this.path = file.getPath();
        this.file = file;
    }

    @Override
    public InputStream getInputStream() throws IOException {
        return new FileInputStream(this.file);
    }

    @Override
    public String getDescription() {
        return "file [" + this.file.getAbsolutePath() + "]";
    }
}
