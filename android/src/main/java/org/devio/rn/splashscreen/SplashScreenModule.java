package org.devio.rn.splashscreen;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.Arguments;
/**
 * SplashScreen
 * 启动屏
 * from：http://www.devio.org
 * Author:CrazyCodeBoy
 * GitHub:https://github.com/crazycodeboy
 * Email:crazycodeboy@gmail.com
 */
public class SplashScreenModule extends ReactContextBaseJavaModule{

    public SplashScreenModule(final ReactApplicationContext reactContext) {
        super(reactContext);
        reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                                  .emit("SPLASHSCREEN_LOADING", params);
        Runnable callback = new Runnable() {

          public void run() {
            WritableMap params = Arguments.createMap();
            reactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)
                .emit("SPLASHSCREEN_DONE", params);
          };
        };
        SplashScreen.setFinishedAnimationCallback(callback);
    }

    @Override
    public String getName() {
        return "SplashScreen";
    }

    /**
     * 打开启动屏
     */
    @ReactMethod
    public void show() {
        SplashScreen.show(getCurrentActivity());
    }

    /**
     * 关闭启动屏
     */
    @ReactMethod
    public void hide() {
        SplashScreen.hide(getCurrentActivity());
    }

    @ReactMethod(isBlockingSynchronousMethod = true)
    public boolean isShowing() {
        return SplashScreen.isShowing();
    }
}