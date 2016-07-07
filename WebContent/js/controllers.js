'use strict';

/* Controllers */

angular
  .module('BeerControllers', [])
  .controller('BeerListCtrl', ['$scope', 'Beer', function($scope, Beer) {

    $scope.beers = Beer.query();

    $scope.orderProp = 'alcohol';
  }])
  .controller('BeerDetailCtrl', ['$scope', '$routeParams', 'Beer', function($scope, $routeParams, Beer) {

    $scope.beer = Beer.get({beerId: $routeParams.beerId}, function(beer) {
      $scope.mainImg = beer.img;
    });

    $scope.setImage = function(img) {
      $scope.mainImg = img;
    }
  }])
  
  .controller('BeerCreateCtrl', ['$scope', function($scope) {
	  $scope.master = {};

      $scope.update = function(beer) {
        $scope.master = angular.copy(beer);
      };

      $scope.reset = function() {
        $scope.beer = angular.copy($scope.master);
      };

      $scope.reset();
  }]);

