var app = angular.module('blog', []);

app.controller('HomeController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/persoana';

    $scope.persoane = [];
    $scope.fields = [];
    $scope.persoana = {};


    $scope.person = {};
    $scope.editPerson = {};
	

	



    $http.get(url).then(function successCallback(response) {

        $scope.persoane = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.persoane);
        //console.log($scope.fields);

    });
	
	$scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalPersoana = response.data;
        });

    };


    $scope.addPersoana = function(persoana) {
        persoana.id = parseInt(persoana.id);
        console.log(persoana.id);
        $http({
            method: 'POST',
            url: url,
            data: persoana
        }).then(function successCallback(response) {
            console.log(response);
            $scope.persoane.push(persoana);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deletePersoana = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.persoane = $scope.persoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdatePerson = function(person) {
        $scope.editPerson = person;
		$scope.initialId = person.id;
    };


    $scope.updatePerson = function(editPerson) {
		if (typeof $scope.initialId === 'undefined') {
            $scope.initialId = editPerson.id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialId + '/' + editPerson.id + '/' + editPerson.name,
            data: $scope.editPerson
        }).then(function successCallback(response) {
            $scope.editPerson = {};
            console.log(response);
            // $scope.persoane.push($scope.editPerson);
            // done.
        }, function errorCallback(response) {
            $scope.editPerson = {};
            console.log(response);
        });
    };

}]);



app.controller('MasinaController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/masina';

    $scope.masini = [];
    $scope.fields = [];
    $scope.masina = {};


    $scope.editMasina = {};
	

	



    $http.get(url).then(function successCallback(response) {

        $scope.masini = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.masini);
        //console.log($scope.fields);

    });
	
	
	$scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalMasina = response.data;
        });

    };


    $scope.addMasina = function(masina) {
        masina.id = parseInt(masina.id);
        console.log(masina.id);
        $http({
            method: 'POST',
            url: url,
            data: masina
        }).then(function successCallback(response) {
            console.log(response);
            $scope.masini.push(masina);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteMasina = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.masini = $scope.masini.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateMasina = function(masina) {
        $scope.editMasina = masina;
		$scope.initialId = masina.id;
    };


    $scope.updateMasina = function(editMasina) {
		if (typeof $scope.initialId === 'undefined') {
            $scope.initialId = editMasina.Id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialId + '/' + editMasina.id + '/' + editMasina.name + '/' + editMasina.marca,
            data: $scope.editMasina
        }).then(function successCallback(response) {
            $scope.editMasina = {};
            console.log(response);

        }, function errorCallback(response) {
            $scope.editMasina = {};
            console.log(response);
        });
    };

}]);


app.controller('SerialController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/serial';

    $scope.seriale = [];
    $scope.fields = [];
    $scope.serial = {};


    $scope.editSerial = {};
	

	



    $http.get(url).then(function successCallback(response) {

        $scope.seriale = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.seriale);
        //console.log($scope.fields);

    });
	
	
	$scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalSerial = response.data;
        });

    };


    $scope.addSerial = function(serial) {
        serial.id = parseInt(serial.id);
        console.log(serial.id);
        $http({
            method: 'POST',
            url: url,
            data: serial
        }).then(function successCallback(response) {
            console.log(response);
            $scope.seriale.push(serial);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteSerial = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.seriale = $scope.seriale.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateSerial = function(serial) {
        $scope.editSerial = serial;
		$scope.initialId = serial.id;
    };


    $scope.updateSerial = function(editSerial) {
		if (typeof $scope.initialId === 'undefined') {
            $scope.initialId = editSerial.Id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialId + '/' + editSerial.id + '/' + editSerial.titlu + '/' + editSerial.numarSez + '/' + editSerial.numarEp,
            data: $scope.editSerial
        }).then(function successCallback(response) {
            $scope.editSerial = {};
            console.log(response);

        }, function errorCallback(response) {
            $scope.editSerial = {};
            console.log(response);
        });
    };

}]);


app.controller('TelefonController', ['$scope', '$http', function ($scope, $http) {

    $scope.helloWorld = 'Bine ati venit la laboratorul de Aplicatii Web cu suport Java';
    var url = 'http://localhost:8080/telefon';

    $scope.telefoane = [];
    $scope.fields = [];
    $scope.telefon = {};


    $scope.editTelefon = {};
	

	



    $http.get(url).then(function successCallback(response) {

        $scope.telefoane = response.data;
        $scope.fields = Object.keys(response.data[0]);

        console.log($scope.telefoane);
        //console.log($scope.fields);

    });
	
	
	$scope.modalFct = function(id) {
        $scope.modalID = id;
        $http.get(url + '/' + $scope.modalID). then(function succesCallBack(response) {
            $scope.modalTelefon = response.data;
        });

    };


    $scope.addTelefon = function(telefon) {
        telefon.id = parseInt(telefon.id);
        console.log(telefon.id);
        $http({
            method: 'POST',
            url: url,
            data: telefon
        }).then(function successCallback(response) {
            console.log(response);
            $scope.telefoane.push(telefon);
            // done.
        }, function errorCallback(response) {
            console.log(response);
        });
    };


    $scope.deleteTelefon = function(id) {
        $http({
            method: 'DELETE',
            url: url+'/' + id,
            data: {}
        }).then(function successCallback(response) {
            // aici nu intra niciodata ca e functia de succes
        }, function errorCallback(response) {
            // aici intra pentru ca da eroare
            $scope.telefoane = $scope.telefoane.filter(function(obj) {
                return obj.id !== id;
            });
        });
    };



    $scope.setUpdateTelefon = function(telefon) {
        $scope.editTelefon = telefon;
		$scope.initialId = telefon.id;
    };


    $scope.updateTelefon = function(editTelefon) {
		if (typeof $scope.initialId === 'undefined') {
            $scope.initialId = editTelefon.Id;
        }
        $http({
            method: 'PUT',
            url: url + '/' + $scope.initialId + '/' + editTelefon.id + '/' + editTelefon.model + '/' + editTelefon.numar,
            data: $scope.editTelefon
        }).then(function successCallback(response) {
            $scope.editTelefon = {};
            console.log(response);

        }, function errorCallback(response) {
            $scope.editTelefon = {};
            console.log(response);
        });
    };

}]);