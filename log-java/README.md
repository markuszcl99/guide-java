## 本节阅读指导

> 本模块是记录有关 Java 的日志框架，涉及 slf4j 门面 + 几种日志框架（如 jul、log4j、logback、log4j2）

如果你想测试 log4j2，那么就依赖这些 jar 包即可，然后直接运行单测类

```pom
 <dependency>
    <groupId>junit</groupId>
    <artifactId>junit</artifactId>
</dependency>
<!-- log 日志框架门面 api-->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<!-- Log4j2 门面API（很强大，未考虑兼容性，还是使用上面的 slf4j-api）-->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.11.1</version>
</dependency>
<!-- Log4j2 日志实现 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.11.1</version>
</dependency>
<!--为slf4j绑定日志实现 log4j2的适配器 -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-slf4j-impl</artifactId>
    <version>2.10.0</version>
</dependency>
```

如果你想要测试 logback，那么就依赖这些 jar 包即可，然后将 resources 目录下的 logback_bak.xml 改为 logback.xml 以及将
log4j2.xml 改为 log4j2_bak.xml，然后运行 logback 包下的单测类相关方法

```pom
<!-- log 日志框架门面 api-->
<dependency>
    <groupId>org.slf4j</groupId>
    <artifactId>slf4j-api</artifactId>
    <version>1.7.25</version>
</dependency>
<!-- logback 框架实现 使用 logback 单测时，先取消这个注释，并且将 log4j2 相关的依赖去掉-->
<dependency>
    <groupId>ch.qos.logback</groupId>
    <artifactId>logback-classic</artifactId>
    <version>1.2.3</version>
</dependency>
```