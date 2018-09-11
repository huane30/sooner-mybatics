/*
 * Copyright (c) 2011-2020, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.sooner.mybatics.core.conditions.update;

import com.sooner.mybatics.core.conditions.AbstractLambdaWrapper;
import com.sooner.mybatics.core.conditions.segments.MergeSegments;
import com.sooner.mybatics.core.toolkit.CollectionUtils;
import com.sooner.mybatics.core.toolkit.StringPool;
import com.sooner.mybatics.core.toolkit.sql.SqlUtils;
import com.sooner.mybatics.core.toolkit.support.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import static java.util.stream.Collectors.joining;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: Lambda 更新封装
 */
@SuppressWarnings("serial")
public class LambdaUpdateWrapper<T> extends AbstractLambdaWrapper<T, LambdaUpdateWrapper<T>> {

    /**
     * SQL 更新字段内容，例如：name='1',age=2
     */
    private List<String> sqlSet = new ArrayList<>();

    LambdaUpdateWrapper(T entity, AtomicInteger paramNameSeq, Map<String, Object> paramNameValuePairs,
                        MergeSegments mergeSegments) {
        this.entity = entity;
        this.paramNameSeq = paramNameSeq;
        this.paramNameValuePairs = paramNameValuePairs;
        this.expression = mergeSegments;
    }

    @Override
    public String getSqlSet() {
        if (CollectionUtils.isEmpty(sqlSet)) {
            return null;
        }
        return SqlUtils.stripSqlInjection(sqlSet.stream().collect(joining(StringPool.COMMA)));
    }

    public LambdaUpdateWrapper<T> set(Property<T, ?> column, Object val) {
        return this.set(true, column, val);
    }

    public LambdaUpdateWrapper<T> set(boolean condition, Property<T, ?> column, Object val) {
        if (condition) {
            sqlSet.add(String.format("%s=%s", columnToString(column), formatSql("{0}", val)));
        }
        return typedThis;
    }

    @Override
    protected LambdaUpdateWrapper<T> instance(AtomicInteger paramNameSeq, Map<String, Object> paramNameValuePairs) {
        return new LambdaUpdateWrapper<>(entity, paramNameSeq, paramNameValuePairs, new MergeSegments());
    }
}
