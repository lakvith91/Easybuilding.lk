/**
 * Created by LakshanD on 11/26/2016.
 */
(function(){

    'use strict';
    angular.module('app')
        .controller('AdvertisementController',AdvertisementController);

    AdvertisementController.$inject = ['$http'];
    function AdvertisementController($http ){
        var vm=this;
        vm.adsList=[];
        vm.categoryList=[];
        vm.contractorList=[];
        vm.durationList=["6 Months","12 Months","18 Months"];

        vm.getAll= getAll;
        vm.deleteById=deleteById;
        vm.addAds=addAds;
        vm.getCategoryList=getCategory;


        init();

        function init(){
            getAll();
            getCategory();
            getContractors();


        }

        function getAll(){
            var url="/rest/ads";
            var adsList=$http.get(url);
            adsList.then(function(res){
                vm.adsList=res.data;
            });
        }
        function deleteById(id){
            var url="/rest/ads/"+id;
            var adsList=$http.delete(url);
            adsList.then(function(res){
                var index=vm.adsList.indexOf(id);
                vm.adsList.splice(index,1);

            });
        }

        function getCategory(){
            var url="/rest/category";
            var categoryList=$http.get(url);
            categoryList.then(function(res){
                vm.categoryList=res.data;
            });
        }

        function getContractors(){
            var url="rest/contractor";
            var contractors=$http.get(url);
            contractors.then(function(res){
                vm.contractorList=res.data;
            });
        }

        function addAds(ads){
            var url="/rest/ads";
            $http.post(url,ads).then(function(){
            });
        }

    }

})();