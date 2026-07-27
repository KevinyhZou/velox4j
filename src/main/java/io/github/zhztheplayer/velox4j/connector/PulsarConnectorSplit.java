/*
* Licensed to the Apache Software Foundation (ASF) under one or more
* contributor license agreements.  See the NOTICE file distributed with
* this work for additional information regarding copyright ownership.
* The ASF licenses this file to You under the Apache License, Version 2.0
* (the "License"); you may not use this file except in compliance with
* the License.  You may obtain a copy of the License at
*
*    http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package io.github.zhztheplayer.velox4j.connector;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.zhztheplayer.velox4j.serializable.ISerializable;

public class PulsarConnectorSplit extends ConnectorSplit {
  private final String serviceUrl;
  private final String topic;
  private final String subscriptionName;
  private final String format;
  private final List<TopicPartitionOffset> topicPartitions;

  @JsonCreator
  public PulsarConnectorSplit(
      @JsonProperty("connectorId") String connectorId,
      @JsonProperty("serviceUrl") String serviceUrl,
      @JsonProperty("topic") String topic,
      @JsonProperty("subscriptionName") String subscriptionName,
      @JsonProperty("format") String format,
      @JsonProperty("topicPartitions") List<TopicPartitionOffset> topicPartitions) {
    super(connectorId, 0, false);
    this.serviceUrl = serviceUrl;
    this.topic = topic;
    this.subscriptionName = subscriptionName;
    this.format = format;
    this.topicPartitions = topicPartitions == null ? Collections.emptyList() : topicPartitions;
  }

  public PulsarConnectorSplit(
      String connectorId, String serviceUrl, String topic, String subscriptionName, String format) {
    this(connectorId, serviceUrl, topic, subscriptionName, format, Collections.emptyList());
  }

  @JsonGetter("serviceUrl")
  public String getServiceUrl() {
    return serviceUrl;
  }

  @JsonGetter("topic")
  public String getTopic() {
    return topic;
  }

  @JsonGetter("subscriptionName")
  public String getSubscriptionName() {
    return subscriptionName;
  }

  @JsonGetter("format")
  public String getFormat() {
    return format;
  }

  @JsonGetter("topicPartitions")
  public List<TopicPartitionOffset> getTopicPartitions() {
    return topicPartitions;
  }

  public static class TopicPartitionOffset extends ISerializable {
    private final String partitionedTopic;
    private final String messageId;
    private final boolean startMessageIdInclusive;

    @JsonCreator
    public TopicPartitionOffset(
        @JsonProperty("partitionedTopic") String partitionedTopic,
        @JsonProperty("messageId") String messageId,
        @JsonProperty("startMessageIdInclusive") Boolean startMessageIdInclusive) {
      this.partitionedTopic = partitionedTopic;
      this.messageId = messageId == null ? "" : messageId;
      this.startMessageIdInclusive =
          startMessageIdInclusive == null ? true : startMessageIdInclusive;
    }

    @JsonGetter("partitionedTopic")
    public String getPartitionedTopic() {
      return partitionedTopic;
    }

    @JsonGetter("messageId")
    public String getMessageId() {
      return messageId;
    }

    @JsonGetter("startMessageIdInclusive")
    public boolean isStartMessageIdInclusive() {
      return startMessageIdInclusive;
    }
  }

  @Override
  @JsonIgnore
  public long getSplitWeight() {
    return super.getSplitWeight();
  }

  @Override
  @JsonIgnore
  public boolean isCacheable() {
    return super.isCacheable();
  }
}
