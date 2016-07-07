'use strict';

/* App Module */

var angularBeer = angular.module('AngularBeer', [
  'ngRoute',
  'BeerControllers',
  'BeerFilters',
  'BeerServices'
]);

angularBeer.config(['$routeProvider',
  function($routeProvider) {
    $routeProvider.
      when('/beers', {
        templateUrl: 'partials/beer-list.html',
        controller: 'BeerListCtrl'
      }).
      when('/beers/:beerId', {
        templateUrl: 'partials/beer-detail.html',
        controller: 'BeerDetailCtrl'
      }).
      when('/create', {
          templateUrl: 'partials/beer-create.html',
          controller: 'BeerCreateCtrl'
      }).
      when('/edit/:beerId', {
          templateUrl: 'partials/beer-edit.html',
          controller: 'BeerEditCtrl'
      }).
      otherwise({
        redirectTo: '/beers'
      });
  }]);