FROM eclipse-temurin:17.0.6_10-jre

LABEL org.opencontainers.image.title="song-library-app-gateway"
LABEL org.opencontainers.image.authors="Oskar Wilda"
LABEL org.opencontainers.image.vendor="Gdańsk University of Technology"
LABEL org.opencontainers.image.version="1.0.0-SNAPSHOT"

ENV VERSION="1.0.0-SNAPSHOT"

ENV SERVER_PORT=8080

ENV SPRING_DATASOURCE_URL=jdbc:h2:mem:song-library-app-gateway
ENV SPRING_DATASOURCE_DRIVERCLASSNAME=org.h2.Driver
ENV SPRING_DATASOURCE_USERNAME=admin
ENV SPRING_DATASOURCE_PASSWORD=password

ENV SPRING_JPA_DATABASE_PLATFORM=org.hibernate.dialect.H2Dialect
ENV SPRING_JPA_GENERATE_DDL=true
ENV SPRING_JPA_HIBERNATE_DDL_AUTO=update

ENV SPRING_H2_CONSOLE_enabled=true

ENV LIBRARY_GATEWAY_HOST=localhost:8080
ENV LIBRARY_SONG_URL=http://localhost:8081
ENV LIBRARY_SINGER_URL=http://localhost:8082

EXPOSE 8080

COPY target/*.jar /opt/song-library-app-gateway/song-library-app-gateway.jar

CMD ["java", "-jar", "/opt/song-library-app-gateway/song-library-app-gateway.jar"]