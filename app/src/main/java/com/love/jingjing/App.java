package com.love.jingjing;

import android.app.Application;

/**
 * Created by android on 2017/8/17.
 */

public class App extends Application {

    public interface MsgDisplayListener {
        void handle(String msg);
    }

    public static MsgDisplayListener msgDisplayListener = null;
    public static StringBuilder cacheMsg = new StringBuilder();

    @Override
    public void onCreate() {
        super.onCreate();

        initHotfix();
    }


    private void initHotfix() {
        String appVersion;
        try {
            appVersion = this.getPackageManager().getPackageInfo(this.getPackageName(), 0).versionName;
        } catch (Exception e) {
            appVersion = "1.0.0";
        }

//        SophixManager.getInstance().setContext(this)
//                .setAppVersion(appVersion)
//                .setAesKey(null)
//                //.setAesKey("0123456789123456")
//                .setEnableDebug(true)
//                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
//                    @Override
//                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
//                        String msg = new StringBuilder("").append("Mode:").append(mode)
//                                .append(" Code:").append(code)
//                                .append(" Info:").append(info)
//                                .append(" HandlePatchVersion:").append(handlePatchVersion).toString();
//                        if (msgDisplayListener != null) {
//                            msgDisplayListener.handle(msg);
//                        } else {
//                            cacheMsg.append("\n").append(msg);
//                        }
//                    }
//                }).initialize();
//        SophixManager.getInstance().queryAndLoadNewPatch();
    }


}
