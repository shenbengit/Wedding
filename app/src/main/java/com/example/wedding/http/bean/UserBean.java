package com.example.wedding.http.bean;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.datatype.BmobFile;

/**
 * Bmob云 扩展用户表
 *
 * @author ShenBen
 * @date 2019/4/7 9:55
 * @email 714081644@qq.com
 */
public class UserBean extends BmobUser {
    /**
     * 设置昵称
     */
    private String nickName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private BmobFile headImg;

    public UserBean() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public BmobFile getHeadImg() {
        return headImg;
    }

    public void setHeadImg(BmobFile headImg) {
        this.headImg = headImg;
    }
}
