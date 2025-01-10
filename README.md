# ToDo List API

Bu proje, bir ToDo List uygulamasının backend tarafını geliştirmek için oluşturulmuştur. Kullanıcılar görevlerini ekleyebilir, güncelleyebilir, silebilir ve listeleyebilir. Ayrıca Swagger UI ile API dokümantasyonu sağlanmıştır.

---

## Özellikler

- Görev oluşturma, güncelleme, silme ve listeleme işlemleri
- ID'ye göre görev getirme
- Swagger UI ile API dokümantasyonu
- Hata yönetimi için global exception handling
- ModelMapper ile DTO dönüşümleri
- PostgreSQL entegrasyonu

---

## Kullanılan Teknolojiler

- **Java 17**
- **Spring Boot 3.x**
    - Spring Data JPA
    - Spring Web
- **PostgreSQL**
- **Swagger (Springdoc OpenAPI)**
- **Lombok**
- **ModelMapper**

---

## Kurulum

### 1. Projeyi Klonlayın
```bash
git clone https://github.com/Yldrmceyy/ToDoList.git
cd ToDoListAPI
````

### 2. Maven Bağımlılıklarını Yükleyin
```bash
mvn clean install
````

### 3. Veritabanı Yapılandırmasını Ayarlayın
``application.properties`` dosyasındaki PostgreSQL bağlantı bilgilerini düzenleyin:

```bash
spring.datasource.url=jdbc:postgresql://localhost:5432/ToDoList
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
````
### 4. Uygulamayı Başlatın
```bash
mvn spring-boot:run
````

---

