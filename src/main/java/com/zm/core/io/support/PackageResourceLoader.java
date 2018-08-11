package com.zm.core.io.support;

import com.zm.core.io.FileSystemResource;
import com.zm.core.io.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

//将一个包中的类全部加载为资源
public class PackageResourceLoader {

    private final static Logger LOGGER = LoggerFactory.getLogger(PackageResourceLoader.class);

    private final ClassLoader classLoader;

    public PackageResourceLoader() {

        this.classLoader = ClassUtils.getDefaultClassLoader();
    }


    public ClassLoader getClassLoader() {
        return classLoader;
    }


    //package包资源
    public Resource[] getResources(String packagePath) throws IOException {
        Assert.notNull(packagePath, "packagePath not null");

        //类 com.zm.core.io.support 转换为路径 com/zm/core/io/support
        String location = ClassUtils.convertClassNameToResourcePath(packagePath);

        //file:/Users/zhoumeng/workplace/spring_toy/target/test-classes/com/zm/core/io/support
        URL url = this.getClassLoader().getResource(location);

        File rootDir = new File(url.getFile());
        Set<File> matchingFiles = retrieveMatchingFiles(rootDir);

        Resource[] resources = new Resource[matchingFiles.size()];
        int i = 0;
        for (File file : matchingFiles) {
            resources[i++] = new FileSystemResource(file);
        }
        return resources;
    }

    private Set<File> retrieveMatchingFiles(File rootDir) throws IOException {
        if (!rootDir.exists()) {
            LOGGER.debug("Skipping [" + rootDir.getAbsolutePath() + "], not exist.");
            return Collections.emptySet();
        }

        if (!rootDir.isDirectory()) {
            LOGGER.debug("Skipping [" + rootDir.getAbsolutePath() + "], not dir.");
            return Collections.emptySet();
        }

        if (!rootDir.canRead()) {
            LOGGER.debug("[" + rootDir.getAbsolutePath() + "], is not allowed to read.");
            return Collections.emptySet();
        }

        Set<File> result = new LinkedHashSet<>(8);
        doRetrieveMatchingFiles(rootDir, result);
        return result;
    }

    //递归寻找目录下满足条件的文件
    private void doRetrieveMatchingFiles(File rootDir, Set<File> result) throws IOException {
        File[] dirContents = rootDir.listFiles();
        if (dirContents == null) {
            return;
        }

        for (File file : dirContents) {
            if (file.isDirectory()) {
                if (!file.canRead()) {
                    LOGGER.debug("Skipping [" + file.getAbsolutePath() + "], is not allowed to read.");
                } else {
                    doRetrieveMatchingFiles(file, result);
                }
            } else {
                result.add(file);
            }
        }
    }
}
