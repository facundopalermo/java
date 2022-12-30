package edu.up.FileSystem;

import java.util.List;
import javax.naming.OperationNotSupportedException;

public interface FileSystemInterface {
    
    public String getName();
    public int getSize();
    public void addFile(FileSystemInterface file) throws OperationNotSupportedException;
    public List<FileSystemInterface> getFiles() throws OperationNotSupportedException;
    public void removeFile(FileSystemInterface file) throws OperationNotSupportedException;

}
