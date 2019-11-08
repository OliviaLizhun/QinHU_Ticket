package qin.hu.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

/**
 * @ProjectName: QinHU_Ticket
 * @Package: qin.hu.utils
 * @ClassName: PermissionString
 * @CreateDate: 2019/11/8 0008 13:34
 * @Description: 权限集合
 * @Version: 1.0
 */

public class PermissionString {

    private final Context context;
    private  String[] permissions = {
            Manifest.permission.CAMERA,//相机
            Manifest.permission.WRITE_EXTERNAL_STORAGE,// 允许程序写入外部存储,如SD卡上写文件
            Manifest.permission.READ_EXTERNAL_STORAGE,// 程序可以读取设备外部存储空间
            Manifest.permission.BLUETOOTH,// 允许程序连接配对过的蓝牙设备
            Manifest.permission.ACCESS_FINE_LOCATION,// 允许程序通过GPS芯片接收卫星的定位信息
            Manifest.permission.ACCESS_COARSE_LOCATION,// 允许程序通过WiFi或移动基站的方式获取用户错略的经纬度信息
            Manifest.permission.BLUETOOTH_ADMIN,// 允许程序进行发现和配对新的蓝牙设备
            Manifest.permission.CHANGE_NETWORK_STATE,// 允许程序改变网络状态,如是否联网
            Manifest.permission.ACCESS_NETWORK_STATE,// 允许程序获取网络信息状态，如当前的网络连接是否有效
            Manifest.permission.MOUNT_UNMOUNT_FILESYSTEMS// 允许程序挂载、反挂载外部文件系统
    };
    ArrayList<String> per = new ArrayList<>();
    private  final int	REQUEST_CODE = 0x004;


    public PermissionString(Context context){
        this.context = context ;
        checkPermission();
        requestPermission();
    }

    /**
     * \
     *
     * @method checkPermission
     * @description 权限集合
     * @date: 2019/11/8 0008 13:57
     * @return: void
     **/
    private void checkPermission(){
        for (String permission : permissions)
        {
            if (PackageManager.PERMISSION_GRANTED != ContextCompat.checkSelfPermission(context,permission))
            {
                per.add(permission);
            }
        }
    }

    /**
     * @method requestPermission
     * @description 申请权限
     * @date: 2019/11/8 0008 13:57
     * @return: void
     **/
    private void requestPermission(){
        if (per!=null && per.size() > 0 )
        {
            String[] p = new String[per.size()];
            ActivityCompat.requestPermissions( (Activity) context, per.toArray( p ), REQUEST_CODE );
        }
    }


/*
1.android.permission.WRITE_USER_DICTIONARY　　允许应用程序向用户词典中写入新词
2.android.permission.WRITE_SYNC_SETTINGS　　写入Google在线同步设置
3.android.permission.WRITE_SOCIAL_STREAM　　读取用户的社交信息流
4.android.permission.WRITE_SMS　　允许程序写短信
5.android.permission.WRITE_SETTINGS　　允许程序读取或写入系统设置
6.android.permission.WRITE_SECURE_SETTINGS　　允许应用程序读取或写入安全系统设置
7.android.permission.WRITE_PROFILE　　允许程序写入个人资料数据
8.com.android.browser.permission.WRITE_HISTORY_BOOKMARKS　　允许一个应用程序写(但不可读)用户的浏览历史和书签
9.android.permission.WRITE_GSERVICES　　允许程序修改Google服务地图
10.android.permission.WRITE_EXTERNAL_STORAGE　　允许程序写入外部存储,如SD卡上写文件
11.android.permission.WRITE_CONTACTS　　写入联系人,但不可读取
12.android.permission.WRITE_CALL_LOG　　允许程序写入（但是不能读）用户的联系人数据
13.android.permission.WRITE_CALENDAR　　允许程序写入日程，但不可读取
14.android.permission.WRITE_APN_SETTINGS　　允许程序写入网络GPRS接入点设置
15.android.permission.WAKE_LOCK　　允许程序在手机屏幕关闭后后台进程仍然运行
16.android.permission.VIBRATE　　允许程序振动
17.android.permission.USE_SIP　　允许程序使用SIP视频服务
18.android.permission.USE_CREDENTIALS　　允许程序请求验证从AccountManager
19.android.permission.UPDATE_DEVICE_STATS　　允许程序更新设备状态
20.com.android.launcher.permission.UNINSTALL_SHORTCUT　　删除快捷方式
21.android.permission.TRANSMIT_IR　　允许使用设备的红外发射器，如果可用
22.android.permission.SYSTEM_ALERT_WINDOW　　允许程序显示系统窗口
23.android.permission.SUBSCRIBED_FEEDS_WRITE　　允许程序写入或修改订阅内容的数据库
24.android.permission.SUBSCRIBED_FEEDS_READ　　允许程序访问订阅信息的数据库
22.android.permission.STATUS_BAR　　允许程序打开、关闭、禁用状态栏
23.android.permission.SIGNAL_PERSISTENT_PROCESSES　　允许程序发送一个永久的进程信号
24.android.permission.SET_WALLPAPER_HINTS　　允许程序设置壁纸建议
25.android.permission.SET_WALLPAPER　　允许程序设置桌面壁纸
26.android.permission.SET_TIME_ZONE　　允许程序设置系统时区
27.android.permission.SET_TIME　　允许程序设置系统时间
28.android.permission.SET_PROCESS_LIMIT　　允许程序设置最大的进程数量的限制
29.android.permission.SET_PREFERRED_APPLICATIONS　　允许程序设置应用的参数，已不再工作具体查看addPackageToPreferred(String) 介绍
30.android.permission.SET_POINTER_SPEED　　无法被第三方应用获得，系统权限
31.android.permission.SET_ORIENTATION　　允许程序设置屏幕方向为横屏或标准方式显示，不用于普通应用
32.android.permission.SET_DEBUG_APP　　允许程序设置调试程序，一般用于开发
33.android.permission.SET_ANIMATION_SCALE　　允许程序设置全局动画缩放
34.android.permission.SET_ALWAYS_FINISH　　允许程序设置程序在后台是否总是退出
36.com.android.alarm.permission.SET_ALARM　　允许程序设置闹铃提醒
37.android.permission.SET_ACTIVITY_WATCHER　　允许程序设置Activity观察器一般用于monkey测试
38.android.permission.SEND_SMS　　允许程序发送短信
39.android.permission.SEND_RESPOND_VIA_MESSAGE　　允许用户在来电的时候用你的应用进行即时的短信息回复。
            40.android.permission.RESTART_PACKAGES　　允许程序结束任务通过restartPackage(String)方法，该方式将在外来放弃
41.android.permission.REORDER_TASKS　　允许程序重新排序系统Z轴运行中的任务
42.android.permission.RECORD_AUDIO　　允许程序录制声音通过手机或耳机的麦克
43.android.permission.RECEIVE_WAP_PUSH　　允许程序接收WAP PUSH信息
44.android.permission.RECEIVE_SMS　　允许程序接收短信
45.android.permission.RECEIVE_MMS　　允许程序接收彩信
46.android.permission.RECEIVE_BOOT_COMPLETED　　允许程序开机自动运行
47.android.permission.REBOOT　　允许程序重新启动设备
48.android.permission.READ_USER_DICTIONARY　　从一个提供器中获取数据，针对对应的提供器，应用程序需要“读访问权限”
            49.android.permission.READ_SYNC_STATS　　允许程序读取同步状态，获得Google在线同步状态
50.android.permission.READ_SYNC_SETTINGS　　允许程序读取同步设置，读取Google在线同步设置
51.android.permission.READ_SOCIAL_STREAM　　读取用户的社交信息流
52.android.permission.READ_SMS　　允许程序读取短信内容
53.android.permission.READ_PROFILE　　访问用户个人资料
54.android.permission.READ_PHONE_STATE　　允许程序访问电话状态
55.android.permission.READ_LOGS　　允许程序读取系统底层日志
56.android.permission.READ_INPUT_STATE　　允许程序读取当前键的输入状态，仅用于系统
57.com.android.browser.permission.READ_HISTORY_BOOKMARKS　　允许程序读取浏览器收藏夹和历史记录
58.android.permission.READ_FRAME_BUFFER　　允许程序读取帧缓存用于屏幕截图
59.android.permission.READ_EXTERNAL_STORAGE　　程序可以读取设备外部存储空间（内置SDcard和外置SDCard）的文件，如果您的App已经添加了“WRITE_EXTERNAL_STORAGE ”权限 ，则就没必要添加读的权限了，写权限已经包含了读权限了。
            60.android.permission.READ_CONTACTS　　允许程序访问联系人通讯录信息
61.android.permission.READ_CALL_LOG　　读取通话记录
62.android.permission.READ_CALENDAR　　允许程序读取用户的日程信息
63.android.permission.PROCESS_OUTGOING_CALLS　　允许程序监视，修改或放弃播出电话
64.android.permission.PERSISTENT_ACTIVITY　　允许程序创建一个永久的Activity，该功能标记为将来将被移除
65.android.permission.NFC　　允许程序执行NFC近距离通讯操作，用于移动支持
66.android.permission.MOUNT_UNMOUNT_FILESYSTEMS　　允许程序挂载、反挂载外部文件系统
67.android.permission.MOUNT_FORMAT_FILESYSTEMS　　允许程序格式化可移动文件系统，比如格式化清空SD卡
68.android.permission.MODIFY_PHONE_STATE　　允许程序修改电话状态，如飞行模式，但不包含替换系统拨号器界面
69.android.permission.MODIFY_AUDIO_SETTINGS　　允许程序修改声音设置信息
70.android.permission.MEDIA_CONTENT_CONTROL　　允许一个应用程序知道什么是播放和控制其内容。不被第三方应用使用。
            71.android.permission.MASTER_CLEAR　　允许程序执行软格式化，删除系统配置信息
72.android.permission.MANAGE_DOCUMENTS　　允许一个应用程序来管理文档的访问，通常是一个文档选择器部分
73.android.permission.MANAGE_APP_TOKENS　　管理创建、摧毁、Z轴顺序，仅用于系统
74.android.permission.MANAGE_ACCOUNTS　　允许程序管理AccountManager中的账户列表
75.android.permission.LOCATION_HARDWARE　　允许一个应用程序中使用定位功能的硬件，不使用第三方应用
76.android.permission.KILL_BACKGROUND_PROCESSES　　允许程序调用killBackgroundProcesses(String).方法结束后台进程
77.android.permission.INTERNET　　允许程序访问网络连接，可能产生GPRS流量
78.android.permission.INTERNAL_SYSTEM_WINDOW　　允许程序打开内部窗口，不对第三方应用程序开放此权限
79.com.android.launcher.permission.INSTALL_SHORTCUT　　创建快捷方式
80.android.permission.INSTALL_PACKAGES　　允许程序安装应用
81.android.permission.INSTALL_LOCATION_PROVIDER　　允许程序安装定位提供
82.android.permission.INJECT_EVENTS　　允许程序访问本程序的底层事件，获取按键、轨迹球的事件流
83.android.permission.HARDWARE_TEST　　允许程序访问硬件辅助设备，用于硬件测试
84.android.permission.GLOBAL_SEARCH　　允许程序允许全局搜索
85.android.permission.GET_TOP_ACTIVITY_INFO　　允许一个应用程序检索私有信息是当前最顶级的活动，不被第三方应用使用
86.android.permission.GET_TASKS　　允许程序获取任务信息
87.android.permission.GET_PACKAGE_SIZE　　允许程序获取应用的文件大小
88.android.permission.GET_ACCOUNTS　　允许程序访问账户Gmail列表
89.android.permission.FORCE_BACK　　允许程序强制使用back后退按键，无论Activity是否在顶层
90.android.permission.FLASHLIGHT　　允许访问闪光灯
91.android.permission.FACTORY_TEST　　允许程序运行工厂测试模式
92.android.permission.EXPAND_STATUS_BAR　　允许程序扩展或收缩状态栏
93.android.permission.DUMP　　允许程序获取系统dump信息从系统服务
94.android.permission.DISABLE_KEYGUARD　　允许程序禁用键盘锁
95.android.permission.DIAGNOSTIC　　允许程序到RW到诊断资源
96.android.permission.DEVICE_POWER　　允许程序访问底层电源管理
97.android.permission.DELETE_PACKAGES　　允许程序删除应用
98.android.permission.DELETE_CACHE_FILES　　允许程序删除缓存文件
99.android.permission.CONTROL_LOCATION_UPDATES　　允许程序获得移动网络定位信息改变
100.android.permission.CLEAR_APP_USER_DATA　　允许程序清除用户数据
101.android.permission.CLEAR_APP_CACHE　　允许程序清除应用缓存
102.android.permission.CHANGE_WIFI_STATE　　允许程序改变WiFi状态
103.android.permission.CHANGE_WIFI_MULTICAST_STATE　　允许程序改变WiFi多播状态
104.android.permission.CHANGE_NETWORK_STATE　　允许程序改变网络状态,如是否联网
105.android.permission.CHANGE_CONFIGURATION　　允许当前应用改变配置，如定位
106.android.permission.CHANGE_COMPONENT_ENABLED_STATE　　改变组件是否启用状态
107.android.permission.CAPTURE_VIDEO_OUTPUT　　允许一个应用程序捕获视频输出，不被第三方应用使用
108.android.permission.CAPTURE_SECURE_VIDEO_OUTPUT　　允许一个应用程序捕获视频输出。不被第三方应用使用
109.android.permission.CAPTURE_AUDIO_OUTPUT　　允许一个应用程序捕获音频输出。不被第三方应用使用
110.android.permission.CAMERA　　允许程序访问摄像头进行拍照
111.android.permission.CALL_PRIVILEGED　　允许程序拨打电话，替换系统的拨号器界面
112.android.permission.CALL_PHONE　　允许程序从非系统拨号器里拨打电话
113.android.permission.BROADCAST_WAP_PUSH　　WAP PUSH服务收到后触发一个广播
114.android.permission.BROADCAST_STICKY　　允许程序收到广播后快速收到下一个广播
115.android.permission.BROADCAST_SMS　　允许程序当收到短信时触发一个广播
116.android.permission.BROADCAST_PACKAGE_REMOVED　　允许程序删除时广播
117.android.permission.BRICK　　能够禁用手机，非常危险，顾名思义就是让手机变成砖头
118.android.permission.BLUETOOTH_PRIVILEGED　　允许应用程序配对蓝牙设备，而无需用户交互。这不是第三方应用程序可用。
            119.android.permission.BLUETOOTH_ADMIN　　允许程序进行发现和配对新的蓝牙设备
120.android.permission.BLUETOOTH　　允许程序连接配对过的蓝牙设备
121.android.permission.BIND_WALLPAPER　　必须通过WallpaperService服务来请求，只有系统才能用
122.android.permission.BIND_VPN_SERVICE　　绑定VPN服务必须通过VpnService服务来请求,只有系统才能用
123.android.permission.BIND_TEXT_SERVICE　　必须要求textservice(例如吗 spellcheckerservice)，以确保只有系统可以绑定到它。
            124.android.permission.BIND_REMOTEVIEWS　　必须通过RemoteViewsService服务来请求，只有系统才能用
125.android.permission.BIND_PRINT_SERVICE　　必须要求由printservice，以确保只有系统可以绑定到它。
            126.android.permission.BIND_NOTIFICATION_LISTENER_SERVICE　　必须要求由notificationlistenerservice，以确保只有系统可以绑定到它。
            127.android.permission.BIND_NFC_SERVICE　　由hostapduservice或offhostapduservice必须确保只有系统可以绑定到它。
            128.android.permission.BIND_INPUT_METHOD　　请求InputMethodService服务，只有系统才能使用
129.android.permission.BIND_DEVICE_ADMIN　　请求系统管理员接收者receiver，只有系统才能使用
130.android.permission.BIND_APPWIDGET　　允许程序告诉appWidget服务需要访问小插件的数据库，只有非常少的应用才用到此权限
131.android.permission.BIND_ACCESSIBILITY_SERVICE　　请求accessibilityservice服务，以确保只有系统可以绑定到它。
            132.android.permission.AUTHENTICATE_ACCOUNTS　　允许程序通过账户验证方式访问账户管理ACCOUNT_MANAGER相关信息
133.com.android.voicemail.permission.ADD_VOICEMAIL　　允许一个应用程序添加语音邮件系统
134.android.permission.ACCOUNT_MANAGER　　允许程序获取账户验证信息，主要为GMail账户信息，只有系统级进程才能访问的权限
135.android.permission.ACCESS_WIFI_STATE　　允许程序获取当前WiFi接入的状态以及WLAN热点的信息
136.android.permission.ACCESS_SURFACE_FLINGER　　Android平台上底层的图形显示支持，一般用于游戏或照相机预览界面和底层模式的屏幕截图
137.android.permission.ACCESS_NETWORK_STATE　　允许程序获取网络信息状态，如当前的网络连接是否有效
138.android.permission.ACCESS_MOCK_LOCATION　　允许程序获取模拟定位信息，一般用于帮助开发者调试应用
139.android.permission.ACCESS_LOCATION_EXTRA_COMMANDS　　允许程序访问额外的定位提供者指令
140.android.permission.ACCESS_FINE_LOCATION　　允许程序通过GPS芯片接收卫星的定位信息
141.android.permission.ACCESS_COARSE_LOCATION　　允许程序通过WiFi或移动基站的方式获取用户错略的经纬度信息
142.android.permission.ACCESS_CHECKIN_PROPERTIES　　允许程序读取或写入登记check-in数据库属性表的权限*/




}
