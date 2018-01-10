package stu.wl.twitter.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import stu.wl.twitter.dao.BaseInfoDao;
import stu.wl.twitter.domain.BaseInfo;
import stu.wl.twitter.domain.User;

@Repository("baseInfoDao")
public class BaseInfoDaoImpl extends BaseDaoImpl<BaseInfo> implements BaseInfoDao{}





