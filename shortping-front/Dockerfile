# 1. Node.js 환경에서 빌드 단계
FROM node:18-alpine AS build

# 2. 작업 디렉토리 설정
WORKDIR /app

# 3. 패키지 설치
COPY package*.json ./

RUN npm ci

# 4. 프로젝트 소스 복사
COPY . .

# 5. 애플리케이션 빌드
RUN npm run build

# 6. Nginx를 사용한 서빙 단계
FROM nginx:alpine

# 7. Nginx의 기본 HTML 폴더에 빌드된 파일을 복사
COPY --from=build /app/dist /usr/share/nginx/html

# 9. Nginx 컨테이너가 실행될 때 포트 노출
EXPOSE 80

# 10. Nginx 실행
CMD ["nginx", "-g", "daemon off;"]
