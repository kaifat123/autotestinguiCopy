запуск проекта осуществляется стандартным вызовом _**mvn clean test**_
по умолчанию используется параметр `src/test/resources/config/conf.properties` **_driver.browser.name_**

доступна смена браузера в виде добавления опции _**-Dbrowser=yourBrowser**_
из следующего списка: 
````
chrome
firefox
edge
ie   //лучше не пользоваться, ведет себя крайне непредсказуемо
````