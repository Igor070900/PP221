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

//      Car car1 = new Car("BMW", 2023);
//      Car car2 = new Car("Mercedes", 2020);
//      Car car3 = new Car("Audi", 2020);
//      Car car4 = new Car("Volvo", 2002);
//
//      userService.add(new User("Ivan", "Ivanov", "user1@mail.ru", car1));
//      userService.add(new User("Semen", "Semenov", "user2@mail.ru", car2));
//      userService.add(new User("Petr", "Petrov", "user3@mail.ru", car3));
//      userService.add(new User("Mariya", "Semenova", "user4@mail.ru", car4));
//
//      List<User> users = userService.listUsers();
//      for (User user : users) {
//         System.out.println("Id = "+user.getId());
//         System.out.println("First Name = "+user.getFirstName());
//         System.out.println("Last Name = "+user.getLastName());
//         System.out.println("Email = "+user.getEmail());
//         System.out.println();
//      }

      String CarToGet = "BMW";
      User user = userService.getUserWithCar(CarToGet);
      if (user != null) {
         System.out.println("Нашелся редиска :(");
         System.out.println("Его данные:");
         System.out.printf("Имя: %s\n", user.getFirstName());
         System.out.printf("Фамилия: %s\n", user.getLastName());
         System.out.printf("Email: %s\n", user.getEmail());
         System.out.printf("Автомобиль: %s %s года", user.getCarUser().getModel(), user.getCarUser().getSeries());
      } else {
         System.out.println("Автомобиль бесхозный, можно забирать");
      }

      context.close();
   }
}
