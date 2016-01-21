FROM docker.io/java:8
ENV LC_ALL en_US.UTF-8
ENV TZ 'Asia/Shanghai'
ADD build/libs/myThriftServer-1.0.jar /opt/mollydocker/
EXPOSE 18443
WORKDIR /opt/mollydocker/
CMD ["java", "-jar", "myThriftServer-1.0.jar"]
