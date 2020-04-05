package seroga.hazelcasttests.config;

import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

  @Bean
  public Config hazelCastConfig() {

    CacheSimpleConfig cacheConfig = new CacheSimpleConfig();
    cacheConfig.setName("numbers");

    Config config = new Config();
    config.addCacheConfig(cacheConfig);
//        config.setInstanceName("hazelcast-instance")
//        config.addMapConfig(
//                new MapConfig()
//                        .setName("configuration")
//                        .setMaxSizeConfig(new MaxSizeConfig(200, MaxSizeConfig.MaxSizePolicy.FREE_HEAP_SIZE))
//                        .setEvictionPolicy(EvictionPolicy.LRU)
//                        .setTimeToLiveSeconds(-1));
    return config;
  }
}
