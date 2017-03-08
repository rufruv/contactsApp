package com.hanbit.contactsapp.dao;

import com.hanbit.contactsapp.domain.MemberBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hb2002 on 2017-03-08.
 */

public class MemberDAO {
    public void insert(MemberBean bean){

    };
    public MemberBean selectOne(MemberBean bean){
        MemberBean member = new MemberBean();
        return member;
    };
    public List<MemberBean> selectSome(MemberBean bean){
        List<MemberBean> listSome = new ArrayList<>();

        return listSome;
    };
    public List<MemberBean> selectAll(MemberBean bean){
        List<MemberBean> listAll = new ArrayList<>();

        return listAll;
    };
    public void update(MemberBean bean){

    };
    public void delete(MemberBean bean){

    };
}
