package edu.up.FileSystem;

import java.util.ArrayList;
import java.util.List;


public class Folder implements FileSystemInterface {

    private String name;
    private List<FileSystemInterface> files = new ArrayList<FileSystemInterface>();

    public Folder(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        
        return name;
    }

    @Override
    public int getSize() {

        int size = 0;
        
        for (FileSystemInterface file : files) {
            size += file.getSize();
        }

        return size;
    }

    @Override
    public void addFile(FileSystemInterface file) {
        files.add(file);
    }

    @Override
    public void removeFile(FileSystemInterface file) {
        files.remove(file);
    }

    @Override
    public List<FileSystemInterface> getFiles() {
        return files;
    }

    
    
}
