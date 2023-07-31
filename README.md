Execute command in order

./mvnw clean package -DskipTests

cd ./src/main/docker

cp ../../../target/bankapp-0.0.1-SNAPSHOT.jar ../../../src/main/docker

For run application, 

docker-compose up --build -d

Postman Collection : BankAPP-Colletions.postman_collection.json




