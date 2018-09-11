/*
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
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
package com.sooner.mybatics.anno;

import java.lang.annotation.*;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: 表字段逻辑处理注解（逻辑删除）
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface TableLogic {

    /**
     * <p>
     * 默认逻辑未删除值（该值可无、会自动获取全局配置）
     * </p>
     */
    String value() default "";

    /**
     * <p>
     * 默认逻辑删除值（该值可无、会自动获取全局配置）
     * </p>
     */
    String delval() default "";

}
