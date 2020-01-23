FROM openjdk:8u242-jre-stretch
ENV JAVA_OPTS='-Xmx128m -Djava.security.edg=file:/dev/./random -XX:TieredStopAtLevel=1 -noverify' \
    MAIN_CLASS='com.example.knativeriffspringcloudfunction.KNativeRiffSpringCloudFunctionApplication'
ENTRYPOINT ["/bin/bash", "-c"]
CMD ["java ${JAVA_OPTS} -cp /tmp/app:/tmp/app/lib/* ${MAIN_CLASS}"]
VOLUME /tmp
COPY target/dependency/BOOT-INF/lib/     /tmp/app/lib/
COPY target/dependency/META-INF/         /tmp/app/META-INF/
COPY target/dependency/BOOT-INF/classes/ /tmp/app/
