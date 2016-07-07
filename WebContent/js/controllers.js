'use strict';

/* Controllers */

angular.module('BeerControllers', []).controller('BeerListCtrl',
		[ '$scope', 'Beer', function($scope, Beer) {

			$scope.beers = Beer.query();

			$scope.orderProp = 'alcohol';
		} ]).controller(
		'BeerDetailCtrl',
		[ '$scope', '$routeParams', 'Beer',
				function($scope, $routeParams, Beer) {

					$scope.beer = Beer.get({
						beerId : $routeParams.beerId
					}, function(beer) {
						$scope.mainImg = beer.img;
					});

					$scope.setImage = function(img) {
						$scope.mainImg = img;
					}
				} ])

.controller('BeerCreateCtrl', [ '$scope', '$http', function($scope, $http) {
	$scope.master = {};
	// create a blank object to handle form data.
	$scope.beer = {};
	// calling our submit function.

	$scope.update = function(beer) {

		// Posting data to php file
		$http({
			method : 'POST',
			url : 'BeerCreate',
			data : $scope.beer, // forms user object
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
				$scope.message = data.message;
			}
		});
	};
/*
	$scope.update = function(beer) {
		$scope.master = angular.copy(beer);
	};
*/
	$scope.reset = function() {
		$scope.beer = angular.copy($scope.master);
	};

	$scope.reset();
} ]);
