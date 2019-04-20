(function(angular, baseURL) {
	var app = angular.module('RandomQuotes', [])
	
	app.constant('baseURL', baseURL)
	
	app.factory('quotes', ['baseURL', '$http', function(baseURL, $http) {
		var parser = new DOMParser()
		
		return {
			randomQuote: function() {
				return $http({
					method: 'GET',
					url: `${baseURL}quotes/random`,
					headers: {
						'Accept': 'application/json'
					}
				}).then(function(res) {
					var contentType = res.headers('Content-Type')
					//TODO: make it more robust
					if(contentType === 'application/xml') {
						var parsedData = parser.parseFromString(res.data, 'text/xml')
						//console.log(parsedData)
						var root = parsedData.getElementsByTagName('quote')[0]
						//console.log(root)
						var quote = root.getElementsByTagName('quote')[0].innerHTML
						var author = root.getElementsByTagName('author')[0].innerHTML
						return {
							quote: quote,
							author: author
						}
					}
					
					return res.data;
					
				}).catch(function(err) {
					console.log(err)
					return err
				})
			}
		}
	}])
	
	app.controller('RandomQuoteController',
					[
							'$scope',
							'quotes',
							function($scope, quotes) {
//								$scope.quote = {
//										quote : "I was always an observer, even as a child. I could be satisfied to sit in a car for 3 hours and just look at the street go by while my mother went shopping.",
//										author : "Jonathan Winters"
//								}
								
								$scope.refresh = function() {
									quotes.randomQuote().then(function(res) {
										//console.log(res)
										$scope.quote = res
									})
								}
								
								$scope.refresh()
								
							} ])
})(angular, baseURL)