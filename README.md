#### RestController注解学习
> 标记控制器类，相当于@Controller和@ResponseBody一起使用
* GetMapping
* PostMapping
    * PathVariable


#### spring-data-jpa
1. 添加依赖
    spring-boot-starter-data-jpa和mysql-connector-java
2. 配置数据库
<pre><code>
spring:
  datasource:
    driver-class-name: com.mysql.jdbc.Driver
    url: jdbc:mysql://127.0.0.1:3306/mydb
    username: root
    password: 123
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
 </code></pre>
 `ddl-auto:create会每次都创建新的数据库，update则会保留数据`

 3. 创建类文件，通过注解映射生成数据库
    * 如本demo中的User类，添加@Entity注解，@Id标记id,@GeneratedValue标记自增长列
    * 可以在类中通过配置@min等注解来验证数据有效性
    * 在请求url时使用@Valid来验证，如"public void addUser(@Valid User user)"

4. 事务的使用
    * 在方法前加@Transactional注解即可

#### 请求和返回的统一处理
> 如登录和不登陆http请求的返回不同，这种需求如果在每个请求时都做下if...else..
的判断的话将会很麻烦，需要一个统一的处理
1. 使用aspect,如本例中的BaseAspect,添加@Aspect和@Component注释
2. @Before标注的方法会在每个http请求开始时执行</br>
    @After标注的方法会在每个htpp请求结束时执行</br>
    @AfterReturning标注的方法会在没个请求返回结果时执行
