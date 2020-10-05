angular.module('app').controller('storeController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189';

    $scope.backPage = function(){
        $scope.page = $scope.Products.number;
        $scope.applyFilter();
    }

    $scope.forwardPage= function(){
         $scope.page = $scope.Products.number+2;
         if($scope.page>$scope.Products.totalPages){
            $scope.page=$scope.Products.totalPages;
         }
         $scope.applyFilter();
    }

     $scope.inPage = function(newPage){
             $scope.page = newPage;
             $scope.applyFilter();
        }

    $scope.fillTable = function () {
        $scope.page = 1;
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
             params: {  p: $scope.page,
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