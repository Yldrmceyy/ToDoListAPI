# ToDo List API

Bu proje, bir ToDo List uygulamasının backend tarafını geliştirmek için oluşturulmuştur. Kullanıcılar görevlerini ekleyebilir, güncelleyebilir, silebilir ve listeleyebilir. Ayrıca Swagger UI ile API dokümantasyonu sağlanmıştır.

---

## Özellikler

## Özellikler

- **CRUD İşlemleri**: Görev ekleme, listeleme, güncelleme ve silme işlemleri.
- **Swagger UI Desteği**: API dokümantasyonu ve test edilebilirlik.
- **Hata Yönetimi**: Global exception handling ile API güvenilirliği artırıldı.
- **PostgreSQL Entegrasyonu**: Güvenilir ve ölçeklenebilir bir veritabanı.
- **DTO Kullanımı**: Veri transferlerini optimize ederek güvenlik ve performansı artırır.

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

## API EndPoints

| HTTP Metodu | Endpoint        | Açıklama                          | Girdi Parametreleri      |
|-------------|-----------------|----------------------------------|-------------------------|
| GET         | `/api/todos`    | Tüm görevleri listeleme           | Yok                     |
| GET         | `/api/todos/{id}` | ID'ye göre görev getirme          | `id` (Path)             |
| POST        | `/api/todos`    | Yeni görev oluşturma              | Gövde (JSON)            |
| PUT         | `/api/todos/{id}` | Mevcut bir görevi güncelleme       | `id` (Path), Gövde      |
| DELETE      | `/api/todos/{id}` | Görev silme                       | `id` (Path)             |

## Proje Yapısı

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
### 5. Swagger Arayüzüne Erişin

```bash
http://localhost:4444/swagger-ui/index.html
````
---


### Swagger Ekran Görüntüleri
![SwaggerEkranGörüntüsü.png](SwaggerEkranG%C3%B6r%C3%BCnt%C3%BCs%C3%BC.png)