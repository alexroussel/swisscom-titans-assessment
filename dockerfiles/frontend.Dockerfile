FROM nginx:alpine

COPY ../frontend/nginx.conf /etc/nginx/conf.d/default.conf