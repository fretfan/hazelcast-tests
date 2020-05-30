package seroga.hazelcasttests.config;

import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.Config;
import com.hazelcast.config.EntryListenerConfig;
import com.hazelcast.config.EvictionPolicy;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MaxSizeConfig;
import com.hazelcast.config.MaxSizeConfig.MaxSizePolicy;
import com.hazelcast.config.NetworkConfig;
import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.MapEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.MapClearedListener;
import com.hazelcast.map.listener.MapEvictedListener;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public Config hazelCastConfig() {

//    MutableConfiguration<Object, Object> cacheConfig = new MutableConfiguration<>();
//cacheConfig.setExpiryPolicyFactory()
    CacheSimpleConfig cacheSimpleConfig = new CacheSimpleConfig();
    cacheSimpleConfig.setName("numbers");

    NetworkConfig networkConfig = new NetworkConfig();
    networkConfig.setPortCount(5);
    networkConfig.getJoin().getMulticastConfig().setEnabled(false);
    networkConfig.getJoin().getTcpIpConfig().setEnabled(true).addMember("localhost:5701, localhost:5702");

    Config config = new Config();
    config.setNetworkConfig(networkConfig);
    config.addCacheConfig(cacheSimpleConfig);

    MapConfig mapConfig = new MapConfig()
        .setName("numbers2")
        .setTimeToLiveSeconds(60)
        .addEntryListenerConfig(new EntryListenerConfig(new Num2Listener(), true, false))
        .setMaxSizeConfig(new MaxSizeConfig(4, MaxSizePolicy.PER_NODE)); // todo: this not working???
    config.addMapConfig(mapConfig);

    // todo JCache with type safety
    return config;
  }

  static class Num2Listener implements EntryAddedListener<Object, Object>, EntryRemovedListener<Object, Object>,
      EntryEvictedListener<Object, Object>, MapEvictedListener, MapClearedListener {

    //  static class Num2Listener implements EntryListener<Object, Object> {
    @Override
    public void entryAdded(EntryEvent<Object, Object> event) {
      System.out.println("###ADDED: " + event);
    }

    @Override
    public void entryRemoved(EntryEvent<Object, Object> event) {
      System.out.println("###REMOVED: " + event
      );
    }

    @Override
    public void entryEvicted(EntryEvent<Object, Object> event) {
      System.out.println("###EVICTED: " + event);
    }

    @Override
    public void mapEvicted(MapEvent event) {
      System.out.println("#mapEVICTED: " + event);
    }

    @Override
    public void mapCleared(MapEvent event) {
      System.out.println("#mapCleared: " + event);
    }

//    @Override
//    public void entryUpdated(EntryEvent<Object, Object> event) {
//      System.out.println("#UPDATED: " + event);
//    }
  }
}
