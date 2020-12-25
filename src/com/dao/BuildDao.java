package com.dao;


import com.bean.Build;

import java.util.List;

public interface BuildDao {

    /**
     * 查询宿舍楼名字是否已经存在
     * @param build_name
     * @return
     */
    Build findByName(String build_name);

    /**
     * 添加新的宿舍楼
     * @param build1
     */
    void saveBuild(Build build1);

    /**
     * 展示所有宿舍楼
     * @return
     */
    List<Build> findAllBuild();
}
