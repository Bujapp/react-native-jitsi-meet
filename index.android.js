/**
 * @providesModule JitsiMeet
 */

import { NativeModules, requireNativeComponent } from 'react-native';

export const JitsiMeetView = requireNativeComponent('RNJitsiMeetView');
export const JitsiMeetModule = NativeModules.RNJitsiMeetModule
const call = JitsiMeetModule.call;
const audioCall = JitsiMeetModule.audioCall;
JitsiMeetModule.call = (url, subject, userInfo) => {
  userInfo = Object.assign({}, userInfo, { subject });
  call(url, userInfo);
}
JitsiMeetModule.audioCall = (url, subject, userInfo) => {
  userInfo = Object.assign({}, userInfo, { subject });
  audioCall(url, userInfo);
}
export default JitsiMeetModule;


