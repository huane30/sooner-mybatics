/*
 * Copyright (c) 2011-2016, hubin (jobob@qq.com).
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
package com.sooner.mybatics.core.incrementer;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: 表主键生成器接口 (sql)
 */
public interface IKeyGenerator {

    /**
     * <p>
     * 执行 key 生成 SQL
     * </p>
     *
     * @param incrementerName 序列名称
     * @return sql
     */
    String executeSql(String incrementerName);
}
