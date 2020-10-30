package com.example.sharding.config;

import com.google.common.base.Preconditions;
import io.seata.config.FileConfiguration;
import io.seata.rm.RMClient;
import io.seata.rm.datasource.DataSourceProxy;
import io.seata.tm.TMClient;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.apache.shardingsphere.spi.database.DatabaseType;
import org.apache.shardingsphere.transaction.core.ResourceDataSource;
import org.apache.shardingsphere.transaction.core.TransactionType;
import org.apache.shardingsphere.transaction.spi.ShardingTransactionManager;

public class SeataATShardingTransactionManager implements ShardingTransactionManager {

  private final FileConfiguration configuration = new FileConfiguration("seata.conf");

  private static final Map<String, DataSource> DATASOURCEMAP = new HashMap<>();

  @Override
  public void init(DatabaseType databaseType, Collection<ResourceDataSource> collection) {

    initSeataRpcClients();
    for (ResourceDataSource resourceDataSource : collection) {
      /*
      获取Shardingsphere的数据源的DataSource
      将原始的DataSource代理给seata的 DataSourceProxy
      这样就能使用SeatAT事务
       */
      DATASOURCEMAP.put(resourceDataSource.getOriginalName(),
          new DataSourceProxy(resourceDataSource.getDataSource()));
    }
  }

  private void initSeataRpcClients() {
    String applicationId = configuration.getConfig("client.application.id");
    Preconditions.checkNotNull(applicationId, "please config applicaton id within seata.conf file");
    String transactionServiceGroup = configuration
        .getConfig("client.transaction.service.group", "default");
    //初始化事务管理器
    TMClient.init(applicationId, transactionServiceGroup);
    //初始化资源管理器
    RMClient.init(applicationId, transactionServiceGroup);
  }

  @Override
  public TransactionType getTransactionType() {
    return null;
  }

  @Override
  public boolean isInTransaction() {
    return false;
  }

  @Override
  public Connection getConnection(String s) throws SQLException {
    return null;
  }

  @Override
  public void begin() {

  }

  @Override
  public void commit() {

  }

  @Override
  public void rollback() {

  }

  @Override
  public void close() throws Exception {

  }
}
