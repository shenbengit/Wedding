package com.example.wedding.http.request;

import com.example.wedding.constant.Constant;
import com.example.wedding.http.callback.Callback;
import com.example.wedding.util.RxUtil;

import java.io.File;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import okhttp3.ResponseBody;

/**
 * @author

 */
public class DownloadRequest extends BaseRequest<DownloadRequest> {

    private static final String APK_CONTENT_TYPE = "vnd.android.package-archive";
    private static final int BUFFER_SIZE = 1024 * 8;
    private String filePath = Constant.FILE_SAVE_PATH + "apk" + File.separator;      //保存下载文件路径
    private String fileName;
    private long currentSize = 0;

    public DownloadRequest(String url) {
        super(url);
    }

    public <T> void execute(Callback<T> callback) {
        if (callback != null) {
            File file = new File(filePath + fileName);
            if (file.exists()) {
                currentSize = file.length();
            }
            generateRequest().compose(RxUtil.io_main())
                    .subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    @Override
    protected Observable<ResponseBody> generateRequest() {
        return mApiService.downloadFile("bytes=" + currentSize + "-", mUrl);
    }
}
