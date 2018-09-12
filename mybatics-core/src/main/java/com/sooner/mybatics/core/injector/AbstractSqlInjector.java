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
package com.sooner.mybatics.core.injector;

import com.sooner.mybatics.core.parser.SqlParserHelper;
import com.sooner.mybatics.core.toolkit.Assert;
import com.sooner.mybatics.core.toolkit.GlobalConfigUtils;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.Configuration;

import java.util.List;
import java.util.Set;


/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: SQL 自动注入器
 */
public abstract class AbstractSqlInjector implements ISqlInjector {

    @Override
    public void inspectInject(MapperBuilderAssistant builderAssistant, Class<?> mapperClass) {
        String className = mapperClass.toString();
        Set<String> mapperRegistryCache = GlobalConfigUtils.getMapperRegistryCache(builderAssistant.getConfiguration());
        if (!mapperRegistryCache.contains(className)) {
            List<AbstractMethod> methodList = this.getMethodList();
            Assert.notEmpty(methodList, "No effective injection method was found.");
            // 循环注入自定义方法
            methodList.forEach(m -> m.inject(builderAssistant, mapperClass));
            mapperRegistryCache.add(className);
            /**
             * 初始化 SQL 解析
             */
            if (GlobalConfigUtils.getGlobalConfig(builderAssistant.getConfiguration()).isSqlParserCache()) {
                SqlParserHelper.initSqlParserInfoCache(mapperClass);
            }
        }
    }

    @Override
    public void injectSqlRunner(Configuration configuration) {
        // to do nothing
    }

    /**
     * <p>
     * 获取 注入的方法
     * </p>
     *
     * @return 注入的方法集合
     */
    public abstract List<AbstractMethod> getMethodList();
}
