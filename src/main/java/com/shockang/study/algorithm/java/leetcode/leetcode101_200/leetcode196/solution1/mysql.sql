DELETE
a FROM person a, person b WHERE a.email = b.email AND a.id > b.id;