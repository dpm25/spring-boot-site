angular.module('app.resumeController', [])
    .controller('ResumeDisplayController', ['$scope', '$http', '$state', function ($scope, $http, $state) {

        $scope.submitInfo = function () {
            // use $.param jQuery function to serialize data from JSON
            var data = {
                name : $scope.name,
                email : $scope.email
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            $http.post('/my-site/api/v1/resume/submit', data, config)
                .success(function (data, status, headers) {
                    $scope.PostDataResponse = data;
                    $state.go('resume');
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                        "<hr />status: " + status +
                        "<hr />headers: " + header +
                        "<hr />config: " + config;
                });
        };
    }]);