import java.io.*;

public class Saver  {


    Counter load (String filename){
        Counter counter = null;
        try
        {
            // извлечение данных из файла
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // метод десериализации
            counter = (Counter)in.readObject();

            in.close();
            file.close();

        }

        catch(IOException ex)
        {
            System.out.println("IOException is caught");
            counter = new Counter(0, filename);
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            counter = new Counter(0, filename);
        }
        return counter;
    }

    void save (Counter counter, String filename){

        try
        {
            //сохрение в файл
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // метод сериализации
            out.writeObject(counter);

            out.close();
            file.close();

            System.out.println("данные были сохранены");

        }

        catch(IOException ex)
        {
            System.out.println("данные не были сохранены. ошибка "+ ex.getMessage());
            ex.printStackTrace();
        }

    }
}
