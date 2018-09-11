/*
 * Copyright (c) 2011-2014, hubin (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sooner.mybatics.anno;

import java.lang.annotation.*;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: 支持普通枚举类字段, 只用在enum类的字段上<br>
 * 当实体类的属性是普通枚举，且是其中一个字段，使用该注解来标注枚举类里的那个属性对应字段<br>
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface EnumValue {

}
