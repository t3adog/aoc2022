package ru.keptelr.day07;

import lombok.EqualsAndHashCode;

import java.util.*;

public class Dir implements FileSystemElement {

    Iterator<FileSystemElement> iterator = null;
    private FileSystemElement parent;
    private List<FileSystemElement> content;
    private String name;


    public Dir(String name, FileSystemElement parent) {
        this.name = name;
        this.parent = parent;
        this.content = new ArrayList<>();
    }

    @Override
    public void add(FileSystemElement fileSystemElement) {
        content.add(fileSystemElement);
    }

    @Override
    public FileSystemElement getParent() {
        return this.parent;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getSize() {
        return content.stream().mapToInt(FileSystemElement::getSize).sum();
    }

    @Override
    public FsType getType() {
        return FsType.dir;
    }

    @Override
    public List<FileSystemElement> getContent() {
        return this.content;
    }

    public void print(String tab) {
        System.out.println(tab + "-- Dir " + this.name);
        for (FileSystemElement next : this.content) {
            next.print(tab + "--");
        }
    }

    @Override
    public Iterator<FileSystemElement> createIterator() {
        if (iterator == null) {
            //iterator = new FileSystemElementIterator(this.content.stream().filter(fs -> fs.getType() == FsType.dir).iterator());
            iterator = new FileSystemElementIterator(this.content.iterator());
        }
        return iterator;
    }
}
