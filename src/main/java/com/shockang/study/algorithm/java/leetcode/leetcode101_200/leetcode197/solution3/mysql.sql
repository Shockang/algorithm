SELECT a.id
FROM weather a
         JOIN weather b ON DATEDIFF(a.recordDate, b.recordDate) = 1 AND a.temperature > b.temperature;