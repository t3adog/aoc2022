package ru.keptelr.day07;

import java.util.Iterator;
import java.util.Stack;

public class FileSystemElementIterator implements Iterator {

    Stack<Iterator<FileSystemElement>> stack = new Stack<>();

    public FileSystemElementIterator(Iterator iterator) {
        stack.push(iterator);
    }

    @Override
    public boolean hasNext() {
        if (stack.empty()) {
            return false;
        } else {
            Iterator<FileSystemElement> iterator = stack.peek();
            if (!iterator.hasNext()) {
                stack.pop();
                return hasNext();
            } else {
                return true;
            }
        }
    }

    @Override
    public Object next() {
        if (hasNext()) {
            Iterator<FileSystemElement> iterator = stack.peek();
            FileSystemElement fileSystemElement = iterator.next();
            stack.push(fileSystemElement.createIterator());
            return fileSystemElement;
        } else {
            return null;
        }
    }
}
