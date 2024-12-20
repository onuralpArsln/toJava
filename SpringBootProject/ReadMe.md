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

java"""

    @GetMapping("/hello") 
    public String sayHello() {
        return "Hello, Spring API!";
    }

"""

Buradaki  ` @GetMapping("/hello") `  sayesinde http://localhost:8080/hello adresinde api çağrılacak