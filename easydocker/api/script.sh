#도커 이미지 빌드 및 푸시
docker build -t mmt2024/mmt-backend:1.0.0 . --no-cache
docker push mmt2024/mmt-backend:1.0.0 

# 컨테이너 생성
docker run -d -p 8080:8080 -e RDB_URL=mmt-mysql -e NOSQL_URL=mmt-redis -e GDB_URL=mmt-neo4j --network mmt-network --name mmt-backend mmt2024/mmt-backend:1.0.0 

# 로그 확인
docker logs -f mmt-backend
