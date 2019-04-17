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
     * 真实姓名
     */
    private String realName;
    /**
     * 性别
     */
    private String sex;
    /**
     * 头像
     */
    private BmobFile headImg;
    /**
     * 年龄
     */
    private int age;
    /**
     * 住址
     */
    private String homeAddress;
    /**
     * 结婚日期
     */
    private String weddingDate;
    /**
     * 生日
     */
    private String birthday;
    /**
     * 爱人的objectId
     */
    private String loverObjectId;

    public UserBean() {
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getWeddingDate() {
        return weddingDate;
    }

    public void setWeddingDate(String weddingDate) {
        this.weddingDate = weddingDate;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getLoverObjectId() {
        return loverObjectId;
    }

    public void setLoverObjectId(String loverObjectId) {
        this.loverObjectId = loverObjectId;
    }
}
