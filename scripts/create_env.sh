#!/bin/bash
APP_DIR=/home/ubuntu/app

# Parameter Store에서 값 가져오기
DB_URL=$(aws ssm get-parameter --name "/blive/prod/DB_URL" --with-decryption --query "Parameter.Value" --output text)
DB_USER=$(aws ssm get-parameter --name "/blive/prod/DB_USERNAME" --with-decryption --query "Parameter.Value" --output text)
DB_PASSWORD=$(aws ssm get-parameter --name "/blive/prod/DB_PASSWORD" --with-decryption --query "Parameter.Value" --output text)
OPENAI_API_KEY=$(aws ssm get-parameter --name "/blive/prod/OPENAI_API_KEY" --with-decryption --query "Parameter.Value" --output text)

# .env 파일 생성
cat > $APP_DIR/.env <<EOL
DB_URL=$DB_URL
DB_USER=$DB_USER
DB_PASSWORD=$DB_PASSWORD
OPENAI_API_KEY=$OPENAI_API_KEY
EOL

echo ".env file created at $APP_DIR/.env"
