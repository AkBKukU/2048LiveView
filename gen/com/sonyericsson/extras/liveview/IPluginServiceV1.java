/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/akbkuku/projects/AkBKukU/2048LiveView/src/com/sonyericsson/extras/liveview/IPluginServiceV1.aidl
 */
package com.sonyericsson.extras.liveview;
public interface IPluginServiceV1 extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.sonyericsson.extras.liveview.IPluginServiceV1
{
private static final java.lang.String DESCRIPTOR = "com.sonyericsson.extras.liveview.IPluginServiceV1";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.sonyericsson.extras.liveview.IPluginServiceV1 interface,
 * generating a proxy if needed.
 */
public static com.sonyericsson.extras.liveview.IPluginServiceV1 asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.sonyericsson.extras.liveview.IPluginServiceV1))) {
return ((com.sonyericsson.extras.liveview.IPluginServiceV1)iin);
}
return new com.sonyericsson.extras.liveview.IPluginServiceV1.Stub.Proxy(obj);
}
@Override public android.os.IBinder asBinder()
{
return this;
}
@Override public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException
{
switch (code)
{
case INTERFACE_TRANSACTION:
{
reply.writeString(DESCRIPTOR);
return true;
}
case TRANSACTION_register:
{
data.enforceInterface(DESCRIPTOR);
com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 _arg0;
_arg0 = com.sonyericsson.extras.liveview.IPluginServiceCallbackV1.Stub.asInterface(data.readStrongBinder());
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
boolean _arg3;
_arg3 = (0!=data.readInt());
java.lang.String _arg4;
_arg4 = data.readString();
int _result = this.register(_arg0, _arg1, _arg2, _arg3, _arg4);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_unregister:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 _arg1;
_arg1 = com.sonyericsson.extras.liveview.IPluginServiceCallbackV1.Stub.asInterface(data.readStrongBinder());
this.unregister(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_sendAnnounce:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
java.lang.String _arg1;
_arg1 = data.readString();
java.lang.String _arg2;
_arg2 = data.readString();
java.lang.String _arg3;
_arg3 = data.readString();
long _arg4;
_arg4 = data.readLong();
java.lang.String _arg5;
_arg5 = data.readString();
this.sendAnnounce(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
reply.writeNoException();
return true;
}
case TRANSACTION_sendImage:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
java.lang.String _arg3;
_arg3 = data.readString();
this.sendImage(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_sendImageAsBitmap:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
android.graphics.Bitmap _arg3;
if ((0!=data.readInt())) {
_arg3 = android.graphics.Bitmap.CREATOR.createFromParcel(data);
}
else {
_arg3 = null;
}
this.sendImageAsBitmap(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_clearDisplay:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.clearDisplay(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_notifyInstalled:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
java.lang.String _arg1;
_arg1 = data.readString();
int _result = this.notifyInstalled(_arg0, _arg1);
reply.writeNoException();
reply.writeInt(_result);
return true;
}
case TRANSACTION_ledControl:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
int _arg3;
_arg3 = data.readInt();
this.ledControl(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_vibrateControl:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
this.vibrateControl(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_sendImageAsBitmapByteArray:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
int _arg2;
_arg2 = data.readInt();
byte[] _arg3;
_arg3 = data.createByteArray();
this.sendImageAsBitmapByteArray(_arg0, _arg1, _arg2, _arg3);
reply.writeNoException();
return true;
}
case TRANSACTION_screenOff:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.screenOff(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_screenDim:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.screenDim(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_screenOn:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.screenOn(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_screenOnAuto:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.screenOnAuto(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.sonyericsson.extras.liveview.IPluginServiceV1
{
private android.os.IBinder mRemote;
Proxy(android.os.IBinder remote)
{
mRemote = remote;
}
@Override public android.os.IBinder asBinder()
{
return mRemote;
}
public java.lang.String getInterfaceDescriptor()
{
return DESCRIPTOR;
}
// Register to the Liveview application
// cb - callback instance
// imageMenu - path to the menu bitmap
// pluginName - name of the plugin - must be unique
// selectableMenu - is set to true if controlling display and getting buttons. Set to false to only handle announces
// packageName - the package name (use getPackageName()).
// returns id of plugin in system, 0 means that the registration failed

@Override public int register(com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 cb, java.lang.String imageMenu, java.lang.String pluginName, boolean selectableMenu, java.lang.String packageName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
_data.writeString(imageMenu);
_data.writeString(pluginName);
_data.writeInt(((selectableMenu)?(1):(0)));
_data.writeString(packageName);
mRemote.transact(Stub.TRANSACTION_register, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// This method should be called if the application/service is uninstalled using the phone application handler 
// id - the plugin id received in registerPlugin
// cb - the callback

@Override public void unregister(int id, com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 cb) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeStrongBinder((((cb!=null))?(cb.asBinder()):(null)));
mRemote.transact(Stub.TRANSACTION_unregister, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to send announcements to the device - can only be used when _not_ registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// imageAnnounce - the path to the announce bitmap
// header - header text
// body - body text
// time - timestamp for this announce in milliseconds
// openInPhoneAction - a tag to use for openInPhone callback. Set to null when announce not selectable

@Override public void sendAnnounce(int id, java.lang.String imageAnnounce, java.lang.String header, java.lang.String body, long timestamp, java.lang.String openInPhoneAction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeString(imageAnnounce);
_data.writeString(header);
_data.writeString(body);
_data.writeLong(timestamp);
_data.writeString(openInPhoneAction);
mRemote.transact(Stub.TRANSACTION_sendAnnounce, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// image - the path to the image on file system

@Override public void sendImage(int id, int x, int y, java.lang.String image) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(x);
_data.writeInt(y);
_data.writeString(image);
mRemote.transact(Stub.TRANSACTION_sendImage, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// bitmapData - the bitmap to send

@Override public void sendImageAsBitmap(int id, int x, int y, android.graphics.Bitmap bitmapData) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(x);
_data.writeInt(y);
if ((bitmapData!=null)) {
_data.writeInt(1);
bitmapData.writeToParcel(_data, 0);
}
else {
_data.writeInt(0);
}
mRemote.transact(Stub.TRANSACTION_sendImageAsBitmap, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Clears the display, for example if several images are sent while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin

@Override public void clearDisplay(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_clearDisplay, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Provide the Liveview application with means to launch the service 
// that shoul receive and send data in sandbox mode - Must be called if you registered as "selectableMenu"
// launcherIntent - the intent to start the plugin service
// pluginName - the name of the plugin, must match the name you registered with! 
// returns -1 for failure, 0 for already registered, anything else for success

@Override public int notifyInstalled(java.lang.String launcherIntent, java.lang.String pluginName) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
int _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(launcherIntent);
_data.writeString(pluginName);
mRemote.transact(Stub.TRANSACTION_notifyInstalled, _data, _reply, 0);
_reply.readException();
_result = _reply.readInt();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Controls LED - can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// rgb565 - the color to use
// delayTime - the delay in ms
// onTime - the on time in ms

@Override public void ledControl(int id, int rgb565, int delayTime, int onTime) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(rgb565);
_data.writeInt(delayTime);
_data.writeInt(onTime);
mRemote.transact(Stub.TRANSACTION_ledControl, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Controls Vibration - can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// delayTime - the delay in ms
// onTime - the on time in ms

@Override public void vibrateControl(int id, int delayTime, int onTime) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(delayTime);
_data.writeInt(onTime);
mRemote.transact(Stub.TRANSACTION_vibrateControl, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// bitmapBytes - the byteArray containing the bitmap data

@Override public void sendImageAsBitmapByteArray(int id, int x, int y, byte[] bitmapByteArray) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
_data.writeInt(x);
_data.writeInt(y);
_data.writeByteArray(bitmapByteArray);
mRemote.transact(Stub.TRANSACTION_sendImageAsBitmapByteArray, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to put the screen in powersave mode
// id - the plugin id received in registerPlugin

@Override public void screenOff(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_screenOff, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to put the screen in dimmed mode
// id - the plugin id received in registerPlugin

@Override public void screenDim(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_screenDim, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to wake the screen from powersave mode
// id - the plugin id received in registerPlugin

@Override public void screenOn(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_screenOn, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Used to set the to powersave mode "AUTO"
// id - the plugin id received in registerPlugin

@Override public void screenOnAuto(int id) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(id);
mRemote.transact(Stub.TRANSACTION_screenOnAuto, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_register = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_unregister = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_sendAnnounce = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_sendImage = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_sendImageAsBitmap = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_clearDisplay = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_notifyInstalled = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_ledControl = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
static final int TRANSACTION_vibrateControl = (android.os.IBinder.FIRST_CALL_TRANSACTION + 8);
static final int TRANSACTION_sendImageAsBitmapByteArray = (android.os.IBinder.FIRST_CALL_TRANSACTION + 9);
static final int TRANSACTION_screenOff = (android.os.IBinder.FIRST_CALL_TRANSACTION + 10);
static final int TRANSACTION_screenDim = (android.os.IBinder.FIRST_CALL_TRANSACTION + 11);
static final int TRANSACTION_screenOn = (android.os.IBinder.FIRST_CALL_TRANSACTION + 12);
static final int TRANSACTION_screenOnAuto = (android.os.IBinder.FIRST_CALL_TRANSACTION + 13);
}
// Register to the Liveview application
// cb - callback instance
// imageMenu - path to the menu bitmap
// pluginName - name of the plugin - must be unique
// selectableMenu - is set to true if controlling display and getting buttons. Set to false to only handle announces
// packageName - the package name (use getPackageName()).
// returns id of plugin in system, 0 means that the registration failed

public int register(com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 cb, java.lang.String imageMenu, java.lang.String pluginName, boolean selectableMenu, java.lang.String packageName) throws android.os.RemoteException;
// This method should be called if the application/service is uninstalled using the phone application handler 
// id - the plugin id received in registerPlugin
// cb - the callback

public void unregister(int id, com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 cb) throws android.os.RemoteException;
// Used to send announcements to the device - can only be used when _not_ registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// imageAnnounce - the path to the announce bitmap
// header - header text
// body - body text
// time - timestamp for this announce in milliseconds
// openInPhoneAction - a tag to use for openInPhone callback. Set to null when announce not selectable

public void sendAnnounce(int id, java.lang.String imageAnnounce, java.lang.String header, java.lang.String body, long timestamp, java.lang.String openInPhoneAction) throws android.os.RemoteException;
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// image - the path to the image on file system

public void sendImage(int id, int x, int y, java.lang.String image) throws android.os.RemoteException;
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// bitmapData - the bitmap to send

public void sendImageAsBitmap(int id, int x, int y, android.graphics.Bitmap bitmapData) throws android.os.RemoteException;
// Clears the display, for example if several images are sent while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin

public void clearDisplay(int id) throws android.os.RemoteException;
// Provide the Liveview application with means to launch the service 
// that shoul receive and send data in sandbox mode - Must be called if you registered as "selectableMenu"
// launcherIntent - the intent to start the plugin service
// pluginName - the name of the plugin, must match the name you registered with! 
// returns -1 for failure, 0 for already registered, anything else for success

public int notifyInstalled(java.lang.String launcherIntent, java.lang.String pluginName) throws android.os.RemoteException;
// Controls LED - can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// rgb565 - the color to use
// delayTime - the delay in ms
// onTime - the on time in ms

public void ledControl(int id, int rgb565, int delayTime, int onTime) throws android.os.RemoteException;
// Controls Vibration - can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// delayTime - the delay in ms
// onTime - the on time in ms

public void vibrateControl(int id, int delayTime, int onTime) throws android.os.RemoteException;
// Used to send image data to the device while in sandbox mode - Can only be used if you registered as "selectableMenu"
// id - the plugin id received in registerPlugin
// x - from left side
// y - from top side
// bitmapBytes - the byteArray containing the bitmap data

public void sendImageAsBitmapByteArray(int id, int x, int y, byte[] bitmapByteArray) throws android.os.RemoteException;
// Used to put the screen in powersave mode
// id - the plugin id received in registerPlugin

public void screenOff(int id) throws android.os.RemoteException;
// Used to put the screen in dimmed mode
// id - the plugin id received in registerPlugin

public void screenDim(int id) throws android.os.RemoteException;
// Used to wake the screen from powersave mode
// id - the plugin id received in registerPlugin

public void screenOn(int id) throws android.os.RemoteException;
// Used to set the to powersave mode "AUTO"
// id - the plugin id received in registerPlugin

public void screenOnAuto(int id) throws android.os.RemoteException;
}
