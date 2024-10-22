# Build 단계
FROM gradle:8.10.2-jdk17-alpine AS build
WORKDIR /app

# 애플리케이션 소스 복사
COPY . /app

# 메모리 및 메타스페이스 크기 설정
ENV GRADLE_OPTS="-Xmx2048m -XX:MaxMetaspaceSize=1024m"
ENV JAVA_OPTS="-Xms1g -Xmx2g"

# Gradle 빌드 캐시 정리 및 빌드 (최대 작업자 수 조정)
RUN gradle clean --no-daemon && gradle clean build --no-daemon --max-workers=1 --stacktrace --info

# 실행 단계
FROM openjdk:17.0-jdk-slim
WORKDIR /app

# 빌드된 JAR 파일 복사
COPY --from=build /app/build/libs/*.jar portfolio.jar

# 포트 노출
EXPOSE 8080

# 애플리케이션 실행
ENTRYPOINT ["java"]
CMD ["-jar", "shortping.jar"]

