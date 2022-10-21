# jackson-load-modules-issue

I have this simple project with:

```java
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

I am trying to make `LocalDateTime` to be written in ISO format: ``

I tried to add `spring.jackson.serialization.write-dates-as-timestamps=false`

but it made not difference.

Looking at `Jackson2ObjectMapperBuilderCustomizer` o noticed that `JavaTimeModule` was not loaded.

<img width="600" alt="image" src="https://user-images.githubusercontent.com/25033371/197296086-a2cc5d7c-1f85-40e3-805a-a200c14c55d7.png">
