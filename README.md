# Query historical weather application

## Requirement: 
* Implement micro service (using springboot or other java framework of your choice) which will allow querying for historical weather data (i.e. using https://open-meteo.com/en) for given location and time. Implement local cache (using sqlite or any other lightweigt db) so subsequent query will use cached data.

## host and port:
* local: http://localhost:8080

## Test:
* You can use below sample curl command to test. You can change the value of latitude, longitude, startDate, endDate.
```
curl --location --request GET 'localhost:8080/weather/historical' --header 'Content-Type: application/json' --data '{"latitude":52.52,"longitude":13.41,"startDate":"2023-03-07","endDate":"2023-03-07"}'
```

