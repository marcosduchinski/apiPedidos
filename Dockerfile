#instalando uma imagem do openjdk 21
FROM openjdk:21
# criando uma pasta para onde o docker vai copiar os arquivos do projeto
WORKDIR /app
# copiando os arquivos do projeto para dentro da pasta /app
COPY . /app
# comand para realizar e deploy do projeto
RUN ./mvnw -B clean package -DskipTests
# porta em que o projeto vai rodar
EXPOSE 8082
# comando para rodar o projeto depois de ser feito o deploy
CMD ["java", "-jar", "target/apiPedidos-0.0.1-SNAPSHOT.jar"]