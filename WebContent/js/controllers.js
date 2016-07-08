'use strict';

/* Controllers */

angular.module('BeerControllers', [])
	.controller('BeerListCtrl',	[ '$scope', '$http', function($scope, $http) {
		$http.get('BeerList').success(function(data) {
			console.log(data);
		      $scope.beers = data;
		    });

	    $scope.orderProp = 'alcohol';
		
	} ])
	.controller( 'BeerDetailCtrl', [ '$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {
		$http({
			method : 'GET',
			url : 'BeerDetail',
			params : { 'beerId' : $routeParams.beerId }, // forms user object
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.beer = data;
			$scope.mainImg = data.image;

		});
		
	} ])
	.controller( 'BeerEditCtrl', [ '$scope', '$routeParams', '$http', function($scope, $routeParams, $http) {

		$http({
			method : 'GET',
			url : 'BeerDetail',
			params : { 'beerId' : $routeParams.beerId }, // forms user object
			headers : {
				'Content-Type' : 'application/x-www-form-urlencoded'
			}
		}).success(function(data) {
			$scope.beer = data;
		});
		
		$scope.update = function(beer) {
			$http({
				method : 'POST',
				url : 'BeerEdit',
				data : beer, // forms user object
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				if (data.errors) {
					// Showing errors.
					$scope.errorName = data.errors.name;
					$scope.errorUserName = data.errors.username;
					$scope.errorEmail = data.errors.email;
				} else {
					console.log(data);
					//$window.location.href = '#/beers';
				}
			});
		}
	} ])
	.controller('BeerCreateCtrl', [ '$scope', '$http', '$window', function($scope, $http, $window) {
		$scope.master = {};
		// create a blank object to handle form data.
		$scope.beer = {};
		// calling our submit function.	
	
		// Envoi des informations de la bière en POST
		$scope.update = function(beer) {
			$http({
				method : 'POST',
				url : 'BeerCreate',
				data : beer,
				headers : {
					'Content-Type' : 'application/x-www-form-urlencoded'
				}
			}).success(function(data) {
				if (data.errors) {
					// Showing errors.
					$scope.errorName = data.errors.name;
					$scope.errorUserName = data.errors.username;
					$scope.errorEmail = data.errors.email;
				} else {
					console.log(data);
					$window.location.href = '#/beers';
				}
			});
		};
		$scope.reset = function() {
			$scope.beer = angular.copy($scope.master);
		};
		$scope.reset();
	}])
;
