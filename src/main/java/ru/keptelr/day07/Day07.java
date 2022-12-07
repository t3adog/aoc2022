package ru.keptelr.day07;

import org.apache.commons.lang3.Range;

import java.util.*;

public class Day07 {

    private Range<Integer> parseLsOutputRange(List<String> input, int from) {
        for (int i = from; i < input.size(); i++) {
            String line = input.get(i);
            if (line.startsWith("$")) {
                return Range.between(from, i);
            }
        }
        return Range.between(from, input.size());
    }

    private List<FileSystemElement> parseLsOutputFiles(List<String> input, Range<Integer> lsOutputRange, FileSystemElement parent) {
        List<FileSystemElement> files = new ArrayList<>();
        for (int i = lsOutputRange.getMinimum(); i < lsOutputRange.getMaximum(); i++) {
            String line = input.get(i);
            if (Character.isDigit(line.charAt(0))) {
                files.add(new File(line.split(" ")[1], Integer.parseInt(line.split(" ")[0]), parent));
            }
        }
        return files;
    }

    private FileSystemElement parseFileSystem(List<String> input) {
        FileSystemElement root = null;
        FileSystemElement currentPosition = null;

        for (int i = 0; i < input.size(); i++) {
            String line = input.get(i);

            if (!line.startsWith("$")) {
                throw new RuntimeException("Not command line");
            }

            String command = line.replaceAll("\\$ ", "");
            if (command.startsWith("cd")) {
                String path = command.replaceAll("cd ", "");
                if (path.equals("/") && Objects.isNull(root)) {
                    if (root == null) {
                        root = new Dir(path, null);
                    }
                    currentPosition = root;
                } else {
                    if (path.equals("..")) {
                        currentPosition = currentPosition.getParent();
                    } else {
                        Dir nextPosition = new Dir(path, currentPosition);
                        currentPosition.add(nextPosition);
                        currentPosition = nextPosition;
                    }
                }
            } else if (command.startsWith("ls")) {
                Range<Integer> lsOutputRange = parseLsOutputRange(input, i + 1);
                List<FileSystemElement> files = parseLsOutputFiles(input, lsOutputRange, currentPosition);
                currentPosition.getContent().addAll(files);
                i = lsOutputRange.getMaximum() - 1;
            }
        }
        return root;
    }


    public Integer partOne(List<String> input) {
        FileSystemElement root = parseFileSystem(input);

        Iterator<FileSystemElement> iterator = root.createIterator();
        List<FileSystemElement> dirs = new ArrayList<>();
        while (iterator.hasNext()) {
            FileSystemElement element = iterator.next();
            if (element.getType() == FsType.dir) {
                dirs.add(element);
            }
        }
        return dirs.stream().filter(dir -> dir.getSize() < 100000).mapToInt(FileSystemElement::getSize).sum();
    }

    public int partTwo(List<String> input) {
        FileSystemElement root = parseFileSystem(input);

        int totalDiskSpace = 70000000;
        int updateSize = 30000000;
        int freeSpace = totalDiskSpace - root.getSize();
        int needForUpdate = updateSize - freeSpace;

        Iterator<FileSystemElement> iterator = root.createIterator();
        List<FileSystemElement> dirs = new ArrayList<>();
        while (iterator.hasNext()) {
            FileSystemElement element = iterator.next();
            if (element.getType() == FsType.dir) {
                dirs.add(element);
            }
        }
        return dirs.stream().filter(dir -> dir.getSize() >= needForUpdate).mapToInt(FileSystemElement::getSize).min().orElse(0);
    }

}
