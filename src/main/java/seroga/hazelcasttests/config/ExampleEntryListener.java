package seroga.hazelcasttests.config;

import com.hazelcast.core.EntryEvent;
import com.hazelcast.core.MapEvent;
import com.hazelcast.map.listener.EntryAddedListener;
import com.hazelcast.map.listener.EntryEvictedListener;
import com.hazelcast.map.listener.EntryRemovedListener;
import com.hazelcast.map.listener.MapClearedListener;
import com.hazelcast.map.listener.MapEvictedListener;

public class ExampleEntryListener implements EntryAddedListener<Object, Object>, EntryRemovedListener<Object, Object>,
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

}
