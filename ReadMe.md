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

Задаем граф загрузки с помощью аннотации @EntityGraph

```java
@EntityGraph(attributePaths = {"books"})
@Query("SELECT a FROM Author a")
List<Author> findAllWithGraph();   
```

формируется тоже один запрос

```sql
select a1_0.id,b1_0.author_id,b1_0.id,b1_0.title,a1_0.name from author a1_0 left join book b1_0 on a1_0.id=b1_0.author_id
```

<h2> Query с JOIN FETCH </h2>

`query`


<h2> BatchSize </h2>

`batchsize`