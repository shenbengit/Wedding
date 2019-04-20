package com.example.wedding;

import android.support.annotation.Nullable;
import android.support.multidex.MultiDexApplication;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.wedding.constant.Constant;
import com.example.wedding.strategy.LogCatStrategy;
import com.example.wedding.util.LogUtil;
import com.example.wedding.util.SharedPreferencesUtil;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobConfig;
import me.yokeyword.fragmentation.Fragmentation;

/**
 * @author
 * @date 2019/4/3 16:56
 * @email 714081644@qq.com
 */
public class App extends MultiDexApplication {

    private RefWatcher mRefWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        initLeakCanary();
        initLogger();
        initARouter();
        initFragmentation();
        SharedPreferencesUtil.getInstance().init(this);
        initBmob();
    }

    /**
     * 初始化LeakCanary
     */
    private void initLeakCanary() {
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        mRefWatcher = LeakCanary.install(this);
    }

    public RefWatcher getRefWatcher() {
        return mRefWatcher;
    }

    /**
     * 初始化Logger
     */
    private void initLogger() {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .showThreadInfo(false)
                .methodCount(2)
                .logStrategy(new LogCatStrategy())
                .tag(Constant.TAG)
                .build();

        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, @Nullable String tag) {
                return BuildConfig.DEBUG;
            }
        });
    }

    /**
     * 初始化ARouter
     */
    private void initARouter() {
        if (BuildConfig.DEBUG) {
            ARouter.openLog();
            ARouter.openDebug();
        }
        ARouter.init(this);
    }

    /**
     * Fragmentation初始化
     */
    private void initFragmentation() {
        Fragmentation.builder()
                // 设置 栈视图 模式为 悬浮球模式   SHAKE: 摇一摇唤出  默认NONE：隐藏， 仅在Debug环境生效
                .stackViewMode(Fragmentation.BUBBLE)
                // 开发环境：true时，遇到异常："Can not perform this action after onSaveInstanceState!"时，抛出，并Crash;
                // 生产环境：false时，不抛出，不会Crash，会捕获，可以在handleException()里监听到
                // 实际场景建议.debug(BuildConfig.DEBUG)
                .debug(BuildConfig.DEBUG)
                // 生产环境时，捕获上述异常（避免crash），会捕获
                // 建议在回调处上传下面异常到崩溃监控服务器
                .handleException(e -> LogUtil.e("Fragmentation error: " + e.getMessage()))
                .install();
    }

    /**
     * 初始化Bmob SDK
     * 修改为自己注册的Application ID
     */
    private void initBmob() {
        BmobConfig config = new BmobConfig.Builder(this)
                .setApplicationId(Constant.BMOB_APP_KEY)
                .setConnectTimeout(15)//设置超时时间 （秒）
                .setUploadBlockSize(1024 * 1024)//文件分片上传时每片的大小（单位字节）
                .setFileExpiration(1800)//文件的过期时间(单位为秒)
                .build();
        Bmob.initialize(config);
    }
}
