/**
 * Project name: DataBase4
 * Package name: ua.lviv.iot
 * Class: Application
 **/

package ua.lviv.iot;

import ua.lviv.iot.view.MyView;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final MyView view;

    public Application(MyView view) {
        this.view = view;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        view.show();
    }
}
