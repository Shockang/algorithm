select a.Name AS Employee
from Employee a
where a.Salary > (select b.Salary from Employee b where b.Id = a.ManagerId)