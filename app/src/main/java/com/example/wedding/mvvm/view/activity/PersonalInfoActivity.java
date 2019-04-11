package com.example.wedding.mvvm.view.activity;

import android.Manifest;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.os.Bundle;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.wedding.BR;
import com.example.wedding.R;
import com.example.wedding.base.BaseActivity;
import com.example.wedding.constant.ARouterPath;
import com.example.wedding.databinding.ActivityPersonalInfoBinding;
import com.example.wedding.mvvm.viewmodel.PersonalInfoViewModel;
import com.example.wedding.widget.SelectPictureDialog;

import permissions.dispatcher.NeedsPermission;
import permissions.dispatcher.RuntimePermissions;

/**
 * 个人资料页
 *
 * @author ShenBen
 * @date 2019/4/11 15:18
 * @email 714081644@qq.com
 */
@RuntimePermissions
@Route(path = ARouterPath.PERSONAL_INFO_ACTIVITY)
public class PersonalInfoActivity extends BaseActivity<ActivityPersonalInfoBinding, PersonalInfoViewModel> {
    private SelectPictureDialog mDialog;

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
        mDialog = new SelectPictureDialog(this);
        mDialog.setOnSelectPictureModeListener(new SelectPictureDialog.OnSelectPictureModeListener() {
            @Override
            public void fromCamera() {
                PersonalInfoActivityPermissionsDispatcher.needCameraWithPermissionCheck(PersonalInfoActivity.this);
            }

            @Override
            public void formAlbum() {
                PersonalInfoActivityPermissionsDispatcher.needStoragePermissionWithPermissionCheck(PersonalInfoActivity.this);
            }
        });
        mBinding.btnTest.setOnClickListener(v -> {
            if (!mDialog.isShowing()) {
                mDialog.show();
            }
        });

    }

    @Override
    protected void initData(@Nullable Bundle savedInstanceState) {

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        PersonalInfoActivityPermissionsDispatcher.onRequestPermissionsResult(this, requestCode, grantResults);
    }

    /**
     * 获取读取内存卡权限
     */
    @NeedsPermission({Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE})
    public void needStoragePermission() {

    }

    /**
     * 获取照相机权限
     */
    @NeedsPermission(Manifest.permission.CAMERA)
    public void needCamera() {

    }
}
