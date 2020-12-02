import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Employee {

  // fields
  StringBuilder name;
  String username;
  String password;
  String email;

  /**
   * Employee constructor that calls the username, email, and password methods to set Employee's
   * username, email, and password.
   *
   * @param name Employee's name
   * @param password Employee's password
   */
  public Employee(String name, String password) {
    this.name = new StringBuilder(name);
    if (checkName()) {
      setUsername(name);
      setEmail(name);
    } else {
      username = "default";
      email = "user@oracleacademy.Test";
    }
    if (isValidPassword(password)) {
      this.password = password;
    } else {
      this.password = "pw";
    }
  }

  /**
   * This method uses the employee's name to setup a unique username.
   *
   * @param name Employee's name
   */
  public void setUsername(String name) {
    String[] newName = name.split(" ");
    username = newName[0].toLowerCase().charAt(0) + newName[1].toLowerCase();
  }

  /**
   * This method checks for space in Employee name.
   *
   * @return true/false depending on if the name contains a space.
   */
  public boolean checkName() {
    return name.toString().contains(" ");
  }

  /**
   * This method uses the employee name to generate a unique email.
   *
   * @param name Employee name
   */
  public void setEmail(String name) {
    String[] newName = name.split(" ");
    email = newName[0].toLowerCase() + "." + newName[1].toLowerCase() + "@oracleacademy.Test";
  }

  /**
   * This method checks if the entered password meets the password requirements. The password
   * requires a lowercase letter, an uppercase letter, and a special character.
   *
   * @param password Employee's password
   * @return True/false depending on if password meets requirements
   */
  public boolean isValidPassword(String password) {
    String regex = "([a-z])([A-Z])(?=.*[!@#$%^&*])";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(password);
    return matcher.find();
  }

  /**
   * toString method that formats employee details using name, username, email, and password.
   *
   * @return Formatted string of employee details
   */
  @Override
  public String toString() {
    return "Employee Details"
        + "\nName : "
        + name
        + "\nUsername : "
        + username
        + "\nEmail : "
        + email
        + "\nInitial Password : "
        + password;
  }
}
