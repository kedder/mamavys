#!/bin/bash

#
# This script installs the Google App Engine artifacts into you local Maven repository.
#
# If you would like to avoid the need for this step, ask Google by voting for the following issue:
#   http://code.google.com/p/googleappengine/issues/detail?id=1296
#

VERSION=1.4.3
DATANUCLEUS_VERSION=1.0.8.final


if [ "$1" == "" ]
then
    echo "usage: $0 /path/to/appengine-java-sdk-$VERSION"
    exit 1
fi

GAE_SDK_PATH=$1

#mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/user/appengine-api-1.0-sdk-$VERSION.jar -DgroupId=com.google.appengine -DartifactId=appengine-api-1.0-sdk -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar

#mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/user/appengine-api-labs-$VERSION.jar -DgroupId=com.google.appengine -DartifactId=appengine-api-labs -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar

mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/impl/appengine-api.jar -DgroupId=com.google.appengine -DartifactId=appengine-api -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar
mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/impl/appengine-api-stubs.jar -DgroupId=com.google.appengine -DartifactId=appengine-api-stubs -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar
mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/impl/appengine-api-labs.jar -DgroupId=com.google.appengine -DartifactId=appengine-api-labs -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar

mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/testing/appengine-testing.jar -DgroupId=com.google.appengine -DartifactId=appengine-testing -Dversion=$VERSION -DgeneratePom=true -Dpackaging=jar

mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/user/orm/datanucleus-appengine-$DATANUCLEUS_VERSION.jar -DgroupId=com.google.appengine -DartifactId=datanucleus-appengine -Dversion=$DATANUCLEUS_VERSION -DgeneratePom=true -Dpackaging=jar

mvn install:install-file -Dfile=$GAE_SDK_PATH/lib/user/orm/geronimo-jta_1.1_spec-1.1.1.jar -DgroupId=com.google.appengine -DartifactId=geronimo-jta_1.1_spec -Dversion=1.1.1 -DgeneratePom=true -Dpackaging=jar

