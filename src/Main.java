import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Saver saver = new Saver();
        Counter counter = saver.load("file.txt");

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

