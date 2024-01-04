# Market API
This project was made to learn Spring framework.

It uses:   
- Spring Data
- Spring Core
- Swagger/Swagger UI

## How to run
1. Make sure you are running under Java 17.
2. Have a PosgreSQL database with the schema and data that you can find on [here](/schema-data.sql).
3. Update environment variables of `src/main/resources/application-dev.properties`.
4. Run it with IntelliJ IDEA or a command terminal.

## How to deploy
1. I recommend Vercel PostgreSQL database because it has a free tier.
2. For hosting the spring `jar` I recommend [render.com](https://render.com).
3. Build the backend on graddle with `graddle bootJar`.
4. Copy and rename `application-dev.properties` to `application-pdn.properties` for production information. 
5. Run the `.jar` with `java -jar -Dspring.profiles.active=pdn build/libs/market-x.x.x.jar`.