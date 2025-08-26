package live.b.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BLiveApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(BLiveApiApplication.class, args);
        System.out.println("Main ok");
    }

}
