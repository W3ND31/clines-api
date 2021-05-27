package:
	@ mvn clean package -Dmaven.test.skip=true

docker-image-build: package
	@ docker build -t caelum/clines-api .

run: docker-image-build
	@ docker compose up -d

stop:
	@ docker compose down -v