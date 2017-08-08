/**
 * Copyright 2017 Confluent Inc.
 **/

package io.confluent.ksql.util;

import io.confluent.ksql.metastore.DataSource;
import io.confluent.ksql.planner.plan.OutputNode;
import org.apache.kafka.streams.KafkaStreams;

import java.util.Objects;

public class PersistentQueryMetadata extends QueryMetadata {

  private final long id;
  private final DataSource.DataSourceType dataSourceType;

  public PersistentQueryMetadata(String statementString, KafkaStreams kafkaStreams,
                                 OutputNode outputNode, String executionPlan, long id,
                                 DataSource.DataSourceType dataSourceType) {
    super(statementString, kafkaStreams, outputNode, executionPlan);
    this.id = id;
    this.dataSourceType = dataSourceType;
  }

  public long getId() {
    return id;
  }

  public DataSource.DataSourceType getDataSourceType() {
    return dataSourceType;
  }

  @Override
  public boolean equals(Object o) {
    if (!(o instanceof PersistentQueryMetadata)) {
      return false;
    }

    PersistentQueryMetadata that = (PersistentQueryMetadata) o;

    return Objects.equals(this.id, that.id) && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, super.hashCode());
  }
}
