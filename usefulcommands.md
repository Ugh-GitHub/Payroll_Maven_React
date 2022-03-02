npx webpack
mvn clean install
./mvnw spring-boot:run
npm run-script watch
<!-- Puts webpack into watch mode. It will regenerate bundle.js as you edit the source, allowing automatic updates UI when javascript is changed. -->