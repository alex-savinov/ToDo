package todo.model.service;
import java.io.*;

public class FileHandler implements Writable{
    private String filePath = "src/Todo/model/todo.txt";
    @Override
    public void save(Serializable serializable){
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(filePath))){
            objectOutputStream.writeObject(serializable);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public Object read() throws IOException, ClassNotFoundException {
        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
        return objectInputStream.readObject();
    }

    public void setPath(String filePath){
        this.filePath = filePath;
    }
}