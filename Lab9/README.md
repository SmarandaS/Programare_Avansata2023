# ProgramareAvansata2023 - Lab 9 - Sandu Smaranda, 2B3

## Compulsory

--------

- [x] Create a persistence unit (use EclipseLink or Hibernate or other JPA implementation).
  Verify the presence of the persistence.xml file in your project. Make sure that the driver for EclipseLink or Hibernate was added to to your project classpath (or add it yourself).
- [x] Define the entity classes for your model (at least one) and put them in a dedicated package. You may use the IDE support in order to generate entity classes from database tables.
- [x] Create a singleton responsible with the management of an EntityManagerFactory object.
- [x] Define repository clases for your entities (at least one). They must contain the following methods:
  create - receives an entity and saves it into the database;
  findById - returns an entity based on its primary key;
  findByName - returns a list of entities that match a given name pattern. Use a named query in order to implement this method.
- [x] Test your application.
----------

## Homework

----------

- [x] Create all entity classes and repositories. Implement properly the one-to-many and many-to-many relationships.
- [x] Create a generic AbstractRepository using generics in order to simplify the creation of the repository classes. You may take a look at the CrudRepository interface from Spring Framework.
- [x] Insert, using JPA, a large number of fake artists and albums in the database and log the execution time of your JPQL statements.
----------

## Bonus

---------

- [ ] Implement both the JDBC and JPA implementations and use an AbstractFactory in order to create the DAO objects (the repositories).
The application will use JDBC or JPA depending on a specified parameter.
- [ ] Use a constraint solver, such as Choco solver, OptaPlanner or ORTools, in order to find a set of at least k albums having titles that start with the same letter and they are released in the same period of time (for any two albums in the result, the difference between their release years must not exceed a given value p).
