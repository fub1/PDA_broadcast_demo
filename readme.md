# PDA 扫码测试Demo
- 使用PDA扫码测试Demo，可以快速的测试PDA扫码功能，包括扫码枪和PDA内置扫码功能。
- jetpack compose实现界面
    - 界面组件全部使用Material Design3风格
    - 弃用Livedata，使用State+Effect+flow实现界面数据更新
- PDA以系统广播的方式发送扫码数据，通过BroadcastReceiver接收扫码数据
    - PDA扫码广播名称`com.v.b`
    - 广播键值`eee`
    - BroadcastReceiver需要兼容Android 12 API 31关于系统广播权限的变化
- 界面使用TextField实现，通过监听TextField的值变化，获取当前扫码数据
- LasyColumn列表展示扫码历史数据
  给出详细完整文件，我需要在ide中测试运行

# 项目说明
本项目适配Android8.0及以上版本

# 开发使用的PDA
- PDA型号1：`东集 小码哥GE`
- PDA型号2：`霍尼韦尔 EDA51`
- PDA型号3：`优博讯 CT40`
# 一般设备，广播可设置为
    - PDA扫码广播名称`com.v.b`
    - 广播键值`eee`
# 斑马设备，广播可设置为
    - PDA扫码广播名称`com.v.b`
    - 广播键值`com.symbol.datawedge.data_string`

# 后续任务
- [ ] 适配斑马PDA多条码扫码
- [ ] 通过发送广播方式，管理PDA扫码功能设置