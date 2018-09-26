var app = angular.module('BookAppClient',['ngRoute']);
    app.config(['$routeProvider',function ($routeProvider) {
        $routeProvider
            .when('/login',{
                templateUrl:'../views/login.html', controller:'RegistrationController'
            })
            .when('main',{templateUrl:'views/main.html',controller:'mainController'})
            .otherwise({redirectTo:'login'})
    }])

    app.controller('logincontroller', function ($scope,$window ) {
      $scope.login=function () {

          $window.location.href = "../views/test.html"
          console.log('test')
      }
        $('.toggle').on('click', function() {
            $('.container').stop().addClass('active');
        });

        $('.close').on('click', function() {
            $('.container').stop().removeClass('active');
        });
 })