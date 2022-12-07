package ru.keptelr.day07;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public interface FileSystemElement {

    void add(FileSystemElement fileSystemElement);

    FileSystemElement getParent();

    List<FileSystemElement> getContent();

    String getName();

    int getSize();

    FsType getType();

    void print(String tab);

    Iterator<FileSystemElement> createIterator();

}
