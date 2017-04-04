# GPRest


Install

$ git clone https://github.com/yurictec/GPRest.git
\n$ cd GPRest

$ mvn install


Move files GPRest/orders.json, GPRest/timetable.json in GPRest/target


Run 

$ cd target
$java -jar simpleTest-1.0-SNAPSHOT.jar


HTTP-GET %localhost%/schedule - return List of movies
HTTP-POST %localhost%/bookit/{id}&{tickets} - create and return number of orders (id - session.id, tickets - how many tickets).
HTTP-GET %localhost%/orders/{id} - return order by id (id - number of order)
HTTP-DELETE %localhost%/orders/{id} - return operation status (id - number of order)
