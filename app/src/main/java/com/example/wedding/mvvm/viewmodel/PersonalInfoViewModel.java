package com.example.wedding.mvvm.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.arch.lifecycle.MutableLiveData;
import android.content.Intent;
import android.databinding.ObservableField;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;
import android.view.View;

import com.bigkoo.pickerview.builder.OptionsPickerBuilder;
import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.OptionsPickerView;
import com.bigkoo.pickerview.view.TimePickerView;
import com.example.wedding.R;
import com.example.wedding.base.BaseViewModel;
import com.example.wedding.binding.command.BindingAction;
import com.example.wedding.binding.command.BindingCommand;
import com.example.wedding.constant.Constant;
import com.example.wedding.http.bean.UserBean;
import com.example.wedding.mvvm.model.PersonalInfoModel;
import com.example.wedding.mvvm.view.activity.NickNameActivity;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.ToastUtil;
import com.example.wedding.widget.SelectPictureDialog;
import com.yalantis.ucrop.UCrop;
import com.yalantis.ucrop.UCropActivity;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import cn.bmob.v3.BmobUser;
import top.zibin.luban.Luban;
import top.zibin.luban.OnCompressListener;

/**
 * @author
 * @date 2019/4/11 15:21
 * @email 714081644@qq.com
 */
public class PersonalInfoViewModel extends BaseViewModel<PersonalInfoModel> {

    private UserBean mCurrentUser;
    /**
     * 从相册选取照片
     */
    public static final int SELECT_PICTURE_FROM_ALBUM = 1;
    /**
     * 拍照方式选取照片
     */
    public static final int SELECT_PICTURE_FROM_CAMERA = 2;
    /**
     * 修改昵称返回
     */
    public static final int CHANGE_NICK_NAME = 100;

    private static final List<String> mSexList = Arrays.asList("男", "女", "保密");

    private SimpleDateFormat mDateFormat;

    /**
     * 头像
     */
    public ObservableField<Object> headPicture;
    /**
     * 昵称
     */
    public ObservableField<String> nickName;
    /**
     * 结婚日期
     */
    public ObservableField<String> weddingDate;
    /**
     * 性别
     */
    public ObservableField<String> sex;
    /**
     * 生日
     */
    public ObservableField<String> birthday;
    /**
     * 头像点击事件
     */
    public BindingCommand selectHeadCommand;
    /**
     * 昵称点击事件
     */
    public BindingCommand nickNameCommand;
    /**
     * 婚期点击事件
     */
    public BindingCommand weddingDateCommand;
    /**
     * 性别点击事件
     */
    public BindingCommand sexCommand;
    /**
     * 生日点击事件
     */
    public BindingCommand birthdayCommand;
    /**
     * 跳转至剪裁界面
     */
    public MutableLiveData<UCrop> toUCrop;
    /**
     * 选中图片dialog
     */
    private SelectPictureDialog mDialog;
    /**
     * 婚期PickerView
     */
    private TimePickerView mWeddingDatePickerView;
    /**
     * 性别OptionsPicekerView
     */
    private OptionsPickerView<String> mSexOptionsPicekerView;
    /**
     * 生日PickerView
     */
    private TimePickerView mBirthdayPickerView;

    public PersonalInfoViewModel(@NonNull Application application) {
        super(application, new PersonalInfoModel());
        mCurrentUser = BmobUser.getCurrentUser(UserBean.class);
        mDateFormat = new SimpleDateFormat(Constant.DATA_FORMAT_PATTERN, Locale.getDefault());
        mDateFormat.setLenient(false);

        headPicture = new ObservableField<>("");
        nickName = new ObservableField<>("");
        weddingDate = new ObservableField<>("");
        sex = new ObservableField<>("");
        birthday = new ObservableField<>("");
        toUCrop = new MutableLiveData<>();
        selectHeadCommand = new BindingCommand(() -> {
            if (mDialog != null && !mDialog.isShowing()) {
                mDialog.show();
            }
        });
        nickNameCommand = new BindingCommand(() -> getBaseLiveData().postValue(String.valueOf(CHANGE_NICK_NAME)));
        weddingDateCommand = new BindingCommand(() -> {
            if (mWeddingDatePickerView != null && !mWeddingDatePickerView.isShowing()) {
                mWeddingDatePickerView.show();
            }
        });
        sexCommand = new BindingCommand(() -> {
            if (mSexOptionsPicekerView != null && !mSexOptionsPicekerView.isShowing()) {
                mSexOptionsPicekerView.show();
            }
        });
        birthdayCommand = new BindingCommand(() -> {
            if (mBirthdayPickerView != null && !mBirthdayPickerView.isShowing()) {
                mBirthdayPickerView.show();
            }
        });
    }

    @Override
    public void onCreate() {
        if (mCurrentUser == null) {
            return;
        }
        if (mCurrentUser.getHeadImg() != null) {
            headPicture.set(mCurrentUser.getHeadImg().getFileUrl());
        }
        nickName.set(mCurrentUser.getNickName());
        weddingDate.set(mCurrentUser.getWeddingDate());
        sex.set(mCurrentUser.getSex());
        birthday.set(mCurrentUser.getBirthday());
    }

    public void initDialog(Activity activity) {
        //选择图片Dialog
        mDialog = new SelectPictureDialog(activity);
        mDialog.setOnSelectPictureModeListener(new SelectPictureDialog.OnSelectPictureModeListener() {
            @Override
            public void fromCamera() {
                getBaseLiveData().postValue(String.valueOf(SELECT_PICTURE_FROM_CAMERA));
            }

            @Override
            public void formAlbum() {
                getBaseLiveData().postValue(String.valueOf(SELECT_PICTURE_FROM_ALBUM));
            }
        });

        //婚期DatePickerView
        TimePickerBuilder dateBuilder = new TimePickerBuilder(activity, (date, v) -> {
            String day = mDateFormat.format(date);
            weddingDate.set(day);
            mCurrentUser.setWeddingDate(day);
            mModel.updateUserInfo(mCurrentUser, null, null);
        })
                .setRangDate(Calendar.getInstance(), null);
        mWeddingDatePickerView = dateBuilder.build();
        if (!TextUtils.isEmpty(mCurrentUser.getWeddingDate())) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(mDateFormat.parse(mCurrentUser.getWeddingDate()));
                mWeddingDatePickerView.setDate(calendar);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        //性别OptionsPickerView
        OptionsPickerBuilder sexBuilder = new OptionsPickerBuilder(activity, (options1, options2, options3, v) -> {
            sex.set(mSexList.get(options1));
            mCurrentUser.setSex(mSexList.get(options1));
            mModel.updateUserInfo(mCurrentUser, null, null);
        });
        mSexOptionsPicekerView = sexBuilder.build();
        mSexOptionsPicekerView.setPicker(mSexList);
        if (!TextUtils.isEmpty(mCurrentUser.getSex())) {
            for (int i = 0; i < mSexList.size(); i++) {
                if (TextUtils.equals(mCurrentUser.getSex(), mSexList.get(i))) {
                    mSexOptionsPicekerView.setSelectOptions(i);
                    break;
                }
            }
        }

        //年龄PickerView
        TimePickerBuilder ageBuilder = new TimePickerBuilder(activity, (date, v) -> {
            String day = mDateFormat.format(date);
            birthday.set(day);
            mCurrentUser.setBirthday(day);
            mModel.updateUserInfo(mCurrentUser, null, null);
        });
        mBirthdayPickerView = ageBuilder.build();
        if (!TextUtils.isEmpty(mCurrentUser.getBirthday())) {
            try {
                Calendar calendar = Calendar.getInstance();
                calendar.setTime(mDateFormat.parse(mCurrentUser.getBirthday()));
                mBirthdayPickerView.setDate(calendar);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Activity onActivityResult 返回
     *
     * @param requestCode 请求码
     * @param resultCode  结果码
     * @param data        数据
     */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        switch (requestCode) {
            case SELECT_PICTURE_FROM_ALBUM: //相册选取图片
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null && data.getData() != null) {
                        inToUCrop(data.getData());
                    }
                }
                break;
            case SELECT_PICTURE_FROM_CAMERA: //拍照选取图片
                if (resultCode == Activity.RESULT_OK) {
                    File pictureFile = new File(Constant.CACHE_PICTURE, Constant.CAMERA_HEAD_NAME);
                    if (pictureFile.exists()) {
                        Uri uri;
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                            uri = FileProvider.getUriForFile(getApplication(),
                                    "com.example.wedding.PictureProvider", pictureFile);
                        } else {
                            uri = Uri.fromFile(pictureFile);
                        }
                        inToUCrop(uri);
                    }
                }
                break;
            case UCrop.REQUEST_CROP://图片剪裁
                if (resultCode == Activity.RESULT_OK) {
                    if (data != null) {
                        Uri resultUri = UCrop.getOutput(data);
                        headPicture.set(resultUri);
                        compressPicture(resultUri);
                    }
                }
                break;
            case UCrop.RESULT_ERROR://剪裁出错
                if (data != null) {
                    headPicture.set(null);
                    final Throwable cropError = UCrop.getError(data);
                    if (cropError != null) {
                        ToastUtil.show(getApplication(), "图片剪裁失败: " + cropError.getMessage());
                    }
                }
                break;
            case CHANGE_NICK_NAME:
                if (resultCode == Activity.RESULT_OK && data != null) {
                    nickName.set(data.getStringExtra(NickNameActivity.NICK_NAME));
                }
                break;
            default:
                break;
        }
    }

    /**
     * 剪裁图片
     *
     * @param source 被剪裁的图片资源
     */
    private void inToUCrop(Uri source) {
        File file = new File(Constant.CACHE_PICTURE, Constant.UCROP_HEAD_NAME);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
        }
        Uri destinationUri = Uri.fromFile(file);

        UCrop.Options options = new UCrop.Options();
        //设置裁剪图片可操作的手势
        options.setAllowedGestures(UCropActivity.SCALE, UCropActivity.ROTATE, UCropActivity.ALL);
        //设置隐藏底部容器，默认显示
        options.setHideBottomControls(true);
        //设置toolbar颜色
        options.setToolbarColor(ActivityCompat.getColor(getApplication(), R.color.colorPrimary));
        //设置状态栏颜色
        options.setStatusBarColor(ActivityCompat.getColor(getApplication(), R.color.colorPrimaryDark));
        //开始设置
        //设置最大缩放比例
        options.setMaxScaleMultiplier(5);
        //设置图片在切换比例时的动画
        options.setImageToCropBoundsAnimDuration(666);
        //设置裁剪窗口是否为椭圆
        options.setCircleDimmedLayer(true);
        //设置是否展示矩形裁剪框
        options.setShowCropFrame(false);
        //设置竖线的数量
        options.setCropGridColumnCount(0);
        //设置横线的数量
        options.setCropGridRowCount(0);

        UCrop uCrop = UCrop.of(source, destinationUri)
                .withAspectRatio(1, 1)
                .withMaxResultSize(1000, 1000)
                .withOptions(options);
        toUCrop.postValue(uCrop);
    }

    /**
     * 压缩图片
     *
     * @param uri 图片uri
     */
    private void compressPicture(Uri uri) {
        File file = new File(Constant.COMPRESS_PICTURE);
        if (!file.exists()) {
            file.mkdirs();
        }
        Luban.with(getApplication())
                .load(uri)
                .ignoreBy(200)
                .setTargetDir(Constant.COMPRESS_PICTURE)
                .filter(path -> !(TextUtils.isEmpty(path) || path.toLowerCase().endsWith(".gif")))
                .setCompressListener(new OnCompressListener() {
                    @Override
                    public void onStart() {

                    }

                    @Override
                    public void onSuccess(File file) {
                        updateUserHeadImg(file);
                    }

                    @Override
                    public void onError(Throwable e) {
                        ToastUtil.show(getApplication(), "出错啦，请重试！");
                        LogUtil.e("压缩图片失败: " + e.getMessage());
                    }
                })
                .launch();
    }

    /**
     * 上传用户头像
     *
     * @param file 用户头像文件
     */
    private void updateUserHeadImg(File file) {
        mModel.updateUserInfo(mCurrentUser, file, null, e -> ToastUtil.show(getApplication(), "上传图片失败，请重试！"));
    }
}
