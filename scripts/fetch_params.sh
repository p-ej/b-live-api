#!/bin/bash

DB_URL=$(aws ssm get-parameter --name "/blive/prod/DB_URL" --with-decryption --query "Parameter.Value" --output text)
DB_USERNAME=$(aws ssm get-parameter --name "/blive/prod/DB_USERNAME" --with-decryption --query "Parameter.Value" --output text)
DB_PASSWORD=$(aws ssm get-parameter --name "/blive/prod/DB_PASSWORD" --with-decryption --query "Parameter.Value" --output text)
OPENAI_API_KEY=$(aws ssm get-parameter --name "/blive/prod/OPENAI_API_KEY" --with-decryption --query "Parameter.Value" --output text)

# 환경변수 등록 (systemd나 세션에서 쓸 수 있도록)
echo "export DB_URL=$DB_URL" >> /etc/profile.d/blive.sh
echo "export DB_USERNAME=$DB_USERNAME" >> /etc/profile.d/blive.sh
echo "export DB_PASSWORD=$DB_PASSWORD" >> /etc/profile.d/blive.sh
echo "export OPENAI_API_KEY=$OPENAI_API_KEY" >> /etc/profile.d/blive.sh

source /etc/profile.d/blive.sh
