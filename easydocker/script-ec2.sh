# 도커 설치
sudo yum install docker -y
# 도커 서비스 시작
sudo service docker start
# 도커 서비스 실행 확인 (Active: active (running))
systemctl status docker.service
# 도커 그룹 권한 설정
sudo usermod -a -G docker ec2-user
# 권한 적용 확인
docker ps
# 이 때, socket 관련 permission denied 나오면
# Docker 데몬 소켓 파일 권한 변경
sudo chmod 666 /var/run/docker.sock
# 다시 권한 적용 확인
docker ps


# 도커 로그인
docker login
# username과 비번 치면 success
# 네트워크 생성
docker network create mmt-network
# 도커 풀 & 런
# msyql
docker pull mmt2024/mmt-mysql:1.0.0
docker run -d --name mmt-mysql -v mysql-vol:/var/lib/mysql --network mmt-network mmt2024/mmt-mysql:1.0.0
# neo4j는 초기화도 진행
docker pull mmt2024/mmt-neo4j:1.0.0
docker run -d --name mmt-neo4j -v neo4j-vol:/data --network mmt-network mmt2024/mmt-neo4j:1.0.0
    # 로그로 서버 started 확인
docker logs -f mmt-neo4j
docker exec -it mmt-neo4j cypher-shell -u neo4j -p myneo4jpw -f /var/lib/neo4j/import/init.cypher
# redis
docker pull mmt2024/mmt-redis:1.0.0
docker run -d --name mmt-redis --network mmt-network mmt2024/mmt-redis:1.0.0
# api
docker pull mmt2024/mmt-backend:1.0.0
docker run -d -e RDB_URL=mmt-mysql -e NOSQL_URL=mmt-redis -e GDB_URL=mmt-neo4j --network mmt-network --name mmt-backend mmt2024/mmt-backend:1.0.0 
# ai
docker pull mmt2024/mmt-ai:1.0.0
docker run -d -p 8000:5000 --network mmt-network --name mmt-ai mmt2024/mmt-ai:1.0.0
# web
docker pull mmt2024/mmt-web:1.0.0
docker run -d -p 80:80 --network mmt-network --name mmt-front mmt2024/mmt-front:1.0.0
