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

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.zhztheplayer.velox4j.type.RowType;

public class FileSystemIndexTableHandle extends ConnectorTableHandle {

  private String connectorId;
  private String tableName;
  private RowType tableSchema;
  private int[] keyFields;
  private boolean asyncLookup;
  private Map<String, String> tableParameters;

  @JsonCreator
  public FileSystemIndexTableHandle(
      @JsonProperty("connectorId") String connectorId,
      @JsonProperty("tableName") String tableName,
      @JsonProperty("tableSchema") RowType tableSchema,
      @JsonProperty("keyFields") int[] keyFields,
      @JsonProperty("asyncLookup") boolean asyncLookup,
      @JsonProperty("tableParameters") Map<String, String> tableParameters) {
    super(connectorId);
    this.connectorId = connectorId;
    this.tableName = tableName;
    this.tableSchema = tableSchema;
    this.keyFields = keyFields;
    this.asyncLookup = asyncLookup;
    this.tableParameters = tableParameters;
  }

  @JsonProperty("connectorId")
  public String getConnectorId() {
    return connectorId;
  }

  @JsonProperty("tableName")
  public String getTableName() {
    return tableName;
  }

  @JsonProperty("tableSchema")
  public RowType getTableSchema() {
    return tableSchema;
  }

  @JsonProperty("tableParameters")
  public Map<String, String> getTableParameters() {
    return tableParameters;
  }

  @JsonProperty("keyFields")
  public int[] getKeyFields() {
    return keyFields;
  }

  @JsonProperty("asyncLookup")
  public boolean getAsyncLookup() {
    return asyncLookup;
  }
}
