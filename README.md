# Spring Boot + Angular 4 + MongoDB 

To see more projects go to [my personal webpage](http://sergiomartin.dynu.com)

Spoilurcar is a Java Spring Boot, Angular 4 and MongoDB application to manage cars maintenance.

# How to deploy

  - Run your local MongoDB server or use [mLab](https://mlab.com/)
```sh
$ mongod
```
  - Run backend Java application in your favourite IDE
  - Run frontend Angular 4 appplication in your terminal:
```sh
$ cd spoilurcar/frontend
$ ng serve --open
```
`Be sure nodeJS and NPM are correctly installed and all Angular 4 libraries have been imported`(npm will be installed with Node)

```sh
$ brew install node
```
Install Angular 4:
```sh
$ npm install -g @angular/cli
```
