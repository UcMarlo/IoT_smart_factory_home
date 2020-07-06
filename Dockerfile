FROM azul/zulu-openjdk-alpine:12.0.2

RUN apk add --no-cache --update \
    bash \
    coreutils

# TODO: amazon cert

COPY target/smart.jar /smart.jar

EXPOSE 8080

CMD bash /smart.jar