package seroga.hazelcasttests.app;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoApi {

    @GetMapping("/get/{num}")
    public Integer getNumber(@PathVariable Integer num) {
        return num;
    }

    @GetMapping("/clear")
    public String clear() {
        return "Cache cleared";
    }
}
