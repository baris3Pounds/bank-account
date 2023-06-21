# bank-account

Projeyi localde çalıştırmak için


Docker Desktop install edilmeli
https://www.docker.com/products/docker-desktop/

Projenin ana dizininde 

``` shell
docker compose up
```

komutu çalıştırılarak uygulama ayağa kaldırılır.

Database bilgileri 

``` javascript
    {
        "database_url":"localhost:3306",
        "user":"bank",
        "password":"password"
    }
```