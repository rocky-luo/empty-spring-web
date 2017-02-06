package com.rocky.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * Created by rocky on 16/9/1.
 */
@RequestMapping("/hello")
@Controller
public class HelloController {
    private Logger logger = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/time")
    @ResponseBody
    public String helloWorld() {
        return "hello, world, it is " + new Date();
    }

    @RequestMapping("/myweb")
    public String myweb(Model model) {
        String ct = "建站\n" +
                "===\n" +
                "\n" +
                "## 项目\n" +
                "\n" +
                "* 服务器\n" +
                "* 域名\n" +
                "* DNS及CDN\n" +
                "* nginx\n" +
                "* https\n" +
                "\n" +
                "\n" +
                "## 服务器\n" +
                "\n" +
                "### 虚拟主机\n" +
                "\n" +
                "    利用虚拟技术把一台完整的服务器分成若干个主机，拥有多个网站，共享这台服务器的硬件和带宽的资源，可以托管简单的静态和动态的网站，满足客户最基本的网络托管需求。虚拟主机通常是只有Apache/PHP/MySQL的网站部署环境，没有完整的系统管理和shell访问权限。\n" +
                "    \n" +
                "    优点：价格低，使用方便；\n" +
                "    \n" +
                "    适用：个人博客，简单企业网站\n" +
                "\n" +
                "### VPS（Virtual Private Server）\n" +
                "\n" +
                "    将一台物理服务器分割成多个虚拟专属服务器，每个VPS主机分配独立操作系统，独立的IP地址和独立的应用程序，拥有系统的所有权限。\n" +
                "    \n" +
                "    优点：价格便宜\n" +
                "    \n" +
                "    适用：个人博客，搭梯子，折腾\n" +
                "\n" +
                "### 云主机\n" +
                "\n" +
                "    基于集群服务器，集群中每个主机都有云主机的一个镜像，可以提高虚拟主机的安全性和稳定性，具有更高的灵活性，用户可以自主定义服务器配置。\n" +
                "    \n" +
                "    优点：性能好，安全性高，可扩展性好\n" +
                "        \n" +
                "    适用：大型网站首选\n" +
                "\n" +
                "### VPS购买\n" +
                "\n" +
                "- 选择供应商：国外：Vultr，Digital Ocean，banwagon等等\n" +
                "- 购买VPS（注意选择机房）\n" +
                "- 安装应用（ssh，java。。。等等）\n" +
                "\n" +
                "## 域名\n" +
                "\n" +
                "### 尽量选择在国外网站（godaddy等等）上面购买域名，好处是不需要备案\n" +
                "\n" +
                "![](http://ojoauf3ds.bkt.clouddn.com/a0ea7b49f53c2d7e.png?imageView2/3/w/200/h/200/q/100)\n" +
                "\n" +
                "### 设置DNS解析\n" +
                "\n" +
                "![](http://ojoauf3ds.bkt.clouddn.com/063e7428f307f708.png?imageView2/3/w/200/h/400/q/100)\n" +
                "\n" +
                "### Nginx\n" +
                "\n" +
                "* 安装编译工具及库文件\n" +
                "\n" +
                "```\n" +
                "yum -y install make zlib zlib-devel gcc-c++ libtool  openssl openssl-devel\n" +
                "```\n" +
                "\n" +
                "* 安装PCRE\n" +
                "\n" +
                "```\n" +
                "wget http://downloads.sourceforge.net/project/pcre/pcre/8.35/pcre-8.35.tar.gz\n" +
                "tar zxvf pcre-8.35.tar.gz\n" +
                "cd pcre-8.35\n" +
                "./configure\n" +
                "make && make install\n" +
                "```\n" +
                "\n" +
                "* 安装nginx\n" +
                "\n" +
                "```\n" +
                "下载及解压\n" +
                "./configure --prefix=/usr/local/webserver/nginx --with-http_stub_status_module --with-http_ssl_module --with-pcre=/usr/local/src/pcre-8.35\n" +
                "make && make install\n" +
                "```\n" +
                "\n" +
                "* 配置\n" +
                "\n" +
                "```\n" +
                "worker_processes  1;\n" +
                "\n" +
                "events {\n" +
                "    worker_connections  1024;\n" +
                "}\n" +
                "\n" +
                "\n" +
                "http {\n" +
                "    include       mime.types;\n" +
                "    default_type  application/octet-stream;\n" +
                "    sendfile        on;\n" +
                "    keepalive_timeout  65;\n" +
                "    server {  \n" +
                "            listen  80;  \n" +
                "            server_name 67gogogo.com www.67gogogo.com;  \n" +
                "            rewrite ^(.*)$  https://$host$1 permanent;  \n" +
                "    }\n" +
                "    server {\n" +
                "    listen       443 ssl;\n" +
                "    server_name www.67gogogo.com 67gogogo.com;\n" +
                "    ssl_certificate      /root/tengxunssl/1_www.67gogogo.com_bundle.crt;\n" +
                "    ssl_certificate_key  /root/tengxunssl/2_www.67gogogo.com.key;\n" +
                "    ssl_session_timeout  5m;\n" +
                "    ssl_protocols TLSv1 TLSv1.1 TLSv1.2;\n" +
                "    ssl_ciphers ECDHE-RSA-AES128-GCM-SHA256:HIGH:!aNULL:!MD5:!RC4:!DHE;\n" +
                "    ssl_prefer_server_ciphers  on;\n" +
                "    location / {\n" +
                "            proxy_redirect off;\n" +
                "            proxy_set_header Host $host;\n" +
                "            proxy_set_header X-Real-IP $remote_addr;\n" +
                "            proxy_set_header X-Forwarded-For $proxy_add_x_forwarded_for;\n" +
                "            proxy_pass http://127.0.0.1:8417;\n" +
                "        }\n" +
                "    }\n" +
                "\n" +
                "}\n" +
                "```\n" +
                "\n" +
                "## HTTPS\n" +
                "\n" +
                "### 对称加密和非对称加密\n" +
                "\n" +
                "\t对称加密：加密解密都用同一把密钥，加解密简单快速\n" +
                "\n" +
                "\t非对称加密：加密解密用不同的密钥，一般有两把密钥，公钥和私钥，加解密性能消耗较大\n" +
                "\n" +
                "### https连接建立过程\n" +
                "\n" +
                "![](http://ojoauf3ds.bkt.clouddn.com/5dba9bd04cf767cb.png?imageView2/3/w/200/h/300/q/100)\n" +
                "\n" +
                "1. 客户端发起ssl连接\n" +
                "2. 服务器向客户端发送公钥\n" +
                "3. 客户端用公钥加密对称密钥\n" +
                "4. 客户端将加密后的对称密钥发送给服务器\n" +
                "5. 服务器用私钥解密得到对称密钥\n" +
                "6. 用对称密钥传输数据\n" +
                "\n" +
                "\n" +
                "### 中间人获取对称密钥过程\n" +
                "\n" +
                "![](http://ojoauf3ds.bkt.clouddn.com/29cad45b3c83c8e8.png?imageView2/3/w/200/h/300/q/100)\n" +
                "\n" +
                "1. 客户端向服务器发起的ssl连接被中间人截获\n" +
                "2. 中间人与服务器发起ssl连接，并获得服务器公钥\n" +
                "3. 中间人将自己的公钥（中间人有一套非对称密钥，与服务器的不同）发送给客户端\n" +
                "4. 中间人用自己的私钥解密得到客户端发来的对称密钥\n" +
                "5. 中间人用服务器公钥加密对称密钥并发送给服务\n" +
                "\n" +
                "之后客户端和服务器之间的所有密文全部都会被中间人解密器\n" +
                "\n" +
                "\n" +
                "### CA认证\n" +
                "\n" +
                "1. 服务器将自己的公钥送给认证机构（CA）进行认证\n" +
                "2. 通过认证后CA会颁发证书，证书中包含服务器公钥，数字签名等等\n" +
                "3. 服务器不再将公钥传送给客户端，而是将证书传送给客户端\n" +
                "4. 客户端通过CA校验，判断证书是否伪造，并得到服务器公钥\n" +
                "\n" +
                "### 申请CA证书\n" +
                "\n" +
                "以腾讯SSL证书为例：[认证流程](https://www.qcloud.com/document/product/400/4142)\n" +
                "\t\n" +
                "1. 提交申请\n" +
                "2. 域名验证\n" +
                "3. 下载证书\n" +
                "\n" +
                "Nginx文件夹内获得SSL证书文件 .crt 和私钥文件 .key，将这两个文件放在Nginx服务器上，并在配置中启动ssl\n" +
                "\n" +
                "### DNS及CDN\n" +
                "\n" +
                "1. DNS解析及CDN解析过程\n" +
                "\n" +
                "![](http://ojoauf3ds.bkt.clouddn.com/3ba110d78b3e2eb8.png?imageView2/3/w/200/h/500/q/100)\n" +
                "\n" +
                "2. 目前CDN使用方式\n" +
                "    * 全站镜像（源站域名）\n" +
                "    * 对象存储（图片等文件）\n";
        model.addAttribute("content", ct);
        return "myweb";
    }
}
