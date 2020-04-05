package seroga.hazelcasttests.app;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Cacheable("numbers")
  public Integer getNumber(Integer num) {
    sleep(3000);
    return num;
  }

  @CacheEvict(value = "numbers", allEntries = true)
  public String clearCache() {
    System.out.println("Cache cleared");
    return "Cache cleared";
  }

  private void sleep(Integer millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}
