package com.zm.core.type.classreading;

import com.zm.core.io.Resource;
import com.zm.core.type.AnnotationMetadata;
import com.zm.core.type.ClassMetadata;

public interface MetadataReader {

    /**
     * Return the resource reference for the class file.
     */
    Resource getResource();

    /**
     * Read basic class metadata for the underlying class.
     */
    ClassMetadata getClassMetadata();

    /**
     * Read full annotation metadata for the underlying class,
     * including metadata for annotated methods.
     */
    AnnotationMetadata getAnnotationMetadata();

}
