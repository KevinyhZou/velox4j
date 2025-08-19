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

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.zhztheplayer.velox4j.type.Type;

public class FileSystemColumnHandle extends HiveColumnHandle {

  @JsonCreator
  public FileSystemColumnHandle(
      @JsonProperty("fileSystemColumnHandleName") String name,
      @JsonProperty("columnType") ColumnType columnType,
      @JsonProperty("dataType") Type dataType,
      @JsonProperty("requiredSubFields") List<String> requiredSubfields) {
    super(name, columnType, dataType, null, requiredSubfields);
  }

  @JsonGetter("fileSystemColumnHandleName")
  @Override
  public String getName() {
    return super.getName();
  }

  @JsonGetter("columnType")
  @Override
  public ColumnType getColumnType() {
    return super.getColumnType();
  }

  @JsonGetter("dataType")
  @Override
  public Type getDataType() {
    return super.getDataType();
  }

  @JsonGetter("requiredSubfields")
  @Override
  public List<String> getRequiredSubfields() {
    return super.getRequiredSubfields();
  }
}
