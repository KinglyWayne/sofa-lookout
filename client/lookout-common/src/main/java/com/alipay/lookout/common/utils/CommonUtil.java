/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.lookout.common.utils;

import com.alipay.lookout.api.Id;
import com.alipay.lookout.api.Tag;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.ThreadFactory;

/**
 * CommonUtil
 *
 * @author yangguanchao
 * @since 2018/06/19
 */
public class CommonUtil {

    /**
     * Convert a dimensional metric id {@link Id} to  a hierarchical metric name.
     * 转成 ${name}.${key1}-${value1}.${key2}-${value2}... 的格式
     *
     * @param id a dimensional metric id
     * @return hierarchical metric name
     */
    public static String toMetricName(Id id) {
        StringBuilder buf = new StringBuilder();
        buf.append(id.name());
        for (Tag t : id.tags()) {
            buf.append('.').append(t.key()).append('-').append(t.value());
        }
        return buf.toString();
    }

    public static ThreadFactory getNamedThreadFactory(String ThreadFactoryName) {
        //使用guava包中工具类；
        return new ThreadFactoryBuilder().setNameFormat(ThreadFactoryName + "-%d").build();
    }
}
