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
package io.github.zhztheplayer.velox4j.plan;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.github.zhztheplayer.velox4j.expression.FieldAccessTypedExpr;
import io.github.zhztheplayer.velox4j.serializable.ISerializable;
import io.github.zhztheplayer.velox4j.window.WindowFunction;

public class TimeWindowNode extends WindowNode {

  private int type;
  private WindowParameters parameters;

  @JsonCreator
  public TimeWindowNode(
      @JsonProperty("id") String id,
      @JsonProperty("partitionKeys") List<FieldAccessTypedExpr> partitionKeys,
      @JsonProperty("names") List<String> windowColumnNames,
      @JsonProperty("functions") List<WindowFunction> windowFunctions,
      @JsonProperty("sources") List<PlanNode> sources,
      @JsonProperty("type") int type,
      @JsonProperty("parameters") WindowParameters parameters) {
    super(
        id,
        partitionKeys,
        new ArrayList<>(),
        new ArrayList<>(),
        windowColumnNames,
        windowFunctions,
        false,
        sources);
    this.type = type;
    this.parameters = parameters;
  }

  @JsonProperty("type")
  public int getType() {
    return type;
  }

  @JsonProperty("parameters")
  public WindowParameters getWindowParameters() {
    return parameters;
  }

  public static class WindowParameters extends ISerializable {
    private long windowSize;
    private long offset;
    private long slidingSize;
    private long gapSize;
    private boolean isEventTime;
    private int timeFieldIndex;

    @JsonCreator
    public WindowParameters(
        @JsonProperty("windowSize") long windowSize,
        @JsonProperty("offset") long offset,
        @JsonProperty("slidingSize") long slidingSize,
        @JsonProperty("gapSize") long gapSize,
        @JsonProperty("isEventTime") boolean isEventTime,
        @JsonProperty("timeFieldIndex") int timeFieldIndex) {
      this.windowSize = windowSize;
      this.offset = offset;
      this.slidingSize = slidingSize;
      this.gapSize = gapSize;
      this.isEventTime = isEventTime;
      this.timeFieldIndex = timeFieldIndex;
    }

    @JsonProperty("windowSize")
    public long getWindowSize() {
      return windowSize;
    }

    @JsonProperty("offset")
    public long getOffset() {
      return offset;
    }

    @JsonProperty("slidingSize")
    public long getSlidingSize() {
      return slidingSize;
    }

    @JsonProperty("gapSize")
    public long getGapSize() {
      return gapSize;
    }

    @JsonProperty("isEventTime")
    public boolean getIsEventTime() {
      return isEventTime;
    }

    @JsonProperty("timeFieldIndex")
    public int getTimeFieldIndex() {
      return timeFieldIndex;
    }
  }
}
