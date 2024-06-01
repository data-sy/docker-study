# Docker 이미지 빌드 및 푸시
docker buildx build --push --platform linux/amd64,linux/arm64 -t mmt2024/mmt-redis:1.0.0 . --no-cache
# docker build -t mmt2024/mmt-redis:1.0.0 . --no-cache
# docker push mmt2024/mmt-redis:1.0.0

# 컨테이너 생성
# docker run -d --name mmt-redis --network mmt-network -e REDIS_PASSWORD=비번 mmt2024/mmt-redis:1.0.0
docker run -d --name mmt-redis --network mmt-network mmt2024/mmt-redis:1.0.0

# 로그 확인
docker logs -f mmt-redis

# # 컨테이너 명령어 실행
# docker exec -it mmt-redis redis-cli -a 비번

# # EC2
# docker exec -it ec2-user-mmt-redis-1 redis-cli -a 비번

# # 데이터 조회
# SET mykey "Hello, Redis!"
# GET mykey

# CICD 테스트
