/**
 * @providesModule JitsiMeet
 */

import { NativeModules, requireNativeComponent } from 'react-native';

export const JitsiMeetView = requireNativeComponent('RNJitsiMeetView');
export const JitsiMeetModule = NativeModules.RNJitsiMeetView;
const call = JitsiMeetModule.call;
const audioCall = JitsiMeetModule.audioCall;
JitsiMeetModule.call = (url, subject, userInfo) => {
  userInfo = userInfo || {};
  call(url, subject, userInfo);
}
JitsiMeetModule.audioCall = (url, subject, userInfo) => {
  userInfo = userInfo || {};
  audioCall(url, subject, userInfo);
}
export default JitsiMeetModule;


