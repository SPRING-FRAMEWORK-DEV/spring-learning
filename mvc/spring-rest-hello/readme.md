1. add jackson dependency
2. define message converter class that implements implements WebMvcConfigurer. 
3. must override  configureMessageConverters(List<HttpMessageConverter<?>> converters) in step 2
4. @EnableWebMvc in AppConfig as we are using WebMvcConfigurer
5. In controller use produces , consumes as application/json