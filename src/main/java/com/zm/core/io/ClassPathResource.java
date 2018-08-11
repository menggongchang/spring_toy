package com.zm.core.io;

import org.springframework.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * 资源文件夹下的文件输入流
 */
public class ClassPathResource implements Resource {

    private String path;//"com/zm/PetStoreService.class"
    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    @Override
    public InputStream getInputStream() throws IOException {
        InputStream inputStream = classLoader.getResourceAsStream(this.path);
        if (inputStream == null) {
            throw new FileNotFoundException(path + " not found.");
        }
        return inputStream;
    }

    @Override
    public String getDescription() {
        return this.path;
    }
}
