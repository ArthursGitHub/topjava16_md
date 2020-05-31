# Онлайн-проект <a href="https://github.com/JavaWebinar/topjava">Topjava</a>
 
## [Материалы занятия](https://drive.google.com/drive/u/0/folders/0B9Ye2auQ_NsFT1NxdTFOQ1dvVnM)  (скачать все патчи можно через Download папки patch)
> **ВНИМАНИЕ! При удалении класса из исходников, его скомпилированная версия все еще будет находиться в target (и classpath). В этом случае (или в любом другом, когда проект начинает глючить) сделайте `mvn clean`.**

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) 
## ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) [Тех.задание: библия или допускаются изменения. Полуоткрытый интервал.](https://drive.google.com/file/d/123XyBYVeKLC3ZcRr_dUkwyvO9NC6WLkY/view?usp=sharing)
- [Типы промежутков](https://ru.wikipedia.org/wiki/Промежуток_(математика))
#### Apply 3_0_between_half_open.patch

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Разбор домашнего задания HW02
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 1. [Реализация репозиториев](https://drive.google.com/file/d/1qrCPqIQlEonGtMUApdb8oRFOuO3kZye8)

#### Apply 3_01_HW2_repositories.patch
 - [Оптимизация анонимных классов](http://stackoverflow.com/questions/19718353) не требуется! Почитайте комменты от Holger: *Java 8 relieves us from the need to think about such things at all*.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 2. [Фильтрация в репозитории](https://drive.google.com/file/d/1C3-a_3YIjuLW-lu9Ds7LwLVaikmyS1bQ)
#### Apply 3_02_HW2_repo_filters.patch
 - [Spring `@Nullable` аннотации](https://www.jetbrains.com/help/idea/nullable-and-notnull-annotations.html)
 
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 3. [Meals Layers](https://drive.google.com/file/d/1jwd4Yhdy434fUAQyjpsZOO24XT-4lfp8)
#### Apply 3_03_HW2_meal_layers.patch
- [Should services always return DTOs, or can they also return domain models?](http://stackoverflow.com/questions/21554977/should-services-always-return-dtos-or-can-they-also-return-domain-models)
- [Mapping Entity->DTO goes in which application layer: Controller or Service?](http://stackoverflow.com/questions/31644131/spring-dto-dao-resource-entity-mapping-goes-in-which-application-layer-cont/35798539#35798539)

### Рефакторинг InMemory репозиториев
#### Apply 3_04_refactor_repository.patch
- сделал базовый `InMemoryBaseRepository` 
- наследую от него `InMemoryUserRepository`
- использую его в `InMemoryMealRepository` вместо `Map<Integer, Meal>`
- обратите внимание на `InMemoryBaseRepository.counter` - счетчик один, общий для всех хранимых объектов

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 4. [HW2 Optional](https://drive.google.com/file/d/1yzNvGBgjgtuKXDFo983OqtTNoHDbyn1z)
#### Apply 3_05_HW2_optional_MealServlet.patch
- Убрал логирование (уже есть в контроллере)
- `assureIdConsistent` позволяет в контроллере обновлять еду с `id=null`

#### Apply 3_06_HW2_optional_filter.patch
- [JSP Implicit Objects](https://stackoverflow.com/a/1890462/548473)
- [Использование data-* атрибутов](https://developer.mozilla.org/ru/docs/Web/Guide/HTML/Using_data_attributes) 

#### Apply 3_07_HW2_optional_select_user.patch

### ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Вопросы по HW2

> Что делает `repository.computeIfAbsent / computeIfPresent` ?

Всегда пробуйте ответить на вопрос сами. Дастоточно просто зайти по Ctrl+мышка в реализацию и посмотреть javadoc и **их дефолтную реализацию**

> Почему выбрана реализация `Map<userId, Map<mealId,Meal>>` а не `Meal.userId + Map<mealId,Meal>` ?

В данном случае двойная мапа (мультимап) - самый эффективный способ хранения, который не требует итерирования (перебора всех значений). С другой стороны затраты по памяти в этом решении больше.

> **Вопрос вам (очень важный):** можно ли в `MealRestController` контроллере сделать член класса `private int userId = SecurityUtil.authUserId()` и использовать его в методах контроллера?

## Занятие 3:
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 5. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFOU8wWlpPVE05STA">Коротко о жизненном цикле Spring контекста.</a>
#### Apply 3_08_bean_life_cycle.patch
> На JDK 11 перейдем в 5 занятии. Если у вас JDK больше 8, [добавьте в pom `javax.annotation-api`](https://stackoverflow.com/a/46502132/548473)

-  <a href="http://habrahabr.ru/post/222579/">Spring изнутри. Этапы инициализации контекста.</a>
-  Ресурсы:
   -  <a href="https://www.youtube.com/watch?v=BmBr5diz8WA">Евгений Борисов. Spring, часть 1</a>
   -  <a href="https://www.youtube.com/watch?v=cou_qomYLNU">Евгений Борисов. Spring, часть 2</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png)  6. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFODlkU1B0QnNnSGs">Тестирование через JUnit.</a>
### ВНИМАНИЕ!! Перед накаткой патча создайте каталог test (из корня проекта путь `\src\test`), иначе часть файлов попадет в `src\main`.

Все классы, которые не нужны при работе приложения переносятся в test (и не включаются в сборку)

> - в `maven-surefire-plugin` (JUnit) <a href="http://stackoverflow.com/questions/17656475/maven-source-encoding-in-utf-8-not-working/17671104#17671104">поменял кодировку на UTF-8</a>
> - добавил метод `InMemoryUserRepository.init()` для инициализации.
> - переименовал тестовые классы 
> - в тестах ОЧЕНЬ частая ошибка - менять местами `expected` (ожидаемое) и `actual` (фактическое) значения. Поправил `Assert.assertEquals` в `InMemoryAdminRestControllerTest`

- [Junit — Что почитать по jUnit-тестам](https://i-http.ru/junit-chto-pochitat-po-junit-testam/)
- [Тестирование с помощью JUnit (Test Case)](http://web.archive.org/web/20190829153452/http://www.javenue.info/post/19)
- [Тестирование кода Java с помощью фреймворка JUnit](https://www.youtube.com/watch?v=z9jEVLCF5_w) (youtube)

#### Apply 3_09_add_junit.patch
### После патча сделайте `clean` и [обновите зависимости Maven](https://github.com/JavaOPs/topjava/wiki/IDEA#%D0%9E%D0%B1%D0%BD%D0%BE%D0%B2%D0%B8%D1%82%D1%8C-%D0%B7%D0%B0%D0%B2%D0%B8%D1%81%D0%B8%D0%BC%D0%BE%D1%81%D1%82%D0%B8-%D0%B2-maven-%D0%BF%D1%80%D0%BE%D0%B5%D0%BA%D1%82%D0%B5), чтобы IDEA определила сорсы тестов
#### ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Вопрос: почему проект упадет при попытке открыть страничку еды (в логе смотреть самый верх самого нижнего исключения)?
-  <a href="http://junit.org/junit4/">JUnit 4</a>
-  <a href="http://habrahabr.ru/post/120101/">Тестирование в Java. JUnit</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 7. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFai1veG9qaFZlZ2s">Spring Test</a>
> - поменял `@RunWith`: `SpringRunner` is an alias for the `SpringJUnit4ClassRunner`
#### Apply 3_10_add_spring_test.patch
-  <a href="https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/htmlsingle/#testing">Spring Testing</a>

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 8. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVlNYczhnSU9JdXc">Базы данных. Обзор NoSQL и Java persistence solution без ORM.</a>
> **Внимание! С PostgreSQL 12 возможны проблемы**
-  <a href="https://ru.wikipedia.org/wiki/PostgreSQL">PostgreSQL</a>.
-  [PostgreSQL JDBC Driver](https://github.com/pgjdbc/pgjdbc)
-  <a href="http://java-course.ru/begin/postgresql/">Установка PostgreSQL</a>.
-  Чтобы избежать проблем с правами и именами каталогов, [**рекомендуют установить postgres в простой каталог, например `C:\Postgresql`**. И при проблемах создать каталог data на другом диске](https://stackoverflow.com/questions/43432713/postgresql-installation-on-windows-8-1-database-cluster-initialisation-failed). Если Unix, [проверить права доступа к папке (0700)](http://www.sql.ru/forum/765555/permissions-should-be-u-rwx-0700).
    
> Создать в pgAdmin новую базу `topjava` и новую роль `user`, пароль `password`

![image](https://cloud.githubusercontent.com/assets/13649199/18809406/118f9c48-8283-11e6-8f10-d8291517a497.png)

>  Проверьте, что у user в Privileges есть возможность авторизации (особенно для pgAdmin4)

или в UNIX командной строке:
```
sudo -u postgres psql
CREATE DATABASE topjava;
CREATE USER "user" WITH password 'password';
GRANT ALL PRIVILEGES ON DATABASE topjava TO "user";
```
-  <a href="http://alexander.holbreich.org/2013/03/nosql-or-rdbms/">NoSQL or RDBMS.</a> <a href="http://habrahabr.ru/post/77909/">Обзор NoSQL систем</a>. <a href="http://blog.nahurst.com/visual-guide-to-nosql-systems">CAP</a>
-  <a href="http://db-engines.com/en/ranking">DB-Engines Ranking</a>
-  <a href="http://ru.wikipedia.org/wiki/Java_Database_Connectivity">JDBC</a>
-  Обзор Java persistence solution без ORM: <a href="http://commons.apache.org/proper/commons-dbutils/">commons-dbutils</a>,
            <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/data-access.html#jdbc">Spring JdbcTemplate</a>,
            <a href="http://en.wikipedia.org/wiki/MyBatis">MyBatis</a>, <a href="http://www.jdbi.org/">JDBI</a>, <a href="http://www.jooq.org/">jOOQ</a>
- Основы:
  - <a href="https://ru.wikipedia.org/wiki/Реляционная_СУБД">Реляционная СУБД</a>
  - <a href="http://habrahabr.ru/post/103021/">Реляционные базы</a>
  - <a href="https://www.youtube.com/playlist?list=PLIU76b8Cjem5qdMQLXiIwGLTLyUHkTqi2">Уроки по JDBC</a>
  - <a href="http://postgresguide.com/">Postgres Guide</a>
  - <a href="http://www.postgresqltutorial.com">PostgreSQL Tutorial</a>
  - <a href="http://java-course.ru/begin/database01/">Базы данных на Java</a>
  - <a href="http://java-course.ru/begin/database02/">Возможности JDBC — второй этап</a>
- Дополнительно:
  - [Документация к PostgreSQL 9.6](https://postgrespro.ru/docs/postgresql/9.6/index.html)
  - [Книги по PostgreSQL](https://postgrespro.ru/education/books)

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 9. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFQWtHYU1qTDlMWVE">Настройка Database в IDEA.</a>
> - Креденшелы к базе Heroku (AWS)  находятся вверху `postgres.properties`. 
> - В новом PostgreSQL для коннекта с базой на Heroku (AWS) добавился параметр `sslmode=require`.
> - В новой IDEA еще необходимо настроить импортируемые схемы (`Schemas -> Current database`)

![image](https://user-images.githubusercontent.com/13649199/60019737-40a08300-9697-11e9-90cf-35675e903a3f.png)
#### Apply 3_11_add_postgresql.patch
-  <a href="http://habrahabr.ru/company/JetBrains/blog/204064/">Настройка Database в IDEA</a> и запуск SQL.

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 10. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFMGNWUXhaVzdlU0k">Скрипты инициализации базы. Spring Jdbc Template.</a>

#### Apply 3_12_db_implementation.patch
> - в `JdbcUserRepository` 
>   - в `getByEmail()` заменил `queryForObject()` на `query()`. Загляните в код: `queryForObject` бросает `EmptyResultDataAccessException` вместо нужного нам `null`.
>   - в `save()` добавил проверку на несуществующей в базе `User.id`
> - в классе `JdbcTemplate` есть настройки (`queryTimeout/ skipResultsProcessing/ skipUndeclaredResults`) уровня приложения (если они будут менятся, то, скорее всего, везде в приложении).
  Мы можем дополнительно сконфигурировать его в `spring-db.xml` и использовать в конструкторах `NamedParameterJdbcTemplate` и в `SimpleJdbcInsert` вместо `dataSource`.

![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) **Вопрос: почему проект перестал запускаться?**

-  Подключение <a href="https://docs.spring.io/spring/docs/current/spring-framework-reference/data-access.html#jdbc">Spring Jdbc</a>.
-  Конфигурирование DataSource. <a href="http://www.mkyong.com/spring/spring-propertyplaceholderconfigurer-example/">Property Placeholder</a>
-  Интеграция `JdbcUserRepository` с DB: [IDEA Wiki](https://github.com/JavaOPs/topjava/wiki/IDEA) -> Добавить поддержку DB в JDBC

>  Проверьте, что в контекст Spring проекта включены оба файла конфигурации

![image](https://cloud.githubusercontent.com/assets/13649199/24730713/eb21456a-1a6d-11e7-997c-fb4ad728ba45.png)

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 11. <a href="https://drive.google.com/open?id=1SPMkWMYPvpk9i0TA7ioa-9Sn1EGBtClD">Тестирование UserService через AssertJ.</a>
#### Apply 3_13_test_UserService.patch
> - В конструктор `User` внес `registered` и делаю копию `roles`, чтобы роли нельзя было изменить после инициализации.
> - В тестах `delete` и `create` проверяю результат напрямую (не через `getAll`)
> - В `UserTestData` добавил вспомогательные `getNew()` и `getUpdated()`

- [Tutorial: testing with AssertJ](http://www.vogella.com/tutorials/AssertJ/article.html)
- [Spring Testing Annotations](https://docs.spring.io/spring/docs/4.3.x/spring-framework-reference/htmlsingle/#integration-testing-annotations-spring)
- [The JPA hashCode() / equals() dilemma](https://stackoverflow.com/questions/5031614/the-jpa-hashcode-equals-dilemma)
- [Hibernate: implementing equals() and hashCode()](https://docs.jboss.org/hibernate/orm/current/userguide/html_single/Hibernate_User_Guide.html#mapping-model-pojo-equalshashcode)
- [Junit Matcher for comparators](https://stackoverflow.com/questions/17949752)
- [AssertJ custom comparison strategy](http://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#custom-comparison-strategy). [AssertJ field by field comparisons](http://joel-costigliola.github.io/assertj/assertj-core-features-highlight.html#field-by-field-comparison)

### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 12. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFVmZaSm9UMktXUnc">Логирование тестов.</a>
#### Apply 3_14_test_logging.patch
> - Новый PostgreSQL JDBC Driver [логирует через java.util.logging](https://github.com/pgjdbc/pgjdbc#changelog).  [Направил логирование в SLF4J](http://stackoverflow.com/a/43242620/548473)
> - Поменял формат вывода. См. [Logback Layouts](https://logback.qos.ch/manual/layouts.html)

- Ресурсы, которые кладутся в classpath, maven при сборке берет из определенных каталогов `resources` ([Introduction to the Standard Directory Layout](https://maven.apache.org/guides/introduction/introduction-to-the-standard-directory-layout.html)). Их можно настраивать через [maven-resources-plugin](https://maven.apache.org/plugins/maven-resources-plugin/examples/resource-directory.html), меняем в проекте Masterjava.

#### Apply 3_15_fix_servlet.patch
**Приложение перестало работать, тк. для репозитория мы используем заглушку `JdbcMealRepository`**
 
### ![video](https://cloud.githubusercontent.com/assets/13649199/13672715/06dbc6ce-e6e7-11e5-81a9-04fbddb9e488.png) 13. <a href="https://drive.google.com/open?id=0B9Ye2auQ_NsFNDlOQVpOWF82OTA">Ответы на Ваши вопросы</a>
-  Что такое REST? <a href="https://medium.com/@mwaysolutions/10-best-practices-for-better-restful-api-cbe81b06f291">10 Best Practices for Better RESTful API</a>
-  Зачем нужна сортировка еды?
-  Можно ли обойтись без `MapSqlParameterSource`?
-  Как происходит работа с DB в тестах?
-  Как реализовывать RowMapper?
-  Мои комментарии: решения проблем разработчиком.
-  Нужен ли разработчику JavaScript?

## ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Ваши вопросы
> Какая разница между @BeforeClass and @Before? 

`@BeforeClass` выполняется один раз после загрузки класса (поэтому метод может быть только статический), `@Before` перед каждым тестом.
Также: для чистоты тестов экземпляр тестового класса пересоздается перед каждым тестом: http://stackoverflow.com/questions/6094081/junit-using-constructor-instead-of-before

> Тесты в классе в каком-то определенном порядке выполняются ("сверху вниз" например)?

Порядок по умолчанию неопределен, каждый тест должен быть автономен и не зависеть от других. См. также http://stackoverflow.com/questions/3693626/how-to-run-test-methods-in-specific-order-in-junit4 

> Обязательно ли разворачивать postgreSQL?

Желательно: хорошая и надежная ДБ:) Если совсем не хочется - можно работать со своей любимой RDBMS (поправить `initDB.sql`) или работать c postgresql в heroku (креденшелы к нему есть сверху в `postgres.properties`). На следующем уроке добавим HSQLDB, она не требует установки.

> Зачем начали индексацию с 100000?

Тут нет "как принято". Так удобно вставлять в базу (если будет потребность) записи вручную не мешая счетчику.

> Из 5-го видео - "Логика в базе - большое зло". Можно чуть поподробней об этом?

- Есть успешные проекты с логикой в базе. Те все относительно.
- Логика в базе - это процедуры и триггеры. Нет никакого ООП, переиспользовать код достаточно сложно, никагого рефакторинга, поиска по коду и других плюшек IDE. Нельзя делать всякие вещи типа кэширования, хранения в сесии - это все для логики на стороне java. Например json можно напрямую отдать в процедуру и там парсить и вставлять в таблицы или наоборот - собирать из таблиц и возвращать.
А затем потребуется некоторая логика на стороне приложения и все равно придется этот json дополнительно разпарсивать в java.
Я на таком проекте делал специальную миграцию, чтобы процедуры мигрировать не как sql скрипты, а каждую процедуру хранить как класс с историей изменений. Если логика: триггеры и простые процедуры записи-чтения, которые не требуют переиспользования кода или
проект небольшой это допустимо, иначе проект становится трудно поддерживать. Также иногда используют [View](http://postgresql.men/gruber/ch20.html) для разграничения доступа. Например, для финансовых систем, таблицы проводок доступны только  для админ учеток, а View просто не дадут увидеть (тем более изменить) данны обычному оператору на уровне СУБД.

> У JUnit есть ассерты и у спринга тоже. Можно ли обойтись без JUnit?

Предусловия и JUnit-тесты совершенно разные вещи. Один другого не заменит, у нас будут предусловия в следующем уроке.

> Я так понял VARCHAR быстрее, чем TEXT, когда мы работаем с небольшими записями. Наши записи будут небольшими (255). Почему вы приняли решение перейти на TEXT?

В отличие от MySql в Postgres  VARCHAR и TEXT - тоже самое: http://stackoverflow.com/questions/4848964/postgresql-difference-between-text-and-varchar-character-varying

> Зачем при создании таблицы мы создаем `CREATE UNIQUE INDEX` и `CREATE INDEX`. При каких запросах он будет использоваться?

UNIQUE индекс нужен для обеcпечения уникальности, DB не даст сделать одинаковый индекс. Индексы используется для скорости выполнения запросов. Обычно они задействуются, когда в запросе есть условия, на которые сделан индекс. Узнать по конкретному запросу можно  запросив план запроса: см. <a href="https://habrahabr.ru/post/203320">Оптимизация запросов. Основы EXPLAIN в PostgreSQL</a>. На измерение производительности с индексами посмотрим в следующем уроке.

> А это нормально, что у нас в базе у meals есть userId, а в классе - нет?

Ненормально, когда в приложении есть "лишний" код, который не используется. Для ORM он нам понадобится- мы `Meal.user` добавим.

> Почему мы делаем один sequence на разные таблицы?

Мы будем использовать Hibernate, по умолчанию он делает глобальный sequence на все таблицы. В этом подходе есть <a href="http://stackoverflow.com/questions/1536479/asking-for-opinions-one-sequence-for-all-tables">как плюсы, так и минусы</a>, из плюсов - удобно делать ссылки в коде и в таблицах на при наследовании и мапы в коде.

> Каким образом попадают в тесты классы, расположенные в каталоге `test`, если в конфигурации спринга нет указание на ее сканирование?

Сканируются не папки, а пакеты. Обычно тесты классов располагают в том же самом пакете каталога `test`. Таким образом тесты могут видеть поля классов `main` с видимостью по умолчанию (внутри пакета). При этом классы `test` видят `main`, а наоборот- нет. Когда приложение деплоится, в коде тестов быть не должно!

## ![hw](https://cloud.githubusercontent.com/assets/13649199/13672719/09593080-e6e7-11e5-81d1-5cb629c438ca.png) Домашнее задание HW03
- 1 Понять, почему перестали работать `SpringMain, InMemoryAdminRestControllerTest, InMemoryAdminRestControllerSpringTest`
- 2 Дополнить скрипты создания и инициализации базы таблицой MEALS. Запустить скрипты на вашу базу (через Run). Порядок таблиц при DROP и DELETE важен, если они связаны внешними ключами (foreign key, fk). Проверьте, что ваши скрипты работают
- 3 Реализовать через Spring JDBC Template `JdbcMealRepository`
  - 3.1. сделать каждый метод за один SQL запрос
  - 3.2. `userId` в класс `Meal` вставлять НЕ надо (для UI и REST это лишние данные, userId это id залогиненного пользователя)
  - 3.3. `JbdcTemplate` работает через сеттеры. Вместе с конструктором по умолчанию их нужно добавить в `Meal` 
  - 3.4. Cписок еды должен быть отсортирован (тогда мы его сможем сравнивать с тестовыми данными). Кроме того это требуется для UI и API: последняя еда наверху.
- 4 Проверить работу MealServlet, запустив приложение

### Optional
- 5 Сделать `MealServiceTest` из `MealService` и реализовать тесты для `JdbcMealRepository`.
> По `Ctrl+Shift+T` (выбрать JUnit4) можно создать тест для конкретного класса, выбрав для него нужные методы. Тестовый класс создастся в папке `test` в том же пакете, что и тестируемый. 
  - 5.1 Сделать тестовые данные `MealTestData` (точно такие же, как вставляем в `populateDB.sql`).
  - 5.2 Сделать тесты на чужую еду (delete, get, update) с тем чтобы получить `NotFoundException`.
- 6 Почнинить `SpringMain, InMemory*Test`. **InMemory тесты должны использовать реализацию в памяти**
- 7 Сделать индексы к таблице `Meals`: запретить создавать у одного и того-же юзера еду с одинаковой dateTime.
Индекс на pk (id) postgres создает автоматически: <a href="http://stackoverflow.com/questions/970562/postgres-and-indexes-on-foreign-keys-and-primary-keys">Postgres and Indexes on Foreign Keys and Primary Keys</a>
  - [PostgreSQL: индексы](https://postgrespro.ru/docs/postgresql/10/indexes-intro)
  - <a href="http://postgresguide.com/performance/indexes.html">Postgres Guide: Indexes</a>
  - [Оптимизация запросов. Основы EXPLAIN в PostgreSQL](https://habrahabr.ru/post/203320/)
  - [Оптимизация запросов. Часть 2](https://habrahabr.ru/post/203386/)
  - [Оптимизация запросов. Часть 3](https://habrahabr.ru/post/203484/)

> ![question](https://cloud.githubusercontent.com/assets/13649199/13672858/9cd58692-e6e7-11e5-905d-c295d2a456f1.png) Как правильно придумать индекс для базы? Указать в нем все поля, комбинация которых создает по смыслу уникальную запись, или какие-то еще есть условия?

Индекс нужно делать по тем полям, по которым будут искаться записи (участвуют в WHERE, ORDER BY). Уникальность - совсем не обязательное условие. Индексы ускоряют поиск по определенным полям таблицы. Они не бесплатные (хранятся в памяти, замедляется вставка), поэтому на всякий случай их делать не надо. Также не строят индексы на колонки с малым процентом уникальности (например поле "М/Ж"). Поля индекса НЕ КОММУТАТИВНЫ и порядок полей в описании индекса НЕОБХОДИМО соблюдать (в силу использования B-деревьев и их производных как поисковый механизм индекса). При построении плана запроса EXPLAIN учитывается количество записей в базе, поэтому вместо индексного поиска (Index Scan) база может выбрать последовательный (Seq Scan). Проверить, работают ли индексы можно <a href="http://stackoverflow.com/questions/14554302/postgres-query-optimization-forcing-an-index-scan">отключив Seq Scan</a>. Также см. <a href="https://dba.stackexchange.com/a/27493/3684">Queries on the first field of composite index</a>

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Решение проблем

> Из каталога `main` не видятся классы/ресурсы в `test`

Все что находится в `test` используется только для тестов и недоступно в основном коде.  

> Из `IDEA` не видятся ресурсы в каталоге `test`

- Сделайте Reimport All в Maven окне

![image](https://cloud.githubusercontent.com/assets/13649199/18831806/7e43bedc-83f0-11e6-97db-67d4e1a7599f.png)

> В UserService и MealService подчеркнуты красным repository, ошибка: Could not autowire. There is more than one bean of 'MealRepository' type.

- Spring test контекст не надо включать в Spring Facets проекта, там должны быть только `spring-app.xml` и `spring-db.xml`. Для тестовых контекстов поставьте чекбокс `Check test files` в Inspections. 

![image](https://cloud.githubusercontent.com/assets/13649199/18831817/8a858f22-83f0-11e6-837e-bf5317b33b3a.png)

### ![error](https://cloud.githubusercontent.com/assets/13649199/13672935/ef09ec1e-e6e7-11e5-9f79-d1641c05cbe6.png) Типичные ошибки и подсказки по реализации

- 1: В `MealTestData` еду делайте константами. Не надо `Map` конструкций!
- 2: SQL  case-insensitive, не надо писать в стиле Camel. В POSTGRES возможны case-sensitive значения, их надо в кавычки заключать (обычно не делают).
- 3: ЕЩЕ РАЗ: `InMemory` тесты должны идти на `InMemory` репозитории
- 4: **Проверьте, что возвращает `JdbcMealRepository` при обновлении чужой еды**
- 5: В реализации `JdbcMealRepository` одним SQL запросом используйте возвращаемое `update` значение `the number of rows affected`
- 6: При тестировании не портите констант из `MealTestData`
- 7: Проверьте, что все, что относится к тестам, находится в каталоге `test` (не попадает в сборку проекта)
- 8: **Еще раз: в тестах проверять через `JUnit Assert` или использовать `assertThat().isEqualTo` нельзя: сравнение будет происходить через `AbstractBaseEntity.equals`, который сравнивает объекты только по `id`. Мы не можем переопределять `equals` для объектов модели, тк будем использовать JPA (см. [The JPA hashCode() / equals() dilemma](https://stackoverflow.com/questions/5031614/the-jpa-hashcode-equals-dilemma))**
- 9: НЕ делайте склейку SQL запросов вручную из параметров, только через `jdbcTemplate` параметры! См. [Внедрение_SQL-кода](https://ru.wikipedia.org/wiki/Внедрение_SQL-кода)
- 10: Напомню: `BeanPropertyRowMapper` работает через отражение. Ему нужны геттеры/сеттеры и имена полей должны "совпадать" с колонками `ResultSet` (Column values are mapped based on matching the column name as obtained from result set metadata to public setters for the corresponding properties. The names are matched either directly or by transforming a name separating the parts with underscores to the same name using "camel" case).
