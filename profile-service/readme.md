# User Profile Service - Mysql setup

#### pom.xml

```
<dependency>
	<groupId>mysql</groupId>
	<artifactId>mysql-connector-java</artifactId>
</dependency>
```

#### src/main/resources/application.properties

```

spring.jpa.hibernate.ddl-auto=update
spring.datasource.url=jdbc:mysql://${RDS_HOSTNAME:localhost}:${RDS_PORT:3306}/${RDS_DB_NAME:exchange-db}
spring.datasource.username=${RDS_USERNAME:exchange-db-user}
spring.datasource.password=${RDS_PASSWORD:dummyexchange}
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL57Dialect
```

## My SQL

### Launching MySQL using Docker

```
docker run --detach --env MYSQL_ROOT_PASSWORD=mysqlpwd --env MYSQL_USER=profile_db_user --env MYSQL_PASSWORD=mysqlpwd --env MYSQL_DATABASE=profile_db --name mysql --publish 3306:3306 mysql:8.0.22
```


### My SQL Shell Client

#### To use on Windows:-
    - Download zip file from https://dev.mysql.com/downloads/shell/
    - Unzip folder and copy content to a folder location
    - Add path variable till bin flder e.g C:\Program Files\MySQL\bin

- Install on mac using `brew install caskroom/cask/mysql-shell`.


```
C:\Users\Owner>mysqlsh
MySQL Shell 8.0.22

Copyright (c) 2016, 2020, Oracle and/or its affiliates.
Oracle is a registered trademark of Oracle Corporation and/or its affiliates.
Other names may be trademarks of their respective owners.

Type '\help' or '\?' for help; '\quit' to exit.
 MySQL  JS > \connect profile_db_user@localhost:3306
Creating a session to 'profile_db_user@localhost:3306'
Please provide the password for 'profile_db_user@localhost:3306': ********
Save password for 'profile_db_user@localhost:3306'? [Y]es/[N]o/Ne[v]er (default No): Y
Fetching schema names for autocompletion... Press ^C to stop.
Your MySQL connection id is 10
Server version: 8.0.22 MySQL Community Server - GPL
No default schema selected; type \use <schema> to set one.
 MySQL  localhost:3306 ssl  JS > \sql
Switching to SQL mode... Commands end with ;
 MySQL  localhost:3306 ssl  SQL > use profile_db
Default schema set to `profile_db`.
Fetching table and column names from `profile_db` for auto-completion... Press ^C to stop.
 MySQL  localhost:3306 ssl  profile_db  SQL > select * from UserProfile;

```

## Containerization

### Creating Containers

- mvn package
- docker run --publish 5200:5200 --network MY_BRIDGE --name userprofile-service puneet3011/userprofile-service:0.0.1-SNAPSHOT

Test API 
- http://localhost:5200/api/v1/profile/getProfiles

```
docker login
docker push puneet3011/userprofile-service:0.0.1-SNAPSHOT
```

## Environment Variables

- /dev/currency-exchange-service/RDS_DB_NAME  - profile_db
- /dev/currency-exchange-service/RDS_HOSTNAME	
- /dev/currency-exchange-service/RDS_PASSWORD	
- /dev/currency-exchange-service/RDS_PORT     - 3306
- /dev/currency-exchange-service/RDS_USERNAME - profile_db_user

## API details

- http://localhost:5200/api/v1/profile/createProfile
- http://3.135.249.149:5200/api/v1/profile/createProfile (Deployed on AWS)

```json
{
  "id": null,
  "name": "Puneet Singh",
  "email": "puneettest@gmail.com",
  "dateOfBirth": "01/01/1900"
}
```

- http://localhost:5200/api/v1/profile/getProfiles
- http://3.135.249.149:5200/api/v1/profile/getProfiles (Deployed on AWS)
