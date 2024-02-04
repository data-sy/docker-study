docker network create mmt-network
docker volume create mysql-vol

#도커 이미지 빌드 및 푸시
docker build -t mmt2024/mmt-mysql:2.0.0 . --no-cache
docker push mmt2024/mmt-mysql:2.0.0

# Docker 컨테이너 실행
docker run -d --name mmt-mysql -v mysql-vol:/var/lib/mysql --network mmt-network mmt2024/mmt-mysql:2.0.0

# # 로그 확인
# docker logs -f mmt-mysql

# 컨테이너 스탑 & 삭제
docker stop mmt-mysql
docker rm mmt-mysql

# # 재실행해서 볼륨 확인
# docker run -d --name new-mmt-mysql -v mysql-vol:/var/lib/mysql --network mmt-network mmt2024/mmt-mysql:2.0.0
# docker exec -it new-mmt-mysql mysql -u mmt2024 -p mmt
# # 데이터 조회
# $ mmt=# SELECT * FROM users;
