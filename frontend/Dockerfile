FROM node:18-alpine AS builder
WORKDIR /app
COPY package.json package-lock.json ./
# Remove o cache do npm para garantir uma instalação limpa
RUN npm cache clean --force
# Instala todas as dependências
RUN npm install
COPY . .
RUN npm run build

# Etapa de execução
FROM nginx:stable-alpine
COPY --from=builder /app/build /usr/share/nginx/html
EXPOSE 80
CMD ["nginx", "-g", "daemon off;"]