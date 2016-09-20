angular.module('app.navController', [])
	.controller('nav', function($scope, $state) {
		$scope.title = 'Home';

		// returns true if the current router url matches the passed in url
		// so views can set 'active' on links easily
		$scope.isUrl = function(url) {
			if (url === '#') return false;
			return ('#' + $state.$current.url.source + '/').indexOf(url + '/') === 0;
		};

		$scope.pages = [
			{
				name: 'Bio',
				url: '#/'
			},
			{
				name: 'Todo List',
				url: '#/todos'
			},
			{
				name: 'Resume',
				url: '#/resume'
			}
		]
	});
