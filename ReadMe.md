Всевозможные решения nplusone проблемы. Разбросал по веткам.

<h2> Master </h2> 

- проблема присутствует. 

Для каждого автора мы делаем запрос на получение книг. 
Если авторов миллион, то и запросов будет миллион + 1.

Описание про каждый тип будет в его ветке

<h2> Fetch(FetchMode.JOIN) </h2>

`fetch`

<h2> EntityGraph </h2>

`entitygraph`

<h2> Query с JOIN FETCH </h2>

`query`


<h2> BatchSize </h2>

`batchsize`
```java
@OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
@BatchSize(size = 10)
private List<Book> books;
```

результат при запросе 10-ти в бачсайзе

```java
select a1_0.id,a1_0.name from author a1_0;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id = any (?);
```

давайте установим бачсайз 1
```sql
select a1_0.id,a1_0.name from author a1_0
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
```

А если 2

```sql
select a1_0.id,a1_0.name from author a1_0
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id = any (?);
select b1_0.author_id,b1_0.id,b1_0.title from book b1_0 where b1_0.author_id=?;
```

Вот так он и работает