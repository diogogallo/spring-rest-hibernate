FROM java:8
VOLUME /tmp
ADD sandbox-0.0.1-SNAPSHOT.jar sandbox.jar
EXPOSE 9025
RUN bash -c 'touch /sandbox.jar'
ENTRYPOINT ["java","-Xmx128m","-Djava.security.egd=file:/dev/./urandom","-jar","/sandbox.jar"]
