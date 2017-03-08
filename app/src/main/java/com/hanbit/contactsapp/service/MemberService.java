package com.hanbit.contactsapp.service;

import com.hanbit.contactsapp.domain.MemberBean;

import java.util.List;

/**
 * Created by hb2002 on 2017-03-08.
 */

public interface MemberService {
    public void insert(MemberBean bean);
    public MemberBean findOne(MemberBean bean);
    public List<MemberBean> findSome(MemberBean bean);
    public List<MemberBean> findAll();
    public void change(MemberBean bean);
    public void remove(MemberBean bean);
}
