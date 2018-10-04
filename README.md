# Using OpenJDK 11 on Cloud Foundry

## Build with Docker

```
docker run --rm \
           -v ~/.m2:/root/.m2 \
           -v "$PWD":/usr/src \
           -w /usr/src \
           maven:3-jdk-11 \
           mvn clean package
```

## cf push!

In order to use JDK 11, you need to use java buildpack v4.16+.
The jre version should be set in `JBP_CONFIG_OPEN_JDK_JRE`.

`manifest.yml` will look like

```
applications:
- name: hello-java11
  buildpack: https://github.com/cloudfoundry/java-buildpack.git#v4.16
  path: target/demo-java11-0.0.1-SNAPSHOT.jar
  memory: 1g
  env:
    JBP_CONFIG_OPEN_JDK_JRE: '{ jre: { version: 11.+}}'
```

then,

```
cf push
```

🎉