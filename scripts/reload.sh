#!/bin/sh
URL=http://localhost:8080


mvn compile war:exploded
wget -O /dev/null $URL/_ah/reloadwebapp > /dev/null || true
