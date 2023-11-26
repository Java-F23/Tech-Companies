import java.io.*;
import java.util.ArrayList;
public class CsvSerializer<T> {

    // Write a list of objects to the same serialized CSV file
    public void writeCsv(ArrayList<T> objects, String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            for (T obj : objects) {
                oos.writeObject(obj);
            }
            System.out.println("Objects written to " + fileName);
        } catch (IOException e) {
            ErrorMessage.show("Failed to write to file");
        }
    }

    // Read a list of objects from the same serialized CSV file
    public ArrayList<T> readCsv(String fileName) {
        ArrayList<T> objects = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            while (true) {
                try {
                    T obj = (T) ois.readObject();
                    objects.add(obj);
                } catch (EOFException e) {
                    // End of file reached
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            ErrorMessage.show("Failed to read from file");
        }
        return objects;
    }
}