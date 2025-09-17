# Tally API Docker 部署指南

## 项目概述

这是一个基于Spring Boot 3.0.5的记账API服务，使用Java 17开发。

## 环境要求

- Docker 20.10+
- Docker Compose 2.0+
- 至少2GB可用内存

## 快速开始

### 1. 克隆项目
```bash
git clone <your-repo-url>
cd tally_api
```

### 2. 使用Docker Compose启动（推荐）
```bash
# 启动所有服务
docker-compose up -d

# 查看服务状态
docker-compose ps

# 查看日志
docker-compose logs -f tally-api
```

### 3. 单独构建和运行
```bash
# 构建镜像
docker build -t tally-api .

# 运行容器
docker run -d -p 8002:8002 --name tally-api tally-api
```

## 服务配置

### 应用服务 (tally-api)
- 端口: 8002
- 环境变量: 通过docker-compose.yml配置
- 健康检查: http://localhost:8002/actuator/health

### MySQL服务
- 端口: 3306
- 数据库: tallybook_db
- 用户名: root
- 密码: 1659782099PPP.

### Redis服务
- 端口: 6379
- 无密码

## 推送到Docker Hub

### 1. 登录Docker Hub
```bash
docker login
```

### 2. 修改脚本中的用户名
编辑 `build-and-deploy.sh` 或 `build-and-deploy.ps1`，将 `your-dockerhub-username` 替换为你的Docker Hub用户名。

### 3. 执行部署脚本

**Linux/Mac:**
```bash
chmod +x build-and-deploy.sh
./build-and-deploy.sh
```

**Windows:**
```powershell
.\build-and-deploy.ps1
```

## 环境变量配置

| 变量名 | 默认值 | 说明 |
|--------|--------|------|
| SPRING_PROFILES_ACTIVE | prod | Spring Boot配置文件 |
| SPRING_DATASOURCE_URL | jdbc:mysql://mysql:3306/tallybook_db | 数据库连接URL |
| SPRING_DATASOURCE_USERNAME | root | 数据库用户名 |
| SPRING_DATASOURCE_PASSWORD | 1659782099PPP. | 数据库密码 |
| SPRING_REDIS_HOST | redis | Redis主机 |
| SPRING_REDIS_PORT | 6379 | Redis端口 |

## 数据持久化

- MySQL数据: `mysql_data` 卷
- Redis数据: `redis_data` 卷
- 应用日志: `tally_logs` 卷

## 监控和日志

### 查看容器状态
```bash
docker-compose ps
```

### 查看应用日志
```bash
docker-compose logs -f tally-api
```

### 查看数据库日志
```bash
docker-compose logs -f mysql
```

### 查看Redis日志
```bash
docker-compose logs -f redis
```

## 故障排除

### 1. 应用无法启动
- 检查MySQL和Redis是否正常运行
- 查看应用日志: `docker-compose logs tally-api`
- 确认端口8002未被占用

### 2. 数据库连接失败
- 检查MySQL容器状态: `docker-compose ps mysql`
- 确认数据库初始化脚本已执行
- 检查网络连接: `docker network ls`

### 3. Redis连接失败
- 检查Redis容器状态: `docker-compose ps redis`
- 确认Redis端口6379可访问

## 生产环境部署

### 1. 修改配置
- 更新 `application-docker.yml` 中的敏感信息
- 使用环境变量或Docker secrets管理密码
- 配置日志轮转和监控

### 2. 安全配置
- 限制容器资源使用
- 配置防火墙规则
- 使用非root用户运行容器
- 定期更新基础镜像

### 3. 备份策略
- 定期备份MySQL数据
- 配置日志归档
- 监控磁盘空间使用

## 常用命令

```bash
# 启动服务
docker-compose up -d

# 停止服务
docker-compose down

# 重启服务
docker-compose restart

# 查看服务状态
docker-compose ps

# 进入容器
docker-compose exec tally-api bash

# 查看资源使用
docker stats

# 清理未使用的资源
docker system prune -a
```

## 支持

如有问题，请检查：
1. Docker和Docker Compose版本
2. 端口占用情况
3. 容器日志
4. 网络配置
