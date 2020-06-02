package seroga.hazelcasttests.app;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Autowired
  HazelcastInstance hz;

//  @Cacheable(value = "asd", cacheManager = "cacheManager")
  @Cacheable(value = "asd")
  public String getAsd(String key, List<String> list) {
    sleep(3000);
    return key;
  }

//  @CacheEvict(value = "asd", allEntries = true, cacheManager = "cacheManager")
  @CacheEvict(value = "asd", allEntries = true)
  public String removeAsd() {
    return "Removed";
  }

  public IMap<Object, Object> getAll() {
    IMap<Object, Object> numbers2 = hz.getMap("numbers-map");
    System.out.println("SIZE:" + numbers2.size());
    return numbers2;
  }

  public void putNum(Integer num) {
    IMap<Object, Object> numbers2 = hz.getMap("numbers-map");
    numbers2.putIfAbsent(num, num);
  }

  public String clearAll() {
    System.out.println("Cache cleared");
    IMap<Object, Object> numbers2 = hz.getMap("numbers-map");
    numbers2.evictAll();
    return "Cache cleared";
  }

  public String deleteNum(Integer num) {
    System.out.println("deleted " + num);
    IMap<Object, Object> numbers2 = hz.getMap("numbers-map");
    numbers2.delete(num);
    return "deleted " + num;
  }

  private void sleep(Integer millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException ex) {
      Thread.currentThread().interrupt();
    }
  }
}
