
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private Date birthDate;
    private long phoneNumber;
    private char gender;

    public Person(String lastName,
                  String firstName,
                  String middleName,
                  String birthDateStr,
                  String phoneNumberStr,
                  char gender) throws ParseException {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.birthDate = new SimpleDateFormat("dd.MM.yyyy").parse(birthDateStr);
        this.phoneNumber = Long.parseLong(phoneNumberStr);
        this.gender = gender;
    }

    public String getFormattedData() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, middleName,
                new SimpleDateFormat("dd.MM.yyyy").format(birthDate),
                phoneNumber, gender);
    }
}