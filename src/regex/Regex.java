package regex;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
    public static final String consumerName = "[\\w\\s]{2,20}";
    public static final String consumerDateOfBirth = "[\\d]{2}/[\\d]{2}/[\\d]{4}";
    public static final String consumerPhoneNumber = "[\\d]{10}";
    public static final String computerName = "[\\w]{2,10}";
    public static final String accountUsername = "[\\w\\d ]{8,12}";
    public static final String accountPassword = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{8,12}$";//Minimum eight characters, at least one uppercase letter, one lowercase letter and one number:


    String date ;
    Pattern pattern = Pattern.compile(Regex.consumerDateOfBirth);
    Matcher matcher = pattern.matcher(date);
    boolean match = matcher.matches();


}
