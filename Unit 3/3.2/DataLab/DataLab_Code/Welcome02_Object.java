import core.data.*;

public class Welcome02_Object {
   public static void main(String[] args) {
      String id1 = "KATL";
      DataSource ds1 = DataSource.connect("https://forecast.weather.gov/xml/current_obs/" + id1 + ".xml");
      ds1.setCacheTimeout(15 * 60);
      ds1.load();
      // ds1.printUsageString();

      Observation ob1 = ds1.fetch("Observation", "weather", "temp_f", "wind_degrees");
      System.out.println(id1 + ": " + ob1);

      String id2 = "KSAV";
      DataSource ds2 = DataSource.connect("https://forecast.weather.gov/xml/current_obs/" + id2 + ".xml");
      ds2.setCacheTimeout(15 * 60);
      ds2.load();

      Observation ob2 = ds2.fetch("Observation", "weather", "temp_f", "wind_degrees");
      System.out.println(id2 + ": " + ob2);

      if (ob1.colderThan(ob2)) {
         System.out.println("Colder at " + id1);
      } else {
         System.out.println("Colder at " + id2);
      }

      String id3 = "KSAN";
      DataSource ds3 = DataSource.connect("https://forecast.weather.gov/xml/current_obs/" + id3 + ".xml");
      ds3.setCacheTimeout(15 * 60);
      ds3.load();

      Observation ob3 = ds3.fetch("Observation", "weather", "temp_f", "wind_degrees");
      System.out.println(id3 + ": " + ob3);

      // Colder: Area 1
      if (ob1.colderThan(ob2)) {

         // Coldest: Area 1
         if (ob1.colderThan(ob3)) {
            System.out.println(id1 + " is the coldest at " + ob1.temp);
         }

         // Coldest: Area 3
         else {
            System.out.println(id3 + " is the coldest at " + ob3.temp);
         }
      }

      // Colder: Area 2
      else {

         // Coldest: Area 3
         if (ob2.colderThan(ob3)) {
            System.out.println(id3 + " is the coldest at " + ob3.temp);
         }

         // Coldest: Area 2
         else {
            System.out.println(id2 + " is the coldest at " + ob2.temp);
         }
      }

   }
}

/* Represents a weather observation */
class Observation {
   float temp; // in fahrenheit
   int windDir; // in degrees
   String description;

   Observation(String description, float temp, int windDir) {
      this.description = description;
      this.temp = temp;
      this.windDir = windDir;
   }

   /* determine if the temperature of this observation is colder than 'that's */
   public boolean colderThan(Observation that) {
      return this.temp < that.temp;
   }

   /* produce a string describing this observation */
   public String toString() {
      return (temp + " degrees; " + description + " (wind: " + windDir + " degrees)");
   }
}