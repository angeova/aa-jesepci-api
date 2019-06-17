package ci.gcorp.aajesepci;

import lombok.extern.java.Log;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Log
public class AaJesepciApi {
    public static void main(String[] args) {
        SpringApplication.run(AaJesepciApi.class, args);

        log.info("swagger_uri: http://localhost:8080/swagger-ui.html");
    }
}
