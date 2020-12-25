package com.service;


import com.bean.Build;
import com.dao.BuildDao;
import com.dao.Impl.BuildDaoImpl;

import java.util.List;

public class BuildService {

    private BuildDao buildDao = new BuildDaoImpl();
    /**
     * 查询宿舍楼名字是否已经存在
     * @param build_name
     * @return
     */
    public Build findByName(String build_name) {
        return buildDao.findByName(build_name);
    }

    /**
     * 添加新的宿舍楼
     * @param build1
     */
    public void saveBuild(Build build1) {
        buildDao.saveBuild(build1);
    }

    /**
     * 展示所有宿舍楼
     * @return
     */
    public List<Build> findAllBuild() {
        return buildDao.findAllBuild();
    }
}
