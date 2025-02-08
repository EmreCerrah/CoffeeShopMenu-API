# Build aşaması için temel image
FROM eclipse-temurin:21 AS build

# Maven'ı kuruyoruz
RUN apt-get update && apt-get install -y maven

# Uygulama dosyalarını kopyala
COPY . .

# Maven kullanarak JAR dosyasını oluştur
RUN mvn clean package -DskipTests

# Çalışma aşaması için daha hafif bir base image
FROM eclipse-temurin:21

# Uygulamanın çalışacağı portu aç
EXPOSE 8080

# Build aşamasında oluşturulan JAR dosyasını kopyala
COPY --from=build /target/*.jar app.jar

# Uygulamayı çalıştır
ENTRYPOINT ["java", "-jar", "app.jar"]