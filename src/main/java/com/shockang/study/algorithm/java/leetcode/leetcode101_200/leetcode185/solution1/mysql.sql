SELECT B.Name AS Department,
       A.Name AS Employee,
       A.Salary
FROM (SELECT DENSE_RANK() OVER (partition by DepartmentId order by Salary desc) AS ranking,DepartmentId, Name, Salary
      FROM Employee) AS A
         JOIN Department AS B ON A.DepartmentId = B.id
WHERE A.ranking <= 3;