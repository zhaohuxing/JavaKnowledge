#!/bin/bash

if [ ! -d "$1" ]; then

mkdir $1
mkdir -p $1/src/main/java/
mkdir -p $1/src/main/resources/
mkdir -p $1/src/main/webapp/
mkdir -p $1/src/main/webapp/WEB-INF/
touch $1/src/main/webapp/WEB-INF/web.xml
touch $1/build.gradle

echo "apply plugin:'java'
apply plugin:'war'

repositories {
	mavenCentral()
}

dependencies {

}
" > $1/build.gradle

echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>  
<web-app version=\"2.5\" xmlns=\"http://java.sun.com/xml/ns/javaee\"  
    xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"  
    xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee http://java.sun.com/xml/ns/javaee/web-app_2_5.xsd\">  
</web-app> " > $1/src/main/webapp/WEB-INF/web.xml



else 
	echo "文件已经存在"
fi

