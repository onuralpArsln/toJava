## Başlangıç 

Spring Boot, Spring Framework üzerine kurulmuş, açık kaynaklı bir Java web hızlandırıcı aracıdır.

Spring ile daha kolay geliştirme imkanı sağlar.

Spring Initializr, gereksiz kodları (boilerplate) otomatik olarak oluşturur.

Bunu bir eklenti olarak ya da çevrimiçi Initializer araçlarıyla kullanabilirsiniz.

Eklenti için `Ctrl + Shift + P` tuşlarına basarak "Spring Initializr: Generate Project" seçeneğini kullanabilirsiniz.


## İnşa Aletleri

Maven ve Gradle  java projeleri için inşa ve bağımlıklık yönetim araçlarıdır.

Maven küçük projelerde standart yapıyı daha rahat sağlarken Gradle büyük projelerde özelleştirilmiş yapılar için verimlidir.

# Spring Initilizr

maven ile basit bir proje geliştirmek içi maven seç 

terminalinden `java -version` ile versiyonunu kontrol et. ve initlzr için uygun versiyonu al 

basit bir api için 
+ Spring Web 
+ Spring Boot DevTools 

seç.

projeni klasör içine oluştur


# İlk Kodları Eklemek 

Api için bir end point ihtiyacımız var. Bunu bir hello world apisi yapacağız bu yüzden Bir hello world controlleri yazdık

```java

    @GetMapping("/hello") 
    public String sayHello() {
        return "Hello, Spring API!";
    }

```

Buradaki  ` @GetMapping("/hello") `  sayesinde http://localhost:8080/hello adresinde api çağrılacak


Peki bu controller nasıl keşfediliyor?

Proje başlayınca spring boot otomatik olarak @RestController, @Service, ve @Component gibi anotasyonları arar. 

```java

@RestController 
public class HelloController {}

```

`@RestController` yapısı ile bu class proje başlatılınca otomatik çağrılır yani ana projeni  editlemeden yeni end pointler ekleyebilirsin.


## Projeni çalıştırmak


Projenin kök adresinde

maven için

```bash 
./mvnw spring-boot:run
```

gradle  için ise 

```bash 
./gradlew bootRun
```

Yazarak projeni çalıştır. Kök adresin içinde eğer maven ise mvnw  gradle ise pom.xml dosyları görünmeli yani kdolarının bulunduğu src klasörünün hemen üstünde olmalısın. aksi halde mvnw.cmd olmadan çalışmaz.

```bash 
http://localhost:8080/hello

```

Adresinde test et

🚀🚀🚀

## Olası sıkıntıların çözümler


projeyi temizden build alma 
```bash 
./mvnw clean install
./mvnw spring-boot:run
```

Eğer internet bağlantın iyi değilse sıkıntı yaşarsın çünkü bu sistem maven wrapperi ile online olarak çalışıyor istersen maveni cihazına yükleyerek cihazında da çalışabilirsin

## Geliştirme Aşamaları

## Parametre Alan Modeller

GreetingController.java da parametre alan bir model var peki parametreler nasıl alınır?

"http://localhost:8080/greet?name=YourName"

`/greet` adresinden sonra `?name=` ile parametreni verebilrsin.

Daha fazla parametre olursa `&` ile parametrelerini yazabilrisin

`http://localhost:8080/add?a=5&b=3`


## Arayüz edinme

Spring Boot daha ziyade arka plan işlemleri içindir bu yüzden GUI için dışarıdan bir sisteme ihtiyaç duyar. Bir web fraemworku ile geliştirdiğin sayfa Spring Boot Apine istek atarak çalışabilir. Ancak sadece spring boot ile GUI yapmak istersen bu da mümkün sadece büyük projelerde biraz sıkıntılı olabilir. 

Basitçe bir html kodu döndürmek zaten browserinin bunu bir arayüz gibi yorumlamasına izin verecektir.  HtmlController ile bunu deneyebilrisin.


Thymeleaf gibi bir yapı ile taslask sayfalar oluşturup onları döndürebilrisin


## Basic user auth

 Basit bir kullanıcı doğrulama sistemi kurmak için `pom.xml` dosyana eklenecek basit bir bağımlılık ile başlıyoruz

 ```xml

 <dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
 
 ```

şimdi yeni dependcyler iler bir clean install at, gradle veya maven kullanımına göre uygun komutu kullan

```bash 
mvn clean install
```

```bash
./gradlew build --refresh-dependencies
```


 Artık bir güncelik configi lazım

 `...\src\main\java\com\initapi\firstspring\config` proje dosylarının olduğu yere bir de config dosyası oluştur ve içine `SecurityConfig.java` oluşturduk bu hangi end pointlerin korunması gerektiğini belirtiyor.

Ardından  bir user tanımı oluşturalım user bilgisini şimdi static ve hardcoded vereceğiz

@Bean bağlantı yapısını belirler
Tabi Protected classın açacağı bir de sayfanın controlleri oluştuurulmalı



