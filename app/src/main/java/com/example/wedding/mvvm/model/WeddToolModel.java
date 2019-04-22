package com.example.wedding.mvvm.model;

import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;

import com.example.wedding.base.BaseModel;
import com.example.wedding.mvvm.view.bean.WeddPositionBen;
import com.example.wedding.util.LogUtil;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobBatch;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BatchResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.QueryListListener;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

public class WeddToolModel extends BaseModel {

    private Disposable mInsertPositionDisposable;
    private Disposable mSearchPositionDisposable;

    /**
     * 插入婚姻登记处数据
     *
     * @param success
     * @param error
     */
    public void insertPosition(@Nullable Action success, @Nullable Consumer<BmobException> error) {

        WeddPositionBen ben1 = new WeddPositionBen("秦淮区民政局婚姻登记处", "南京市秦淮区苜蓿园大街112号", "秦淮区",
                "星期一", "星期五", 900, 1100, 1400, 1630, "025-84855384", false);

        WeddPositionBen ben2 = new WeddPositionBen("建邺区民政局婚姻登记处", "南京市建邺区万达金街东区15幢124号", "建邺区",
                "星期一", "星期五", 900, 1130, 1400, 1700, "025-86666255", false);

        WeddPositionBen ben3 = new WeddPositionBen("鼓楼区民政局婚姻登记处", "南京市鼓楼区山西路84号", "鼓楼区",
                "星期一", "星期五", 900, 1130, 1330, 1700, "025-84702913", false);

        WeddPositionBen ben4 = new WeddPositionBen("玄武区民政局婚姻登记处", "南京市玄武区估衣廊38号", "玄武区",
                "星期一", "星期五", 900, 1100, 1400, 1630, "025--84701931\n", false);

        WeddPositionBen ben5 = new WeddPositionBen("浦口区民政局婚姻登记处", "南京市浦口区江浦街道象山路4号市民中心B座一楼", "浦口区",
                "星期一", "星期五", 900, 1100, 1400, 1600, "025-69659213", false);

        WeddPositionBen ben6 = new WeddPositionBen("栖霞区民政局婚姻登记处", "栖霞区仙林文苑路118号", "栖霞区",
                "星期一", "星期五", 900, 1130, 1430, 1700, "85316318", false);

        WeddPositionBen ben7 = new WeddPositionBen("雨花台区民政局婚姻登记处", "雨花台区紫荆花路20号三楼", "雨花台区",
                "星期一", "星期五", 900, 1130, 1500, 1730, "025-52423985", false);

        WeddPositionBen ben8 = new WeddPositionBen("六合区民政局婚姻登记处", "南京市六合区气象路8号", "六合区",
                "星期一", "星期五", 830, 1100, 1400, 1600, "025-57127522", false);

        WeddPositionBen ben9 = new WeddPositionBen("溧水区民政局婚姻登记处", "溧水区永阳街道天生桥大道600号溧水区市民中心", "溧水区",
                "星期一", "星期五", 830, 1130, 1400, 1700, "025-57236183", false);

        WeddPositionBen ben10 = new WeddPositionBen("高淳区民政局婚姻登记处", "高淳区淳溪镇丹阳湖北路11号", "高淳区",
                "星期一", "星期五", 900, 1130, 1400, 1700, "025-57311247", false);

        WeddPositionBen ben11 = new WeddPositionBen("江北新区社会事业局婚姻登记处", "南京市大厂新华西路89号", "江北新区",
                "星期一", "星期五", 900, 1100, 1400, 1600, "025-57044849", false);

        WeddPositionBen ben12 = new WeddPositionBen("江宁区民政局婚姻登记处", "南京市江宁区杨家圩路2号市民中心二楼", "江宁区",
                "星期一", "星期五", 900, 1130, 1400, 1730, "025-69977096", false);


        List<BmobObject> categories = new ArrayList<>();
        categories.add(ben1);
        categories.add(ben2);
        categories.add(ben3);
        categories.add(ben4);
        categories.add(ben5);
        categories.add(ben6);
        categories.add(ben7);
        categories.add(ben8);
        categories.add(ben9);
        categories.add(ben10);
        categories.add(ben11);
        categories.add(ben12);

        BmobBatch bmobBatch = new BmobBatch();

        mInsertPositionDisposable = bmobBatch.insertBatch(categories).doBatch(new QueryListListener<BatchResult>() {

            @Override
            public void done(List<BatchResult> results, BmobException e) {
                try {
                    if (e == null) {
                        for (int i = 0; i < results.size(); i++) {
                            BatchResult result = results.get(i);
                            BmobException ex = result.getError();
                            if (ex == null) {
                                if (success != null) {
                                    success.run();
                                }

                                LogUtil.d("第" + i + "个数据批量添加成功：" + result.getCreatedAt() + "," + result.getObjectId() + "," + result.getUpdatedAt());
                            } else {
                                if (error != null) {
                                    error.accept(e);
                                }
                                LogUtil.d("第" + i + "个数据批量添加失败：" + ex.getMessage() + "," + ex.getErrorCode());
                            }
                        }
                    } else {
                        LogUtil.d("失败：" + e.getMessage() + "," + e.getErrorCode(), Snackbar.LENGTH_LONG);
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mInsertPositionDisposable != null) {
            mInsertPositionDisposable.dispose();
        }
        if (mSearchPositionDisposable!=null){
            mSearchPositionDisposable.dispose();
        }
    }

    /**
     * 查询婚姻登记处数据
     */
    public void searchWeddPosition(@Nullable Action success, @Nullable Consumer<BmobException> error) {
        BmobQuery<WeddPositionBen> query = new BmobQuery<>();
        mSearchPositionDisposable = query.findObjects(new FindListener<WeddPositionBen>() {
            @Override
            public void done(List<WeddPositionBen> list, BmobException e) {
                try {
                    if (e == null) {
                        if (list.size() == 0) {
                            if (error != null) {
                                error.accept(e);
                                LogUtil.d("尚未查询到数据");
                                return;
                            }
                        }

                        if (success != null) {
                            success.run();
                            LogUtil.d("成功返回");
                        }
                    }

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
