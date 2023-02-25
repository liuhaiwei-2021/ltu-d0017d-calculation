/*
* This program calculates how much money your solar cells generate * per day based on the hours of susnshine.
* Step 1. Declare all constants
* Step 2. Declare all varibles hour, minutes, month, day
* Step 3. Enter the date
* Step 4. Validate the date
* Step 5. Enter the time of sunrise
* Step 6. Validate the time of sunrise
* Step 7. Enter the time of sunset
* Step 8. Validate the time of 
* Step 9. Calculate the sun hours
* Step 10.Calculate the production 
* Production (Wh) = Solar radiation (Wh / m2 / hour) x efficiency x 
* surface (m2) x hours of sunshine
* Step 11. Calculate money Money = Production / 1000 * price
*@Haiwei， haiweiliu
*/

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    // Declare all constants
    final double SOLAR_RADIATION = 166.0;
    final double THERMAL_EFFICIENCY = 0.2;
    final double PRICE = 0.9;
    int JUNE = 6;
    int JULY = 7;
    int DAY_MIN = 1;
    int DAYS_IN_JUNE_MAX = 30;
    int DAYS_IN_JULY_MAX = 31;
    int HOUR_MAX = 24;
    int HOUR_MIN = 0;
    int MINUTE_MAX = 59;
    int MINUTE_MIN = 0;
    int MINUTES2HOUR = 60;
    final double PANEL_HEIGHT = 1.0;
    final double PANEL_WIDTH = 1.7;
    int PANEL_AMOUNT = 26;
    int W2KWH = 1000;

    // Variables
    int day = 0;
    int month = 0;
    double sunriseHours = 0.0;
    double sunriseMinutes = 0.0;
    double finalSunriseHours = 0.0;
    double sunsetHours = 0.0;
    double sunsetMinutes = 0.0;
    double finalSunsetHours = 0.0;
    double sunshineHours = 0.0;

    // Enter the date
    System.out.print("Enter today's date [mm-dd]");
    Scanner userInputDate = new Scanner(System.in);
    userInputDate.useDelimiter("[-/\\s]");
    month = userInputDate.nextInt();
    day = userInputDate.nextInt();

    // Validate date
    if ((month != JUNE) && (month != JULY)) {
      System.out.print("wrong date");
      System.exit(0);
    } else if ((month == JUNE) && (day < DAY_MIN)) {
      System.out.print("wrong date");
      System.exit(0);
    } else if ((month == JUNE) && (day > DAYS_IN_JUNE_MAX)) {
      System.out.print("wrong date");
      System.exit(0);
    } else if ((month == JULY) && (day < DAY_MIN)) {
      System.out.print("wrong date");
      System.exit(0);
    } else if ((month == JULY) && (day > DAYS_IN_JULY_MAX)) {
      System.out.print("wrong date");
      System.exit(0);
    } else {
      System.out.print("Enter the time of sunrise [hh: mm]");
      Scanner userInputSunrise = new Scanner(System.in);
      userInputSunrise.useDelimiter("[[:|/|\\s]+]");
      sunriseHours = userInputSunrise.nextDouble();
      sunriseMinutes = userInputSunrise.nextDouble();
    }

    // Rounding scale
    int noOfDecimals = 2;
    double scale = 0;
    scale = Math.pow(10, noOfDecimals);

    // Validate sunrise time
    if ((sunriseHours >= HOUR_MIN) && (sunriseHours <= HOUR_MAX) && (sunriseMinutes >= MINUTE_MIN)
        && (sunriseMinutes <= MINUTE_MAX)) {
      finalSunriseHours = Math.round((sunriseHours + sunriseMinutes / MINUTES2HOUR) * scale) / scale;

      System.out.print("Enter the time of sunset [hh: mm]");
      Scanner userInputSunset = new Scanner(System.in);
      userInputSunset.useDelimiter("[[:|/|\\s]+]");
      sunsetHours = userInputSunset.nextDouble();
      sunsetMinutes = userInputSunset.nextDouble();
    } else {
      System.out.print("wrong time");
      System.exit(0);
    }

    // Validate sunset time
    if ((sunsetHours >= HOUR_MIN) && (sunsetHours <= HOUR_MAX) && (sunsetMinutes >= MINUTE_MIN)
        && (sunsetMinutes <= MINUTE_MAX)) {
      finalSunsetHours = Math.round((sunsetHours + sunsetMinutes / MINUTES2HOUR) * scale) / scale;

    } else {
      System.out.print("wrong time");
      System.exit(0);
    }

    // Validate sunrise is before sunset or not
    if (finalSunriseHours > finalSunsetHours) {

      System.out.print("Sunrise is after sunset");
      System.exit(0);
    } else {
      sunshineHours = Math.round((finalSunsetHours - finalSunriseHours) * scale) / scale;
    }

    // Calculate production, eq 1 above
    double production = 0.0;
    production = Math.round(SOLAR_RADIATION * THERMAL_EFFICIENCY * PANEL_HEIGHT * PANEL_WIDTH * PANEL_AMOUNT
        * sunshineHours / W2KWH * scale) / scale;

    // Calculate money eq 2 above
    double money = 0.0;
    money = Math.round(production * PRICE * scale) / scale;

    // print formated data
    System.out.printf("%-40s %n", "=========================================");
    System.out.printf("%-10s %-4s %-5s %n", "Sun hours:", sunshineHours, "hours");
    System.out.printf("%-10s %-2s %-1s %-1s %-4s  %-4s %-10s  %4s %n", "The production on ", day, "/", month, "is: ",
        production, "kWH to a value of: SEK", money);

  }
}
