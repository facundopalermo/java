package edu.up.FileSystem;

import javax.naming.OperationNotSupportedException;

public class SO {
    public static void main(String[] args) {

        FileSystemInterface archivo1 = new File("Archivo 1", 500);
        FileSystemInterface archivo2 = new File("Archivo 2", 2048);
        FileSystemInterface archivo3 = new File("Archivo 3", 1024);

        FileSystemInterface carpeta1 = new Folder("Carpeta 1");
        FileSystemInterface carpeta2 = new Folder("Carpeta 2");

        //ejemplo de error
        System.out.println("Intento meter Archivo 2 en archivo 1");
        try {
            archivo1.addFile(archivo2);
        } catch (OperationNotSupportedException e1) {
            System.out.println(e1.getMessage());
        }

        System.out.println("\nCreando y mostrando carpetas");
        //anda bien
        try {
            carpeta1.addFile(archivo1);
            carpeta1.addFile(archivo2);
            carpeta2.addFile(archivo3);
            carpeta2.addFile(carpeta1);

            System.out.println(carpeta2.getName() + "\tsize: " + carpeta2.getSize());
            for (FileSystemInterface file : carpeta2.getFiles()) {
                System.out.println("\t" + file.getName() + "\tsize: " + file.getSize() + " kb");
                if(file instanceof Folder){
                    for (FileSystemInterface subfile : file.getFiles()) {
                        System.out.println("\t\t" + subfile.getName() + "\tsize: " + subfile.getSize() + " kb");
                    }
                }
            }
        } catch (OperationNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        

    }
}
