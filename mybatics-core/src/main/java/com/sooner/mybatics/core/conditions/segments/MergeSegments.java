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
package com.sooner.mybatics.core.conditions.segments;

import com.sooner.mybatics.core.conditions.ISqlSegment;
import com.sooner.mybatics.core.toolkit.StringPool;

import java.util.Arrays;
import java.util.List;

/**
 * @Auther: Hoo
 * @Date: 2018/9/12
 * @Description: 合并 SQL 片段
 */
@SuppressWarnings("serial")
public class MergeSegments implements ISqlSegment {

    private NormalSegmentList normal = new NormalSegmentList();
    private GroupBySegmentList groupBy = new GroupBySegmentList();
    private HavingSegmentList having = new HavingSegmentList();
    private OrderBySegmentList orderBy = new OrderBySegmentList();

    public void add(ISqlSegment... iSqlSegments) {
        List<ISqlSegment> list = Arrays.asList(iSqlSegments);
        ISqlSegment sqlSegment = list.get(0);
        if (MatchSegment.ORDER_BY.match(sqlSegment)) {
            orderBy.addAll(list);
        } else if (MatchSegment.GROUP_BY.match(sqlSegment)) {
            groupBy.addAll(list);
        } else if (MatchSegment.HAVING.match(sqlSegment)) {
            having.addAll(list);
        } else {
            normal.addAll(list);
        }
    }

    @Override
    public String getSqlSegment() {
        if (normal.isEmpty()) {
            if (!groupBy.isEmpty() || !orderBy.isEmpty()) {
                return "1=1" + groupBy.getSqlSegment() + having.getSqlSegment() + orderBy.getSqlSegment();
            } else {
                return StringPool.EMPTY;
            }
        } else {
            return normal.getSqlSegment() + groupBy.getSqlSegment() + having.getSqlSegment() + orderBy.getSqlSegment();
        }
    }



}
