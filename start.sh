#!/bin/bash
docker pull suttonwang/image:latest
docker rm -f farm||true&&docker run --name=farm-springboot -d -p 8888:9241 suttonwang/image:latest
docker image prune -af

