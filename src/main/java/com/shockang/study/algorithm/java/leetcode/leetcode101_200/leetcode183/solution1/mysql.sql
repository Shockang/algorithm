select customers.name as Customers
from customers
where customers.id not in (select customerid from orders);