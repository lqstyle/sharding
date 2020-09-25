package com.example.sharding;

import org.apache.shardingsphere.opentracing.ShardingTracer;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ShardingApplication {
  public static void main(String[] args) {
    ShardingTracer.init(new SkywalkingTracer());
    SpringApplication.run(ShardingApplication.class, args);
  }


}
