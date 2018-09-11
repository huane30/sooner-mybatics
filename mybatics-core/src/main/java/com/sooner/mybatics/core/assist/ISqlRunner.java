package com.sooner.mybatics.core.assist;

import com.sooner.mybatics.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * @Auther: Hoo
 * @Date: 2018/9/11
 * @Description:
 */
public interface ISqlRunner {

    String INSERT = "com.sooner.mybatics.core.mapper.SqlRunner.Insert";
    String DELETE = "com.sooner.mybatics.core.mapper.SqlRunner.Delete";
    String UPDATE = "com.sooner.mybatics.core.mapper.SqlRunner.Update";
    String SELECT_LIST = "com.sooner.mybatics.core.mapper.SqlRunner.SelectList";
    String SELECT_OBJS = "com.sooner.mybatics.core.mapper.SqlRunner.SelectObjs";
    String COUNT = "com.sooner.mybatics.core.mapper.SqlRunner.Count";
    String SQL_SCRIPT = "${sql}";
    String SQL = "sql";

    boolean insert(String sql, Object... args);

    boolean delete(String sql, Object... args);

    boolean update(String sql, Object... args);

    List<Map<String, Object>> selectList(String sql, Object... args);

    List<Object> selectObjs(String sql, Object... args);

    Object selectObj(String sql, Object... args);

    int selectCount(String sql, Object... args);

    Map<String, Object> selectOne(String sql, Object... args);

    IPage<Map<String, Object>> selectPage(IPage page, String sql, Object... args);
}
