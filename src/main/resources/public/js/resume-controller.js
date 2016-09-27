angular.module('app.resumeController', [])
    .controller('ResumeDisplayController', ['$scope', '$http', function ($scope, $http) {

        console.log(">>>>>>>>>>>>>>> RESUME CONTROLLER");


        $scope.submitInfo = function () {
            // use $.param jQuery function to serialize data from JSON
            var data = {
                name : $scope.name,
                email : $scope.email
            };

            var config = {
                headers: {
                    'Accept': 'application/json',
                    'Content-Type': 'application/x-www-form-urlencoded;charset=utf-8;'
                }
            }

            $http.post('/my-site/api/v1/resume/submit', data, config)
                .success(function (data, status, headers, config) {
                    $scope.PostDataResponse = data;
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                        "<hr />status: " + status +
                        "<hr />headers: " + header +
                        "<hr />config: " + config;
                });
        };
    }]);