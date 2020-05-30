package seroga.hazelcasttests.app;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

  @Autowired
  private HazelcastInstance hz;

  public void putNum(Integer num) {
    IMap<Object, Object> numbers2 = hz.getMap("numbers2");
    numbers2.putIfAbsent(num, num);
  }

  public Object getNumber2(Integer num) {
    IMap<Object, Object> numbers2 = hz.getMap("numbers2");
    Object numFetched = numbers2.get(num);
    System.out.println(numFetched);
    return numFetched;
  }

  public String clearAll() {
    System.out.println("Cache cleared");
    IMap<Object, Object> numbers2 = hz.getMap("numbers2");
    numbers2.evictAll();
    return "Cache cleared";
  }

  public String deleteNum(Integer num) {
    System.out.println("deleted " + num);
    IMap<Object, Object> numbers2 = hz.getMap("numbers2");
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
