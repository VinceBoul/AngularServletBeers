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
	.controller( 'BeerDetailCtrl', [ '$scope', '$routeParams', 'Beer', function($scope, $routeParams, Beer) {
		$scope.beer = Beer.get({
			beerId : $routeParams.beerId
		}, function(beer) {
			$scope.mainImg = beer.img;
		});

		$scope.setImage = function(img) {
			$scope.mainImg = img;
		}
	} ])
	.controller( 'BeerEditCtrl', [ '$scope', '$routeParams', '$http', 'Beer', function($scope, $routeParams, $http, Beer) {
		$scope.beer = Beer.get({
			beerId : $routeParams.beerId
		}, function(beer) {
			$scope.beer = beer;
		});

		$scope.update = function(beerId) {
			$http({
				method : 'POST',
				url : 'BeerEdit',
				data : beerId, // forms user object
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

	$scope.update = function(beer) {
		console.log(beer);
		// Posting data to php file
		$http({
			method : 'POST',
			url : 'BeerCreate',
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
				$window.location.href = '#/beers';
			}
		});
	};
	$scope.reset = function() {
		$scope.beer = angular.copy($scope.master);
	};

	$scope.reset();
} ]);
