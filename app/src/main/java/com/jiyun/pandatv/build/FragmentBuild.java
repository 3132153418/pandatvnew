package com.jiyun.pandatv.build;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;


import com.jiyun.pandatv.base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2017/6/18.
 */

public class FragmentBuild {
    private int containerViewId;
    private BaseFragment lastFragment;
    private FragmentTransaction transaction;
    private FragmentManager fragmentManager;
    private BaseFragment fragment;
    private String simpleName;
    private boolean isDefault = true;
    private boolean isBack = true;
    private Map<String,Integer> fragments;

    public FragmentBuild(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
        fragments = new HashMap<>();
    }


    public FragmentBuild containerId(int containerViewId){
        this.containerViewId = containerViewId;
        return this;
    }

    public FragmentBuild start(Class<? extends BaseFragment> fragmentClass){

        transaction = fragmentManager.beginTransaction();
        simpleName = fragmentClass.getSimpleName();
        fragment = (BaseFragment) fragmentManager.findFragmentByTag(simpleName);
        try {
            if(fragment == null){
                //Java动态代理创建对象
                fragment = fragmentClass.newInstance();
                transaction.add(containerViewId,fragment,simpleName);
                fragments.put(simpleName,containerViewId);

            }else {
                Integer containerId = fragments.get(simpleName);
                if(containerId != containerViewId){
                    fragment = null;
                    //Java动态代理创建对象
                    fragment = fragmentClass.newInstance();
                    transaction.add(containerViewId,fragment,simpleName);
                    fragments.put(simpleName,containerViewId);
                }

            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        return this;
    }

    //隐藏上一个fragment
    public FragmentBuild show(){

            //隐藏上一个fragment
            if (lastFragment != null)
                transaction.hide(lastFragment);


        return this;
    }

    //替换上一个fragment
    public FragmentBuild replace(){
        isDefault = false;
        transaction.replace(containerViewId,fragment,simpleName);
        return this;
    }

    //传递参数
    public FragmentBuild params(Bundle bundle){
        if (bundle != null)
            fragment.setParams(bundle);
        return this;
    }

    public FragmentBuild isBack(boolean isBack){
        if(isBack) {
            //添加fragment到回退栈
            transaction.addToBackStack(simpleName);
        }
        this.isBack = false;
        return this;
    }

    public BaseFragment getLastFragment() {
        return lastFragment;
    }

    public void setLastFragment(BaseFragment lastFragment) {
        this.lastFragment = lastFragment;
    }

    public BaseFragment build(){
        if(isDefault){
            show();
        }
        if(isBack) {
            isBack(true);

        }
        //显示当前的Fragment
        transaction.show(fragment);
        transaction.commit();
        isDefault = true;
        isBack = true;
        lastFragment = fragment;
        return fragment;
    }
}

