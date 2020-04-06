call docker-compose.exe down

call mvn clean install

call docker build ./ -t springbootapp
