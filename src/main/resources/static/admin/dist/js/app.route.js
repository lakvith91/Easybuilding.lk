/**
 * Created by LakshanD on 12/17/2016.
 */
(function(){
    'use strict';
    angular
        .module('app')
        .config(function(stateProvider,$urlRouterProvider,$urlMatcherFactoryProvider){


            $urlRouterProvider.otherwise('/home');
            $stateProvider
                .state('contractor', {
                    url: 'admin/contractor',
                    templateUrl: '../contractor.html',
                    controller: 'ContractorController'
                })
                .state('home', {
                    url: '/home',
                    templateUrl: '../../index.html',
                    controller: 'HomeController'
                });
        });







})();
