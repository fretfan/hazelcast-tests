package seroga.hazelcasttests.config;

import javax.cache.configuration.Factory;
import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryExpiredListener;
import javax.cache.event.CacheEntryListener;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.event.CacheEntryRemovedListener;

public class MyEntryListenerFactory implements Factory<CacheEntryListener> {

  @Override
  public CacheEntryListener create() {
    return new MyEntryListener();
  }

  static class MyEntryListener implements
      CacheEntryCreatedListener,
      CacheEntryExpiredListener,
      CacheEntryRemovedListener,
      CacheEntryListener {

    @Override
    public void onCreated(Iterable iterable) throws CacheEntryListenerException {
      System.out.println("CREATED");
    }

    @Override
    public void onExpired(Iterable iterable) throws CacheEntryListenerException {
      System.out.println("EXPIRED");
    }

    @Override
    public void onRemoved(Iterable iterable) throws CacheEntryListenerException {
      System.out.println("REMOVED");
    }
  }
}
