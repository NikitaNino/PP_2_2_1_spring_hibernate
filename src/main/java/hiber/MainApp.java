package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User Anton = new User("Антон", "Антонович", "AntonA@mail.ru");
      User Nikita =  new User("Никита", "Никитович", "NikitaN2@mail.ru");
      User Oleg = new User("Олег", "Олегович", "OlegO@mail.ru");
      User Denis = new User("Денис", "Денисович", "DenisD@mail.ru");

      Anton.setCar(new Car("LADA", 2114));
      Nikita.setCar(new Car("Opel", 5));
      Oleg.setCar(new Car("Reno", 703));
      Denis.setCar(new Car("KIA", 300));

      userService.add(Anton);
      userService.add(Nikita);
      userService.add(Oleg);
      userService.add(Denis);

//      Car Lada = new Car("LADA", 2114);
//      Car Opel = new Car("Opel", 5);
//      Car Reno = new Car("Reno", 703);
//      Car Kia = new Car("KIA", 300);

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }
//
//      userService.add(Anton.getCar(Lada).getUser(Anton));
//      userService.add(Nikita.getCar(Opel).getUser(Nikita));
//      userService.add(Oleg.getCar(Reno).getUser(Oleg));
//      userService.add(Denis.getCar(Kia).getUser(Denis));
//
      System.out.println(userService.listUsers());
      System.out.println(userService.getUserByCar("Reno", 703));

      context.close();
   }
}
