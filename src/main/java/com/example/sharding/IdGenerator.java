package com.example.sharding;

import java.util.Properties;
import org.apache.shardingsphere.spi.keygen.ShardingKeyGenerator;

public class IdGenerator  implements ShardingKeyGenerator {

  @Override
  public Comparable<?> generateKey() {
    return null;
  }

  @Override
  public String getType() {
    return null;
  }

  @Override
  public Properties getProperties() {
    return null;
  }

  @Override
  public void setProperties(Properties properties) {

  }
}
