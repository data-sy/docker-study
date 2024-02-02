FROM python:3.9.5-slim

WORKDIR /app

COPY . /app

RUN python3 -m venv venv && . venv/bin/activate
RUN python3 -m pip install --upgrade pip
RUN pip3 install -r requirements_flask.txt

ENTRYPOINT ["python3", "-m", "flask", "run"]
CMD ["--host=0.0.0.0"]
