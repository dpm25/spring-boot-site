angular.module('app.resumeController', ['ngMaterial'])
    .controller('ResumeDisplayController', ['$scope', '$http', '$state', '$mdDialog', function ($scope, $http, $state, $mdDialog) {

        $scope.submitInfo = function () {
            // use $.param jQuery function to serialize data from JSON
            var data = {
                name: $scope.name,
                email: $scope.email
            };

            var config = {
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            $http.post('/my-site/api/v1/resume/submit', data, config)
                .success(function (data, status, headers) {
                    $scope.PostDataResponse = data;
                    open();
                    $state.go('todos');
                })
                .error(function (data, status, header, config) {
                    $scope.ResponseDetails = "Data: " + data +
                        "<hr />status: " + status +
                        "<hr />headers: " + header +
                        "<hr />config: " + config;
                });
        };

        $scope.showAlert = function(ev) {
            // Appending dialog to document.body to cover sidenav in docs app
            // Modal dialogs should fully cover application
            // to prevent interaction outside of dialog
            $mdDialog.show(
                $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('This is an alert title')
                    .textContent('You can specify some description text in here.')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Got it!')
                    .targetEvent(ev)
            );
        };
    }]);