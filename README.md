
# 科大讯飞语音识别  
## 1.  开发环境:   	 
	1. android studio   
	2. android API 18  
 	3. sdk  
## 2.注意说明：
	1. 因为appid不同，所以必须重新下载sdk。如果出现用户校验失败，说明sdk和appid不匹配。
	2. 注意配置权限。
	3. build.gradle里添加json解析，cup类型的.so库
## 3.  开发步骤：  
### 1. 首先下载sdk语音听写，因为appid不同所以必须自己账号重新下载。
### 2. 把解压的sdk添加到msc.jar包导入到libs目录下。
###3. 把sdk包下的素材assets文件添加到main目录下。
###4. 创建jnilibs文件，把sdk里libs里其它文件都放进去。
###5. 配置文件添加权限  
	
	 <!--连接网络权限，用于执行云端语音能力 -->
    <uses-permission android:name="android.permission.INTERNET"/>
    <!--获取手机录音机使用权限，听写、识别、语义理解需要用到此权限 -->
    <uses-permission android:name="android.permission.RECORD_AUDIO"/>
    <!--读取网络信息状态 -->
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
    <!--获取当前wifi状态 -->
    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE"/>
    <!--允许程序改变网络连接状态 -->
    <uses-permission android:name="android.permission.CHANGE_NETWORK_STATE"/>
    <!--读取手机信息权限 -->
    <uses-permission android:name="android.permission.READ_PHONE_STATE"/>
    <!--读取联系人权限，上传联系人需要用到此权限 -->
    <uses-permission android:name="android.permission.READ_CONTACTS"/>
    
###6. build.gradle里添加
	1.添加json解析：
	compile 'com.alibaba:fastjson:1.2.8'
	2.选择要添加的对应cpu类型的.so库
	ndk {
	abiFilters 'armeabi', 'arm64-v8a', 'armeabi-v7a', 'x86'
	 }