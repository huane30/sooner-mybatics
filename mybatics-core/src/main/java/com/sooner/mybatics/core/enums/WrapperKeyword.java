package com.sooner.mybatics.core.enums;

import com.sooner.mybatics.core.conditions.ISqlSegment;
import com.sooner.mybatics.core.toolkit.StringPool;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description: wrapper 内部使用枚举
 */
public enum WrapperKeyword implements ISqlSegment {
    /**
     * 只用作于辨识,不用于其他
     */
    APPLY(null),
    LEFT_BRACKET(StringPool.LEFT_BRACKET),
    RIGHT_BRACKET(StringPool.RIGHT_BRACKET);

    private String keyword;

    WrapperKeyword(final String keyword) {
        this.keyword = keyword;
    }

    @Override
    public String getSqlSegment() {
        return keyword;
    }
}
