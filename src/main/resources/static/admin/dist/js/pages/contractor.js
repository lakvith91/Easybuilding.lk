/**
 * Created by LakshanD on 11/14/2016.
 */
(function(){

    'use strict';
    angular.module('app',['datatables'])
        .controller('ContractorController',ContractorController);

    ContractorController.$inject = ['$http'];
    function ContractorController($http ){
        var vm=this;
        vm.contractors=[];
        vm.categoryList=[];

        vm.addContractor=addContractor;
        vm.getAll= getAll;
        vm.getCategoryList=getCategoryList;
        vm.deleteById=deleteById;

        init();

        function init(){
            getAll();
            getCategoryList();

        }

        function getAll(){
            var url="/rest/contractor";
            var contractorList=$http.get(url);
            contractorList.then(function(res){
                vm.contractors=res.data;
            });
        }

        function deleteById(id){
            var url="/rest/contractor/"+id;
            var contractorList=$http.delete(url);
            contractorList.then(function(res){
                var index=vm.contractors.indexOf(id);
                vm.contractors.splice(index,1);

            });
        }

        function getCategoryList(){
            var url="/rest/category";
            var categoryList=$http.get(url);
            categoryList.then(function (res) {
                vm.categoryList=res.data;
            });
        }
        function addContractor(contractor){
            var url="/rest/contractor";
            $http.post(url,contractor).then(function(res){

                }
            );
            console.log(contractor);

        }

    }

})();