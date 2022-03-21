SELECT b.id
FROM Weather a
         LEFT JOIN Weather b
                   ON a.recordDate = date_sub(b.recordDate, interval 1 day)
WHERE a.temperature < b.temperature;