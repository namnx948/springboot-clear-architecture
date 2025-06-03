# 🚀 DevConnect PRO — The Social Platform for Developers

> Một dự án mạng xã hội mô phỏng môi trường thực tế, xây dựng trên nền Spring Boot + Kotlin theo kiến trúc **Clean Architecture**, kết hợp đầy đủ các thành phần enterprise như Redis, Kafka, Elasticsearch, WebSocket, Prometheus... nhằm mục tiêu showcase **năng lực backend cấp độ mid/senior**.

---

## 🧠 Tổng quan

DevConnect PRO giúp lập trình viên:
- Tạo và cập nhật hồ sơ cá nhân
- Viết bài chia sẻ kiến thức
- Follow người khác và nhận đề xuất kết nối
- Nhắn tin real-time (WebSocket + Kafka)
- Nhận thông báo khi có tương tác (Kafka + Redis)
- Tìm kiếm bài viết/người dùng toàn văn (Elasticsearch)

🎯 **Mục tiêu cá nhân khi phát triển dự án này:**
- Làm chủ **Spring Boot theo kiến trúc sạch**
- Triển khai hệ thống theo tư duy **modular + scalable**
- Sở hữu một **dự án thực chiến** để chứng minh năng lực đi làm

---

## 🏗 Kiến trúc tổng thể

![Architecture Diagram](https://github.com/namy-lemontree/springboot-clear-architecture/blob/main/src/main/resources/image_container_project.png)

| Layer | Mô tả |
|-------|------|
| `domain` | Business logic thuần Kotlin (Entity, Value Object, Domain Service) |
| `application` | Xử lý use case, mapping DTO, orchestrate logic |
| `infrastructure` | Adapter cho JPA, Kafka, Redis, Mail, Elastic |
| `web` | REST Controller entrypoint |

---

## ⚙️ Công nghệ sử dụng

| Thành phần | Công nghệ |
|------------|-----------|
| Backend | Spring Boot 3, Kotlin, Gradle |
| DB | PostgreSQL, JPA (Hibernate) |
| Cache | Redis (Spring Cache) |
| Message Queue | Apache Kafka |
| Full-text Search | Elasticsearch 8 |
| Real-time Chat | WebSocket + STOMP |
| Email | Spring Mail + Gmail SMTP |
| Auth | JWT + Spring Security (Role-based) |
| Monitoring | Spring Actuator, Prometheus, Grafana |
| DevOps | Docker, Docker Compose, GitHub Actions |
| Testing | JUnit 5, Mockito, TestContainers |

---

## 🧩 Các Module chính

### 🔐 Authentication
- JWT + Refresh Token
- Middleware kiểm tra quyền
- Email Verification + Reset Password

### 👥 User & Follow
- Hồ sơ cá nhân
- Follow / unfollow với async event
- Mutual follow suggestion (Redis + Set operation)

### 📝 Post & Feed
- CRUD bài viết, Like/Comment
- Feed hiển thị theo thời gian + pre-load từ cache
- Event khi có comment/like

### 💬 Realtime Chat
- WebSocket (STOMP protocol)
- Kafka Pub/Sub cho message dispatch
- Redis queue chống mất message

### 🔍 Tìm kiếm
- Elasticsearch index cho bài viết và user
- DSL search theo keyword, username, tags

### 🔔 Notification
- Kafka producer gửi event
- Kafka consumer cập nhật Redis + Email

### 🔭 Monitoring & Logging
- Endpoint `/actuator/health`, `/metrics`
- Prometheus scrape metrics
- Dashboard Grafana hiển thị traffic, error, throughput

---

## 📁 Cấu trúc thư mục

```bash
src/com.example.devconnect
├── domain/
│   ├── model/              # User, Post, Message, Notification
│   ├── repository/         # interface cho persistence
│   └── service/            # Domain service
├── application/
│   ├── usecase/            # RegisterUserUseCase, CreatePostUseCase, ...
│   └── dto/                # input/output model
├── infrastructure/
│   ├── repository/         # JPA impl
│   ├── search/             # Elasticsearch impl
│   ├── event/              # Kafka producer/consumer
│   ├── cache/              # Redis service
│   ├── mail/               # Email service
│   └── config/             # Security, Kafka, Redis, Swagger config
├── web/
│   └── controller/         # REST API
└── DevConnectApplication.kt





# springboot-clear-architecture

# Getting Started

### Reference Documentation


Project use clean architecture

🏗 1. Cấu trúc thư mục tổng thể<br>
src/<br>
└── com.example.spingbootexample<br>
├── domain/             # Chứa logic nghiệp vụ (core)<br>
│   ├── model/          # Entity, Value Object<br>
│   ├── repository/     # Interface cho repo (không phụ thuộc JPA/MyBatis)<br>
│   └── service/        # Business rule (Domain Service)<br>
│<br>
├── application/        # Xử lý use case, gọi domain<br>
│   ├── usecase/        # Từng hành động nghiệp vụ<br>
│   └── dto/            # Dữ liệu input/output<br>
│<br>
├── infrastructure/     # Code phụ trợ (adapter: JPA, Kafka, Email, Redis...)<br>
│   ├── repository/     # Triển khai interface từ domain.repository<br>
│   ├── mapper/         # MyBatis Mapper (nếu có)<br>
│   └── config/         # Spring config (Bean, Security, etc.)<br>
│<br>
├── web/                # Controller REST hoặc GraphQL (entry point)<br>
│   └── controller/     # REST/GraphQL controllers<br>
│<br>
└── SpingBootExampleApplication.kt<br>
<br>
🔄 2. Dòng chảy phụ thuộc
Controller
↓
Application Layer (UseCase)
↓
Domain Layer (Business Logic, Entity)
↓
Infrastructure (DB, API, Queue, Mail...)

✅ 3. Vai trò các tầng

| Tầng               | Vai trò chính                                                  |
| ------------------ | -------------------------------------------------------------- |
| **Domain**         | Chứa nghiệp vụ cốt lõi, độc lập, sạch (Entity, Domain Service) |
| **Application**    | Triển khai từng Use Case, xử lý flow logic, gọi domain         |
| **Web**            | Nhận request, convert input → DTO, gọi usecase, trả response   |
| **Infrastructure** | Kết nối bên ngoài: database, email, kafka, external API...     |
