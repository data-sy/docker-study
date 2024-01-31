# Redis 6.2 버전을 베이스 이미지로 사용
FROM redis:6.2

# 컨테이너에서 사용할 작업 디렉토리 생성
WORKDIR /usr/src/app

# 컨테이너에서 사용할 Redis 구성 파일 복사
COPY config/redis.conf /usr/local/etc/redis/redis.conf

# # Redis 비밀번호 설정
ENV REDIS_PASSWORD myredispw

# Redis 서버 실행 포트
EXPOSE 6379

# 컨테이너 실행 시 실행될 명령
# CMD ["redis-server", "--requirepass", "${REDIS_PASSWORD}"]
CMD ["redis-server", "/usr/local/etc/redis/redis.conf"]
