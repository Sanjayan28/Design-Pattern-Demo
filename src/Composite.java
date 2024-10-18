import java.util.ArrayList;
import java.util.List;

// Component
interface FileSystemEntity {
    void print(String indent);
}

// Leaf
class File implements FileSystemEntity {
    private String name;

    public File(String name) {
        this.name = name;
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + name);
    }
}

// Composite
class Directory implements FileSystemEntity {
    private String name;
    private List<FileSystemEntity> children;

    public Directory(String name) {
        this.name = name;
        this.children = new ArrayList<>();
    }

    public void add(FileSystemEntity entity) {
        children.add(entity);
    }

    @Override
    public void print(String indent) {
        System.out.println(indent + name);
        for (FileSystemEntity entity : children) {
            entity.print(indent + "   ");
        }
    }
}

// Client
public class Composite {
    public static void main(String[] args) {
        // Create files
        FileSystemEntity file1 = new File("file1.txt");
        FileSystemEntity file2 = new File("file2.txt");
        FileSystemEntity file3 = new File("file3.txt");

        // Create directories
        Directory dir1 = new Directory("Folder 1");
        Directory dir2 = new Directory("Folder 2");

        // Add files to directories
        dir1.add(file1);
        dir2.add(file2);
        dir2.add(file3);

        // Add directories to directories
        Directory root = new Directory("Root");
        root.add(dir1);
        root.add(dir2);

        // Print file system structure
        root.print("");
    }
}