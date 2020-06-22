package com.reactnativejitsimeet;

import android.util.Log;
import java.net.URL;
import java.net.MalformedURLException;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.bridge.ReadableMap;

@ReactModule(name = RNJitsiMeetModule.MODULE_NAME)
public class RNJitsiMeetModule extends ReactContextBaseJavaModule {
    public static final String MODULE_NAME = "RNJitsiMeetModule";
    private IRNJitsiMeetViewReference mJitsiMeetViewReference;

    public RNJitsiMeetModule(ReactApplicationContext reactContext, IRNJitsiMeetViewReference jitsiMeetViewReference) {
        super(reactContext);
        mJitsiMeetViewReference = jitsiMeetViewReference;
    }

    @Override
    public String getName() {
        return MODULE_NAME;
    }

    @ReactMethod
    public void initialize() {
        Log.d("JitsiMeet", "Initialize is deprecated in v2");
    }

    @ReactMethod
    public void call(String url, ReadableMap userInfo) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mJitsiMeetViewReference.getJitsiMeetView() != null) {
                    RNJitsiMeetUserInfo _userInfo = new RNJitsiMeetUserInfo();
                    String _subject = " ";
                    if (userInfo != null) {
                      if (userInfo.hasKey("displayName")) {
                        _userInfo.setDisplayName(userInfo.getString("displayName"));
                      }
                      if (userInfo.hasKey("email")) {
                        _userInfo.setEmail(userInfo.getString("email"));
                      }
                      if (userInfo.hasKey("avatar")) {
                        String avatarURL = userInfo.getString("avatar");
                        try {
                          _userInfo.setAvatar(new URL(avatarURL));
                        } catch (MalformedURLException e) {
                        }
                      }
                      if (userInfo.hasKey("subject")) {
                        _subject = userInfo.getString("subject");
                      }
                    }
                    RNJitsiMeetConferenceOptions options = new RNJitsiMeetConferenceOptions.Builder()
                            .setRoom(url)
                            .setAudioOnly(false)
                            .setSubject(_subject)
                            .setUserInfo(_userInfo)
                            .setWelcomePageEnabled(false)
                            .setFeatureFlag("calendar.enabled", false)
                            .setFeatureFlag("call-integration.enabled", false)
                            .setFeatureFlag("close-captions.enabled", false)
                            .setFeatureFlag("chat.enabled", false)
                            .setFeatureFlag("invite.enabled", false)
                            .setFeatureFlag("welcomepage.enabled", false)
                            .build();
                    mJitsiMeetViewReference.getJitsiMeetView().join(options);
                }
            }
        });
    }

    @ReactMethod
    public void audioCall(String url, ReadableMap userInfo) {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mJitsiMeetViewReference.getJitsiMeetView() != null) {
                    RNJitsiMeetUserInfo _userInfo = new RNJitsiMeetUserInfo();
                    String _subject = " ";
                    if (userInfo != null) {
                      if (userInfo.hasKey("displayName")) {
                        _userInfo.setDisplayName(userInfo.getString("displayName"));
                      }
                      if (userInfo.hasKey("email")) {
                        _userInfo.setEmail(userInfo.getString("email"));
                      }
                      if (userInfo.hasKey("avatar")) {
                        String avatarURL = userInfo.getString("avatar");
                        try {
                          _userInfo.setAvatar(new URL(avatarURL));
                        } catch (MalformedURLException e) {
                        }
                      }
                      if (userInfo.hasKey("subject")) {
                        _subject = userInfo.getString("subject");
                      }
                    }
                    RNJitsiMeetConferenceOptions options = new RNJitsiMeetConferenceOptions.Builder()
                            .setRoom(url)
                            .setAudioOnly(true)
                            .setSubject(_subject)
                            .setUserInfo(_userInfo)
                            .setWelcomePageEnabled(false)
                            .setFeatureFlag("calendar.enabled", false)
                            .setFeatureFlag("call-integration.enabled", false)
                            .setFeatureFlag("close-captions.enabled", false)
                            .setFeatureFlag("chat.enabled", false)
                            .setFeatureFlag("invite.enabled", false)
                            .setFeatureFlag("welcomepage.enabled", false)
                            .build();
                    mJitsiMeetViewReference.getJitsiMeetView().join(options);
                }
            }
        });
    }

    @ReactMethod
    public void endCall() {
        UiThreadUtil.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (mJitsiMeetViewReference.getJitsiMeetView() != null) {
                    mJitsiMeetViewReference.getJitsiMeetView().leave();
                }
            }
        });
    }
}
