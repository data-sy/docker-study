# docker network create mmt-network

#도커 이미지 빌드 및 푸시
docker buildx build --push --platform linux/amd64,linux/arm64 -t mmt2024/mmt-mysql:1.0.0 . --no-cache
# docker push mmt2024/mmt-mysql:1.0.0

# 컨테이너 생성
docker run -d --name mmt-mysql --network mmt-network mmt2024/mmt-mysql:1.0.0

# 로그 확인
docker logs -f mmt-mysql

# # 컨테이너 명령어 실행
# docker exec -it mmt-mysql mysql -u mmt2024 -p mmt

# # 데이터 조회
# $ mmt=# SELECT * FROM users;
# exit;
