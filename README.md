# springboot-clear-architecture

# Getting Started

### Reference Documentation


Project use clean architecture

🏗 1. Cấu trúc thư mục tổng thể
src/
└── com.example.spingbootexample
├── domain/             # Chứa logic nghiệp vụ (core)
│   ├── model/          # Entity, Value Object
│   ├── repository/     # Interface cho repo (không phụ thuộc JPA/MyBatis)
│   └── service/        # Business rule (Domain Service)
│
├── application/        # Xử lý use case, gọi domain
│   ├── usecase/        # Từng hành động nghiệp vụ
│   └── dto/            # Dữ liệu input/output
│
├── infrastructure/     # Code phụ trợ (adapter: JPA, Kafka, Email, Redis...)
│   ├── repository/     # Triển khai interface từ domain.repository
│   ├── mapper/         # MyBatis Mapper (nếu có)
│   └── config/         # Spring config (Bean, Security, etc.)
│
├── web/                # Controller REST hoặc GraphQL (entry point)
│   └── controller/     # REST/GraphQL controllers
│
└── SpingBootExampleApplication.kt

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
