package com.zm.core.io.support;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PackageResourceLoaderTest {


    @Test
    public void getClassLoader() {
    }

    @Test
    public void getResources() {
        PackageResourceLoader packageResourceLoader = new PackageResourceLoader();
        try {
            packageResourceLoader.getResources("com.zm.core.io.support");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}