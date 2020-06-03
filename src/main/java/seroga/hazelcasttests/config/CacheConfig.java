package seroga.hazelcasttests.config;

import com.hazelcast.config.Config;
import com.hazelcast.config.EntryListenerConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
    return new HazelcastCacheManager(hazelcastInstance);
  }

  @Bean
  public Config hazelCastConfig() {

    NetworkConfig networkConfig = new NetworkConfig();
    networkConfig.setPortCount(5);
    networkConfig.getJoin().getMulticastConfig().setEnabled(false);
    networkConfig.getJoin().getTcpIpConfig().setEnabled(true).addMember("localhost:5701, localhost:5702");

    Config config = new Config();
    config.setProperty("hazelcast.logging.type", "slf4j");
    config.setNetworkConfig(networkConfig);

    MapConfig mapConfig = new MapConfig()
//        .setBackupCount(0)
//        .setAsyncBackupCount(1)
//        .setReadBackupData(true)
        .setName("numbers-map")
        .setTimeToLiveSeconds(60)
//        .setEvictionPolicy(EvictionPolicy.LRU)
//        .setMaxSizeConfig(new MaxSizeConfig(5, MaxSizePolicy.PER_NODE)) // todo: this not working???
        .addEntryListenerConfig(new EntryListenerConfig(new ExampleEntryListener(), false, false));
    config.addMapConfig(mapConfig);

    return config;
  }
}
