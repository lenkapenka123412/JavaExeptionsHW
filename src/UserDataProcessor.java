import java.text.ParseException;
import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class UserDataProcessor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Введите данные (в формате: Фамилия Имя Отчество, дата_рождения в формате dd.MM.yyyy, номер_телефона, пол):");
            String input = scanner.nextLine();

            String[] data = input.split(" ");
            if (data.length != 6) {
                throw new DataFormatException("Неверное количество данных. Введите все данные в требуемом формате.");
            }

            String lastName = data[0];
            String firstName = data[1];
            String middleName = data[2];
            String birthDateStr = data[3];
            String phoneNumberStr = data[4];
            char gender = data[5].charAt(0);

            Person person = new Person(lastName, firstName, middleName, birthDateStr, phoneNumberStr, gender);

            String filename = lastName + ".txt";
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
                writer.write(person.getFormattedData());
                writer.newLine();
                System.out.println("Данные успешно записаны в файл: " + filename);
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (DataFormatException | ParseException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

