# Overview

Web app implemented according MVC pattern that helps manage web links into groups and allows multi - user support.

## Stack of technologies used

- Java 17
- Java Spring Framework
    - Boot
    - Data
    - Security
- Maven
- Hibernate
- Thymeleaf
- HTML
- CSS
- PostgreSQL

## Full functionality of app on video

https://youtu.be/zTXd9jDLNGI

## Screenshots

- Login and registration
![register](https://user-images.githubusercontent.com/66835270/189213455-59a2f72d-12ee-4049-b2d5-ebf2db357648.png)
![registrationConstraints](https://user-images.githubusercontent.com/66835270/189213464-44078b71-0ae6-4844-9eb4-e4a6629ac971.png)
![login](https://user-images.githubusercontent.com/66835270/189213433-bb3c39f7-cf79-4d6b-8b40-e41891dbdbea.png)

- Tiles & collections
![thumbnail2](https://user-images.githubusercontent.com/66835270/186597481-761baa52-520e-4288-9d6a-d7c1854e0d6d.png)
![thumbnail1](https://user-images.githubusercontent.com/66835270/186597482-8da758b4-465f-4877-84ab-8c4ca7bb37ac.png)

- Access to admin page
![accesDenied](https://user-images.githubusercontent.com/66835270/189213899-457352c2-6803-401e-9ed8-158a917f4aad.png)
![thumbnail3](https://user-images.githubusercontent.com/66835270/186597477-3a867345-50bd-4209-8605-94cf4632bac3.png)

## KNOWN BUGS/ISSUES:
-  When editing or deleting Tile there Tile opens referencing page
-  Lacks styling and responsiveness. JS may be the solution

## SHORT DOCUMENTATION:

(Entity Person is called user in description below)
1. To access page user has to log in or register
2. User can have any number of Collections
3. Collection can contain any umber of Tiles
4.  Blue tiles are links to pages. Red collection can group Tiles (that are under same topic/title). Collection
5. Collections can be collapsed to have prettier view

6. Person
    1. Persons name shouldn't be empty
    2. Password has no constraints
    3. Default role of registered user is USER
    4. Only user with role ADMIN can grant another user ADMIN privileges
    5. Can delete itself from database using Delete account button on main page
    6. Can logout
    7. If has role

7. Collection
    1. Collection can't have empty name
    2. Title of Collection should have from 2 to 50 characters

8. Tile
    1. Can't have empty name
    2. Should have from 2 to 30 characters
    3. Description can contain only up to 100 characters
    4. Can't have empty URL
    5. URL format is validated

9. Tile and Collection can be edited or deleted

10. When Collection is deleted, all its tiles are deleted
12. When Person is deleted from database (deleted account) all his Collections are deleted

11. Authorization and Authentication
    1. Unauthorized user can access only login and registration pages
    2. Only users with ADMIN role can access administrator page
    3. User with ADMIN role can set any other user to ADMIN
    4. .User with ADMIN role can delete any user
    5. User with role USER can delete only his page
    6. In case user with role USER attempts to access admin page, he is being warned about his role and not granted access

## Hierarchy of entities in database

![sqlDiagram](https://user-images.githubusercontent.com/66835270/186601545-408cd125-6155-41a5-a46f-58806dbe78a9.png)

## How to run

1. Clone src directory of this repository.
2. Run PostgreSQL database on your machine (with appropriate JDBC driver), or any other relational database.
3. Save all configuration data about your database (url, login, password) and JDBC driver information in directory **src/main/resources/** in file **database.properties**. All the fields should match **database.properties.origin** file that already exists in repository. 
4. Create database tables for this project. If you use PostgreSQL than by executing createAllTables.sql you can create all appropriate tables.
5. After that you should be able to run urlManager.

