package seroga.hazelcasttests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class HazelcastTestsApplication {

  public static void main(String[] args) {
    SpringApplication.run(HazelcastTestsApplication.class, args);
  }

}
