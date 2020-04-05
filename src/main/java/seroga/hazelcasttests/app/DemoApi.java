package seroga.hazelcasttests.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

  @Autowired
  private DemoService demoService;

  @GetMapping("/get/{num}")
  public Integer getNumber(@PathVariable Integer num) {
    return demoService.getNumber(num);
  }

  @GetMapping("/clear")
  public String clear() {
    return demoService.clearCache();
  }
}
