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

<!--

TODO...

## k8s riff

```bash
kubectl config current-context
kubectl get pod --all-namespaces -w

brew tap k14s/tap
brew reinstall kapp
kapp version

brew tap k14s/tap
brew reinstall ytt
ytt version

brew reinstall riff

kubectl create ns apps

kapp deploy -y -n apps -a cert-manager -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/cert-manager.yaml
kapp deploy -y -n apps -a kpack -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/kpack.yaml
kapp deploy -y -n apps -a riff-builders -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/riff-builders.yaml
kapp deploy -y -n apps -a riff-build -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/riff-build.yaml

# ytt is used to convert the ingress service to NodePort because Docker for Mac does not support `LoadBalancer` services.
ytt -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/istio.yaml -f https://storage.googleapis.com/projectriff/charts/overlays/service-nodeport.yaml --file-mark istio.yaml:type=yaml-plain | kapp deploy -n apps -a istio -f - -y
kapp deploy -y -n apps -a knative -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/knative.yaml
kapp deploy -y -n apps -a riff-knative-runtime -f https://storage.googleapis.com/projectriff/release/0.5.0-snapshot/riff-knative-runtime.yaml

riff doctor

DOCKER_ID=daggerok
riff credential apply my-creds --docker-hub $DOCKER_ID --set-default-image-prefix
```

_play!_

```bash
riff function create square \
  --git-repo https://github.com/projectriff-samples/node-square  \
  --artifact square.js \
  --tail
```

-->

## resources

* [YouTube: KNative and riff for Spring Developers](https://www.youtube.com/watch?v=zCObFAhrhJM)
* [Spring Cloud Gateway](https://spring.io/projects/spring-cloud-gateway)
* [Project riff](https://projectriff.io/docs/v0.4/getting-started/docker-for-mac)

<!--

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/maven-plugin/)
* [Spring Configuration Processor](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#configuration-metadata-annotation-processor)
* [Spring Boot DevTools](https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#using-boot-devtools)
* [Function](https://cloud.spring.io/spring-cloud-function/)
* [Various sample apps using Spring Cloud Function](https://github.com/spring-cloud/spring-cloud-function/tree/master/spring-cloud-function-samples)

-->
