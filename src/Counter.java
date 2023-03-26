import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Counter implements Serializable {
    //поля
    private int value;

    //конструктор
    Counter (int value){
        this.value = value;
    }
    //методы

    int getValue(){
        return value;
    }

    void increment (){
        value++;
        System.out.println("текущее значение счетчика:" + value);
    }

    void stop (){
        System.out.println(value+ "\nЗавершаю работу");


        String filename = "file.txt";

        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(this);

            out.close();
            file.close();

            System.out.println("данные были сохранены");

        }

        catch(IOException ex)
        {
            System.out.println("данные не были сохранены. ошибка "+ ex.getMessage());
        }
        System.exit(0);
        
    }

    void reset (){
        value =0;
        System.out.println("текущее значение счетчика:" + value);
    }

}
