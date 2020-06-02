package seroga.hazelcasttests;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.hazelcast.HazelcastAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;

//@SpringBootApplication(exclude = {HazelcastAutoConfiguration.class})
@SpringBootApplication
@EnableCaching
public class HazelcastTestsApplication {

  public static void main(String[] args) {
    SpringApplication.run(HazelcastTestsApplication.class, args);
  }

}
