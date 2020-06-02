package seroga.hazelcasttests.config;

import java.util.concurrent.TimeUnit;
import javax.cache.configuration.Factory;
import javax.cache.event.CacheEntryCreatedListener;
import javax.cache.event.CacheEntryExpiredListener;
import javax.cache.event.CacheEntryListener;
import javax.cache.event.CacheEntryListenerException;
import javax.cache.expiry.Duration;
import javax.cache.expiry.ExpiryPolicy;

public class MyExpiryPolicyFactory implements Factory<ExpiryPolicy> {

  @Override
  public ExpiryPolicy create() {
    return new MyExpPolicy();
  }

  static class MyExpPolicy implements ExpiryPolicy {

    @Override
    public Duration getExpiryForCreation() {
      return new Duration(TimeUnit.SECONDS, 15);
    }

    @Override
    public Duration getExpiryForAccess() {
      return null;
    }

    @Override
    public Duration getExpiryForUpdate() {
      return null;
    }
  }
}
