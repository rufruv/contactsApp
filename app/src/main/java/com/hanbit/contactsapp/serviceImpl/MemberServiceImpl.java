package com.hanbit.contactsapp.serviceImpl;

import com.hanbit.contactsapp.domain.MemberBean;
import com.hanbit.contactsapp.service.MemberService;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2002 on 2017-03-08.
 */

public class MemberServiceImpl implements MemberService{
    @Override
    public void insert(MemberBean bean) {
    }

    @Override
    public MemberBean findOne(MemberBean bean) {
        MemberBean member = new MemberBean();

        return member;
    }

    @Override
    public List<MemberBean> findSome(MemberBean bean) {
        List<MemberBean> listSome = new ArrayList<>();

        return listSome;
    }

    @Override
    public List<MemberBean> findAll() {
        List<MemberBean> listAll = new ArrayList<>();

        return listAll;
    }

    @Override
    public void change(MemberBean bean) {

    }

    @Override
    public void remove(MemberBean bean) {

    }
}
