package ru.keptelr.day07;

import lombok.EqualsAndHashCode;

import java.util.Iterator;
import java.util.List;

public class File implements FileSystemElement {

    private String name;
    private int size;

    private FileSystemElement parent;

    public File(String name, int size, FileSystemElement parent) {
        this.name = name;
        this.size = size;
        this.parent = parent;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    @Override
    public FsType getType() {
        return FsType.file;
    }

    @Override
    public void print(String tab) {
        System.out.println(tab + "-- file " + this.size + " " + this.name);
    }

    @Override
    public Iterator<FileSystemElement> createIterator() {
        return new NullIterator();
    }

    @Override
    public void add(FileSystemElement fileSystemElement) {
        throw new UnsupportedOperationException();
    }

    @Override
    public FileSystemElement getParent() {
        return this.parent;
    }

    @Override
    public List<FileSystemElement> getContent() {
        throw new UnsupportedOperationException();
    }
}
