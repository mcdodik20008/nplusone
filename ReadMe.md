Всевозможные решения nplusone проблемы. Разбросал по веткам.

<h2> Master </h2> 

- проблема присутствует. 

Для каждого автора мы делаем запрос на получение книг. 
Если авторов миллион, то и запросов будет миллион + 1.

Описание про каждый тип будет в его ветке

<h2> Fetch(FetchMode.JOIN) </h2>

`fetch`

@Fetch используется для определения стратегии выборки связанных данных.

Плюсы:
* Контроль над стратегией загрузки
* Уменьшение количества запросов
* Простота использования

Минусы:
* Проблемы с производительностью при JOIN
* Сложности с использованием SUBSELECT
* Ограниченная гибкость

SUBSELECT
```java
@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
@Fetch(FetchMode.SUBSELECT)
private Set<Book> books;
```

```sql
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id in (select a1_0.id from author a1_0)
```

JOIN
```java
@OneToMany(fetch = FetchType.LAZY, mappedBy = "author")
@Fetch(FetchMode.JOIN)
private Set<Book> books;
```

```sql
select a1_0.id,a1_0.name from author a1_0;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
```

SELECT
```sql
select a1_0.id,a1_0.name from author a1_0;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
```

<h2> EntityGraph </h2>

`entitygraph`

<h2> Query с JOIN FETCH </h2>

`query`


<h2> BatchSize </h2>

`batchsize`