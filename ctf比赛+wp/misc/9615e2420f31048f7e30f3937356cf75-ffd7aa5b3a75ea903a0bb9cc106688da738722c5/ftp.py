#!/usr/bin/env python
# -*- coding: utf-8 -*-
# @Time    : 2021/9/13 12:10
# @Author  : upload
# @File    : ftp.py
# @Software: PyCharm
import socket

host = '0.0.0.0'
port = 2334
sk = socket.socket()
sk.bind((host, port))
sk.listen(5)

conn, address = sk.accept()
conn.send("200 \n")
print '200'
print conn.recv(20)

conn.send("200 \n")
print '200'
print conn.recv(20)

conn.send("200 \n")
print '200'
print conn.recv(20)

conn.send("300 \n")
print '300'
print conn.recv(20)

conn.send("200 \n")
print '200'
print conn.recv(20)
print "ck"
conn.send("227 127,0,0,1,0,9001\n")
print '200'
print conn.recv(20)

conn.send("150 \n")
print '150'
print conn.recv(20)
conn.close()
exit()