#!/usr/bin/env bash

##
## Install Boost
##
curl -L -o boost_1_67_0.tar.bz2 https://dl.bintray.com/boostorg/release/1.67.0/source/boost_1_67_0.tar.bz2
tar --bzip2 -xf boost_1_67_0.tar.bz2
cd boost_1_67_0
./bootstrap.sh
sudo ./b2 threading=multi address-model=64 variant=release stage install

##
## Install libevent
##
curl -L -o libevent-2.1.8-stable.tar.gz https://github.com/libevent/libevent/releases/download/release-2.1.8-stable/libevent-2.1.8-stable.tar.gz
tar -xvzf libevent-2.1.8-stable.tar.gz
cd libevent-2.1.8-stable
./configure LDFLAGS='-L/usr/local/opt/openssl/lib' CPPFLAGS='-I/usr/local/opt/openssl/include'
make
sudo make install

##
## Install Thrift
##   Ref: https://thrift.apache.org/docs/BuildingFromSource
##
curl -L -o thrift-0.11.0.tar.gz http://www-us.apache.org/dist/thrift/0.11.0/thrift-0.11.0.tar.gz
tar -xvzf thrift-0.11.0.tar.gz
cd thrift-0.11.0
./bootstrap.sh
#./configure
./configure LDFLAGS='-L/usr/local/opt/openssl/lib' CPPFLAGS='-I/usr/local/opt/openssl/include'
#./configure --prefix=/usr/local/ --with-boost=~/Workspace LDFLAGS='-L/usr/local/opt/openssl/lib' CPPFLAGS='-I/usr/local/opt/openssl/include'
#--with-libevent=~/Workspace
make
#make check
#sh test/test.sh
sudo make install
