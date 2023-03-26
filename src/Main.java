import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filename = "file.txt";
        Scanner input = new Scanner(System.in);
        Counter counter = null;

        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            counter = (Counter)in.readObject();

            in.close();
            file.close();

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            counter = new Counter(0);
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            counter = new Counter(0);
        }


        System.out.println(counter.getValue());


       while (true){
           System.out.println("введите команду:");
       String command = input.next();

        if (command.equals("/inc")){
            counter.increment();
        }
        else if (command.equals("/stop")){
            counter.stop();
        } else if (command.equals("/reset")) {
            counter.reset();
        }
        else {
            System.out.println("неверрный ввод.\nдопустимые команды:\n\"/inc\"\n\"/stop\"\n\"/reset\"");
        }
       }


    }
}

