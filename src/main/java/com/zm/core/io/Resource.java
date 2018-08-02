package com.zm.core.io;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取文件的输入流
 */
public interface Resource {
    public InputStream getInputStream() throws IOException;

    public String getDescription();
}
