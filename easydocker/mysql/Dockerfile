# MySQL 8.0 버전을 베이스 이미지로 사용
FROM mysql:8.0

# utf-8
COPY ./my.cnf /etc/mysql/my.cnf

# init.sql 파일을 /docker-entrypoint-initdb.d/ 로 복사, /docker-entrypoint-initdb.d/에 있는 sql문은 컨테이너가 처음 실행 시 자동 실행됨
COPY ./init/ /docker-entrypoint-initdb.d/

# # 계정 정보 설정
# ENV MYSQL_DATABASE=
# ENV MYSQL_USER=
# ENV MYSQL_PASSWORD=
# ENV MYSQL_ROOT_PASSWORD=

# MySQL 서버 실행 포트
EXPOSE 3306

# 컨테이너 실행 시 실행될 명령
CMD ["mysqld"]
