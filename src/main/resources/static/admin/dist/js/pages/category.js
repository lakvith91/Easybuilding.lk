/**
 * Created by LakshanD on 11/26/2016.
 */
(function(){

    'use strict';
    angular.module('app')
        .controller('CategoryController',CategoryController);

    CategoryController.$inject = ['$http'];
    function CategoryController($http ){
        var vm=this;
        vm.categoryList=[];

        vm.getAll= getAll;
        vm.deleteById=deleteById;
        vm.addCategory=addCategory;

        init();

        function init(){
            getAll();


        }

        function getAll(){
            var url="/rest/category";
            var categoryList=$http.get(url);
            categoryList.then(function(res){
                vm.categoryList=res.data;
            });
        }
        function deleteById(id){
            var url="/rest/category/"+id;
            var categoryList=$http.delete(url);
            categoryList.then(function(res){
                var index=vm.categoryList.indexOf(id);
                vm.categoryList.splice(index,1);
            });
        }

        function addCategory(category){
            var url="/rest/category";
            $http.post(url,category).then(function(res){

            });

        }

    }

})();