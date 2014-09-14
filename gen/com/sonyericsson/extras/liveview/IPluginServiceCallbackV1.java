/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/akbkuku/Projects/2048LiveView/src/com/sonyericsson/extras/liveview/IPluginServiceCallbackV1.aidl
 */
package com.sonyericsson.extras.liveview;
public interface IPluginServiceCallbackV1 extends android.os.IInterface
{
/** Local-side IPC implementation stub class. */
public static abstract class Stub extends android.os.Binder implements com.sonyericsson.extras.liveview.IPluginServiceCallbackV1
{
private static final java.lang.String DESCRIPTOR = "com.sonyericsson.extras.liveview.IPluginServiceCallbackV1";
/** Construct the stub at attach it to the interface. */
public Stub()
{
this.attachInterface(this, DESCRIPTOR);
}
/**
 * Cast an IBinder object into an com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 interface,
 * generating a proxy if needed.
 */
public static com.sonyericsson.extras.liveview.IPluginServiceCallbackV1 asInterface(android.os.IBinder obj)
{
if ((obj==null)) {
return null;
}
android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
if (((iin!=null)&&(iin instanceof com.sonyericsson.extras.liveview.IPluginServiceCallbackV1))) {
return ((com.sonyericsson.extras.liveview.IPluginServiceCallbackV1)iin);
}
return new com.sonyericsson.extras.liveview.IPluginServiceCallbackV1.Stub.Proxy(obj);
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
case TRANSACTION_startPlugin:
{
data.enforceInterface(DESCRIPTOR);
this.startPlugin();
reply.writeNoException();
return true;
}
case TRANSACTION_stopPlugin:
{
data.enforceInterface(DESCRIPTOR);
this.stopPlugin();
reply.writeNoException();
return true;
}
case TRANSACTION_getPluginName:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _result = this.getPluginName();
reply.writeNoException();
reply.writeString(_result);
return true;
}
case TRANSACTION_openInPhone:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
this.openInPhone(_arg0);
reply.writeNoException();
return true;
}
case TRANSACTION_onUnregistered:
{
data.enforceInterface(DESCRIPTOR);
this.onUnregistered();
reply.writeNoException();
return true;
}
case TRANSACTION_displayCaps:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
int _arg1;
_arg1 = data.readInt();
this.displayCaps(_arg0, _arg1);
reply.writeNoException();
return true;
}
case TRANSACTION_button:
{
data.enforceInterface(DESCRIPTOR);
java.lang.String _arg0;
_arg0 = data.readString();
boolean _arg1;
_arg1 = (0!=data.readInt());
boolean _arg2;
_arg2 = (0!=data.readInt());
this.button(_arg0, _arg1, _arg2);
reply.writeNoException();
return true;
}
case TRANSACTION_screenMode:
{
data.enforceInterface(DESCRIPTOR);
int _arg0;
_arg0 = data.readInt();
this.screenMode(_arg0);
reply.writeNoException();
return true;
}
}
return super.onTransact(code, data, reply, flags);
}
private static class Proxy implements com.sonyericsson.extras.liveview.IPluginServiceCallbackV1
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
// Start the plugin.

@Override public void startPlugin() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_startPlugin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Stop the plugin.
// A stopped plugin should stop its polling, but can stay alive

@Override public void stopPlugin() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_stopPlugin, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Should return the name the plugin used to register itself with

@Override public java.lang.String getPluginName() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
java.lang.String _result;
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_getPluginName, _data, _reply, 0);
_reply.readException();
_result = _reply.readString();
}
finally {
_reply.recycle();
_data.recycle();
}
return _result;
}
// Give the action needed to open the current announcement on the phone
// such as a view in browser action or something else that your application
// responds to.

@Override public void openInPhone(java.lang.String openInPhoneAction) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(openInPhoneAction);
mRemote.transact(Stub.TRANSACTION_openInPhone, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Kicked out by framework. Implement this with stopSelf()

@Override public void onUnregistered() throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
mRemote.transact(Stub.TRANSACTION_onUnregistered, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// displayWidthPixels equals 0 and displayheigthPixels equals 0
// means no available device is attached, or has no display

@Override public void displayCaps(int displayWidthPixels, int displayHeigthPixels) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(displayWidthPixels);
_data.writeInt(displayHeigthPixels);
mRemote.transact(Stub.TRANSACTION_displayCaps, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Button event - note that doublepress is not implemented for the V1
// interface but still left here for compatibility reasons.

@Override public void button(java.lang.String buttonType, boolean doublepress, boolean longpress) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeString(buttonType);
_data.writeInt(((doublepress)?(1):(0)));
_data.writeInt(((longpress)?(1):(0)));
mRemote.transact(Stub.TRANSACTION_button, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
// Screen mode changed event - this notifies the current active sandbox plugin that the screen has been 
// turned on or off. 0 = Screen OFF, 1 = Screen ON

@Override public void screenMode(int screenMode) throws android.os.RemoteException
{
android.os.Parcel _data = android.os.Parcel.obtain();
android.os.Parcel _reply = android.os.Parcel.obtain();
try {
_data.writeInterfaceToken(DESCRIPTOR);
_data.writeInt(screenMode);
mRemote.transact(Stub.TRANSACTION_screenMode, _data, _reply, 0);
_reply.readException();
}
finally {
_reply.recycle();
_data.recycle();
}
}
}
static final int TRANSACTION_startPlugin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
static final int TRANSACTION_stopPlugin = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
static final int TRANSACTION_getPluginName = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
static final int TRANSACTION_openInPhone = (android.os.IBinder.FIRST_CALL_TRANSACTION + 3);
static final int TRANSACTION_onUnregistered = (android.os.IBinder.FIRST_CALL_TRANSACTION + 4);
static final int TRANSACTION_displayCaps = (android.os.IBinder.FIRST_CALL_TRANSACTION + 5);
static final int TRANSACTION_button = (android.os.IBinder.FIRST_CALL_TRANSACTION + 6);
static final int TRANSACTION_screenMode = (android.os.IBinder.FIRST_CALL_TRANSACTION + 7);
}
// Start the plugin.

public void startPlugin() throws android.os.RemoteException;
// Stop the plugin.
// A stopped plugin should stop its polling, but can stay alive

public void stopPlugin() throws android.os.RemoteException;
// Should return the name the plugin used to register itself with

public java.lang.String getPluginName() throws android.os.RemoteException;
// Give the action needed to open the current announcement on the phone
// such as a view in browser action or something else that your application
// responds to.

public void openInPhone(java.lang.String openInPhoneAction) throws android.os.RemoteException;
// Kicked out by framework. Implement this with stopSelf()

public void onUnregistered() throws android.os.RemoteException;
// displayWidthPixels equals 0 and displayheigthPixels equals 0
// means no available device is attached, or has no display

public void displayCaps(int displayWidthPixels, int displayHeigthPixels) throws android.os.RemoteException;
// Button event - note that doublepress is not implemented for the V1
// interface but still left here for compatibility reasons.

public void button(java.lang.String buttonType, boolean doublepress, boolean longpress) throws android.os.RemoteException;
// Screen mode changed event - this notifies the current active sandbox plugin that the screen has been 
// turned on or off. 0 = Screen OFF, 1 = Screen ON

public void screenMode(int screenMode) throws android.os.RemoteException;
}
