# Overview

Simple app implemented in MVC architecture pattern that helps managing web links into groups and allows multi - user support.

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

## Functionality in action - YouTube screencast of all application functions
https://youtu.be/zTXd9jDLNGI

## Screenshots

![thumbnail3](https://user-images.githubusercontent.com/66835270/186597477-3a867345-50bd-4209-8605-94cf4632bac3.png)
![thumbnail2](https://user-images.githubusercontent.com/66835270/186597481-761baa52-520e-4288-9d6a-d7c1854e0d6d.png)
![thumbnail1](https://user-images.githubusercontent.com/66835270/186597482-8da758b4-465f-4877-84ab-8c4ca7bb37ac.png)

## KNOWN BUGS/ISSUES:
-  Password has no constraints
-  When editing or deleting Tile there Tile opens referencing page
-  Lacks styling and responsivnes. JS may be the solution

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
    4. Only user with role ADMIN can grant another user ADMIN priviliges
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
    2. Only users wiht ADMIN role can access administator page
    3. User with ADMIN role can set any other user to ADMIN
    4. .User with ADMIN role can delete any user
    5. User with role USER can delete only his page
    6. In case user with role USER attempts to acces admin page, he is being warned about his role and not granted access


