# knative-riff-spring-cloud-function [![Build Status](https://travis-ci.org/daggerok/knative-riff-spring-cloud-function.svg?branch=master)](https://travis-ci.org/daggerok/knative-riff-spring-cloud-function)
Project riff | KNative | Spring Cloud Functions | Spring Cloud Gateway

Status: IN PROGRESS

## plain java

request:

```bash
http :8000/function name=real
# output:
HTTP/1.1 200 OK
Content-Length: 16
Content-Type: application/json
accept-encoding: gzip, deflate
connection: keep-alive
user-agent: HTTPie/2.0.0
```

response:

```json
{
    "upper": "REAL"
}
```

---

request:

```bash
http post :8080/api/function name=gw
# output:
HTTP/1.1 200 OK
Content-Length: 14
Content-Type: application/json
Content-Type: application/json
accept-encoding: gzip, deflate
forwarded: proto=http;host="localhost:8080";for="0:0:0:0:0:0:0:1:56827"
user-agent: HTTPie/2.0.0
x-forwarded-for: 0:0:0:0:0:0:0:1
x-forwarded-host: localhost:8080
x-forwarded-port: 8080
x-forwarded-prefix: /api
x-forwarded-proto: http
```

response:

```json
{
  "upper": "GW"
}
```

## docker / docker-compose

```bash
docker-compose build --force-rm --no-cache
docker-compose up --build
http :/api/function name=docker
```

## resources

* [YouTube: KNative and riff for Spring Developers](https://www.youtube.com/watch?v=zCObFAhrhJM)
* [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)

<!--

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Function](https://cloud.spring.io/spring-cloud-function/)
* [Various sample apps using Spring Cloud Function](https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-samples)

-->
