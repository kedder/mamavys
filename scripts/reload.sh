#!/bin/sh
URL=http://localhost:8080


mvn war:exploded
wget -O /dev/null $URL/_ah/reloadwebapp > /dev/null || true
