# 베이스 이미지
FROM emacski/tensorflow-serving:latest

# 모델을 컨테이너의 모델 디렉토리로 복사
# '/models/my_model/1/' 경로에 저장할 수 있도록 설정
COPY ./savedmodel /models/my_model/1

# 환경 변수 설정
ENV MODEL_NAME=my_model

# 텐서플로우 서빙을 시작합니다.
ENTRYPOINT ["/usr/bin/tensorflow_model_server", "--port=8501", "--model_name=my_model", "--model_base_path=/models/my_model"]
