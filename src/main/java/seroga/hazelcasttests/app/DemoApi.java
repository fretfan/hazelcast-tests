package seroga.hazelcasttests.app;

import com.hazelcast.core.IMap;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

  @Autowired
  private DemoService demoService;

  @GetMapping("/asd/{key}")
  public String getAsd(@PathVariable String key) {
    return demoService.getAsd(key, Arrays.asList("asd", "das", "dasf"));
  }

  @GetMapping("/asd/remove")
  public String removeAsd() {
    return demoService.removeAsd();
  }

  @GetMapping("/getAll")
  public IMap<Object, Object> getAll() {
    return demoService.getAll();
  }

  @GetMapping("/put/{num}")
  public void putIntoMap(@PathVariable Integer num) {
    demoService.putNum(num);
  }

  @GetMapping("/clear")
  public String clearAll() {
    return demoService.clearAll();
  }

  @GetMapping("/delete/{num}")
  public String delete(@PathVariable Integer num) {
    return demoService.deleteNum(num);
  }
}
