package com.oraclewdp.book.biz.impl;

import com.oraclewdp.book.biz.AdminBiz;
import com.oraclewdp.book.dao.AdminDao;
import com.oraclewdp.book.dao.BigTypeDao;
import com.oraclewdp.book.dao.impl.AdminDaoImpl;
import com.oraclewdp.book.dao.impl.BigTypeDaoImpl;
import com.oraclewdp.book.model.Admin;

public class AdminBizImp implements AdminBiz {
    @Override
    public boolean findAdmin(Admin admin) {
        AdminDao adminDao=new AdminDaoImpl();
        return adminDao.findAdmin(admin);
    }
}
