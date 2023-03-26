import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Counter implements Serializable {
    //поля
    private int value;
    String filename;

    //конструктор
    Counter (int value, String filename){
        this.value = value;
        this.filename =filename;
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
        Saver saver = new Saver();
        saver.save(this,filename);


        System.exit(0);
        
    }

    void reset (){
        value =0;
        System.out.println("текущее значение счетчика:" + value);
    }

}
