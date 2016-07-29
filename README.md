IMAP
=====
主要目的在于不用直接操作SDK中的代码，所有接口都使用自己封装的接口

结构
------
总共3个module和1个demo


 ### common：
 一套统一的抽象的地图操作接口

 ### amap:
 基于common和amapSDK 封装的接口，使用高德地图是，引入改module即可

 ### bdmap:
 基于common和baiduSDK 封装的接口，使用百度地图是，引入改module即可

 ### 注意：
 使用百度SDK时，由于百度的变态要求，需要在Application中调用“SDKInitializer.initialize(getApplicationContext());”
 这个静态方法并没有添加到common中

 ### assest冲突
 高德和百度assets中有一个文件lineDashTexture.png冲突了，随便找一家的sdk，解压找到assets目录这个文件删除即可。