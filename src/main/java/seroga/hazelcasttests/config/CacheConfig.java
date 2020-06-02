package seroga.hazelcasttests.config;

import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.CacheSimpleConfig.ExpiryPolicyFactoryConfig;
import com.hazelcast.config.CacheSimpleConfig.ExpiryPolicyFactoryConfig.DurationConfig;
import com.hazelcast.config.CacheSimpleConfig.ExpiryPolicyFactoryConfig.TimedExpiryPolicyFactoryConfig;
import com.hazelcast.config.CacheSimpleConfig.ExpiryPolicyFactoryConfig.TimedExpiryPolicyFactoryConfig.ExpiryPolicyType;
import com.hazelcast.config.CacheSimpleEntryListenerConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.EntryListenerConfig;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.MapClearedListener;
import com.hazelcast.map.listener.MapEvictedListener;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import java.util.concurrent.TimeUnit;
import javax.cache.configuration.MutableConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cache.CacheManagerCustomizers;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//@EnableCaching
public class CacheConfig {

//  @Bean
//  public CacheManager cacheManager(HazelcastInstance hazelcastInstance) {
//    HazelcastCacheManager cacheManager = new HazelcastCacheManager(hazelcastInstance);
//    System.out.println(cacheManager.getHazelcastInstance().getName());
//    return cacheManager;
//  }

//  @Bean
//  public HazelcastInstance hazelcastInstance() {
//    return Hazelcast.newHazelcastInstance(hazelCastConfig());
//  }

//  @Bean
  /*
  public Config hazelCastConfig() {

    MutableConfiguration<Object, Object> cacheConfig = new MutableConfiguration<>();

    NetworkConfig networkConfig = new NetworkConfig();
    networkConfig.setPortCount(5);
    networkConfig.getJoin().getMulticastConfig().setEnabled(false);
    networkConfig.getJoin().getTcpIpConfig().setEnabled(true).addMember("localhost:5701, localhost:5702");

    Config config = new Config();
    config.setProperty("hazelcast.logging.type", "slf4j");
    config.setNetworkConfig(networkConfig);

    MapConfig mapConfig = new MapConfig()
        .setName("numbers-map")
        .setTimeToLiveSeconds(10)
        .addEntryListenerConfig(new EntryListenerConfig(new ExampleEntryListener(), true, false));
//        .setMaxSizeConfig(new MaxSizeConfig(1000, MaxSizePolicy.)); // todo: this not working???
    config.addMapConfig(mapConfig);
//
//    CacheSimpleEntryListenerConfig cacheSimpleEntryListenerConfig = new CacheSimpleEntryListenerConfig();
//    cacheSimpleEntryListenerConfig.setCacheEntryListenerFactory("asd");

//    ExpiryPolicyFactoryConfig conf2 = new ExpiryPolicyFactoryConfig();
//    conf2.getTimedExpiryPolicyFactoryConfig();
//   TODO: try wiring MyExpiryPolicyFactory + MyEntryListenerFactory into config. Enable Cachemanager bean. Try 2 nodes
    CacheSimpleConfig conf = new CacheSimpleConfig();
    conf.setName("asd");
    conf.setExpiryPolicyFactoryConfig(
        new ExpiryPolicyFactoryConfig("seroga.hazelcasttests.config.MyExpiryPolicyFactory"));
    config.addCacheConfig(conf);
    CacheSimpleEntryListenerConfig cacheSimpleEntryListenerConfig = new CacheSimpleEntryListenerConfig();
    cacheSimpleEntryListenerConfig.setCacheEntryListenerFactory("seroga.hazelcasttests.config.MyEntryListenerFactory");
    conf.addEntryListenerConfig(cacheSimpleEntryListenerConfig);

    System.out.println(config.getCacheConfigs());

    return config;
  }
*/
}
