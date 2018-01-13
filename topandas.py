# -*- coding: utf-8 -*-

"""
将所有数据导出成DataFrame，并持久化。

Created on Sat Oct 28 18:02:06 2017

@author: czfshine
"""

import sys;
sys.path.append("./wechat-dump/")
import wechat
from wechat.parser import WeChatDBParser
import sys, os
import pandas as pd


# config：
base="D:\\wechat\\"

# parser
parser= WeChatDBParser(base+"decrypted.db")
def getallmsg(parser):
    a=[]
    for k in parser.msgs_by_chat:
        a.extend(parser.msgs_by_chat[k])
    return a

def topandas(msgs):
    name=[ 'createTime','chat_nickname','talker','content','type','chat','content_xml_ready','imgPath','msgSvrId','msg_str']
    d={}
    for k in name:
        d[k]=[]
    for m in msgs:
        for n in name:
            d[n].append(getattr(m,n))
    return pd.DataFrame(d, columns=name[1:],index=d['createTime'])
data=topandas(getallmsg(parser))
