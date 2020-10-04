angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189';

    $scope.fillTable = function () {
        $scope.filter=null;
        console.log('fill');
        $http.get(contextPath + '/api/v1/products')
               .then(function (response) {
                $scope.Products = response.data;
            });
    };

     $scope.applyFilter = function () {
         $http({
             url: contextPath + '/api/v1/products',
             method: "GET",
             params: {  p: 0,//$scope.filter.page,
                        minPrice: $scope.filter.min_price,
                        maxPrice: $scope.filter.max_price,
                        titlePart: $scope.filter.title_part
                        }
         }).then(function (response) {
              $scope.Products = response.data;
         });
     }

    $scope.fillTable();
});