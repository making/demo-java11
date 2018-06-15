# Using OpenJDK 10 on Cloud Foundry

## Build with Docker

```
docker run --rm \
           -v ~/.m2:/root/.m2 \
           -v "$PWD":/usr/src \
           -w /usr/src \
           maven:3-jdk-10 \
           mvn clean package
```

## cf push!

In order to use JDK 10, you need to use online buildpack (or custom offline buildpack) as offline buildpacks are [packaged with a single JDK](https://github.com/cloudfoundry/java-buildpack/releases) (e.g. `1.8.0_172` for Java Buildpack v4.12).
The jre version should be set in `JBP_CONFIG_OPEN_JDK_JRE`.

`manifest.yml` will look like

```
applications:
- name: hello-java10
  buildpack: https://github.com/cloudfoundry/java-buildpack.git#v4.12
  path: target/demo-java10-0.0.1-SNAPSHOT.jar
  memory: 1g
  env:
    # https://java-buildpack.cloudfoundry.org/openjdk/trusty/x86_64/index.yml
    JBP_CONFIG_OPEN_JDK_JRE: '{ jre: { version: 10.0.+}}'
```

then,

```
cf push
```

🎉