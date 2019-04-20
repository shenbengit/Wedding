package com.example.wedding.mvvm.view.activity;

import android.Manifest;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;
import android.support.v4.content.FileProvider;
import android.text.TextUtils;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.constant.Constant;
import com.example.wedding.databinding.ActivityPersonalInfoBinding;
import com.example.wedding.mvvm.viewmodel.PersonalInfoViewModel;

import java.io.File;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * 个人资料页
 *
 * @author

 */
@RuntimePermissions
@Route(path = ARouterPath.PERSONAL_INFO_ACTIVITY)
public class PersonalInfoActivity extends BaseActivity<ActivityPersonalInfoBinding, PersonalInfoViewModel> {

    private int selectPictureType = 0;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_personal_info;
    }

    @Override
    protected Class<PersonalInfoViewModel> getModelClass() {
        return PersonalInfoViewModel.class;
    }

    @Override
    protected int getVariableId() {
        return BR.viewModel;
    }

    @Override
    protected void initView() {
        mBinding.toolbar.setTitle("个人资料");
        initToolbarNav(mBinding.toolbar);
        mViewModel.initDialog(this);
    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {
        mViewModel.getBaseLiveData().observe(this, s -> {
            if (TextUtils.isEmpty(s)) {
                return;
            }
            switch (s) {
                case "1"://从相册选取照片
                    selectPictureType = PersonalInfoViewModel.SELECT_PICTURE_FROM_ALBUM;
                    PersonalInfoActivityPermissionsDispatcher.needStoragePermissionWithPermissionCheck(PersonalInfoActivity.this);
                    break;
                case "2"://拍照方式选取照片
                    selectPictureType = PersonalInfoViewModel.SELECT_PICTURE_FROM_CAMERA;
                    PersonalInfoActivityPermissionsDispatcher.needCameraWithPermissionCheck(PersonalInfoActivity.this);
                    break;
                case "100":
                    ARouter.getInstance()
                            .build(ARouterPath.NICK_NAME_ACTIVITY)
                            .navigation(this, PersonalInfoViewModel.CHANGE_NICK_NAME);
                    break;
            }
        });
        mViewModel.toUCrop.observe(this, uCrop -> {
            if (uCrop != null) {
                uCrop.start(PersonalInfoActivity.this);
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PersonalInfoActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mViewModel.onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 获取读取内存卡权限
     */
    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void needStoragePermission() {
        if (selectPictureType == PersonalInfoViewModel.SELECT_PICTURE_FROM_ALBUM) {//相册选取
            Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
            startActivityForResult(intent, PersonalInfoViewModel.SELECT_PICTURE_FROM_ALBUM);
        } else if (selectPictureType == PersonalInfoViewModel.SELECT_PICTURE_FROM_CAMERA) {//拍照选取
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File pictureFile = new File(Constant.CACHE_PICTURE, Constant.CAMERA_HEAD_NAME);
            if (!pictureFile.getParentFile().exists()) {
                pictureFile.getParentFile().mkdirs();
            }
            Uri pictureUri;
            // 判断当前系统是否大于7.0
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                //临时授权Intent启动的Activity使用我们Provider封装的Uri
                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                pictureUri = FileProvider.getUriForFile(this,
                        "com.example.wedding.PictureProvider", pictureFile);
            } else {
                pictureUri = Uri.fromFile(pictureFile);
            }
            // 去拍照,拍照的结果存到pictureUri对应的路径中
            intent.putExtra(MediaStore.EXTRA_OUTPUT, pictureUri);
            startActivityForResult(intent, PersonalInfoViewModel.SELECT_PICTURE_FROM_CAMERA);
        }
    }

    /**
     * 获取照相机权限
     */
    @NeedsPermission(Manifest.permission.CAMERA)
    public void needCamera() {
        //请求文件读写权限
        PersonalInfoActivityPermissionsDispatcher.needStoragePermissionWithPermissionCheck(PersonalInfoActivity.this);
    }
}
