package edu.up.FileSystem;

import java.util.List;

import javax.naming.OperationNotSupportedException;

public class File implements FileSystemInterface {

    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public void addFile(FileSystemInterface file) throws OperationNotSupportedException {
        throw new OperationNotSupportedException("No es posible meter " + file.getName() + " en " + this.name + ". Es un archivo.");
    }

    @Override
    public void removeFile(FileSystemInterface file) throws OperationNotSupportedException {
        throw new OperationNotSupportedException(this.getName() + "Operación no valida para un archivo");
    }

    @Override
    public List<FileSystemInterface> getFiles() throws OperationNotSupportedException {
        throw new OperationNotSupportedException(this.getName() + "Operación no valida para un archivo");  
    }

}
