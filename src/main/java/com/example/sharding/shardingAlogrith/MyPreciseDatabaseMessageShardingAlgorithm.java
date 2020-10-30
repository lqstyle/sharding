package com.example.sharding.shardingAlogrith;

import java.util.Collection;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

public class MyPreciseDatabaseMessageShardingAlgorithm implements PreciseShardingAlgorithm<Long> {

  private String genderToTableSuffix(Long code) {
    return String.valueOf(Math.abs(code.hashCode()) % 2);
  }

  @Override
  public String doSharding(Collection<String> availableTargetNames,
      PreciseShardingValue<Long> shardingValue) {

    String suffix = genderToTableSuffix(shardingValue.getValue());
    for (String each : availableTargetNames) {
      if (each.endsWith(suffix)) {
        return each;
      }
    }
    throw new IllegalArgumentException();
  }
}
