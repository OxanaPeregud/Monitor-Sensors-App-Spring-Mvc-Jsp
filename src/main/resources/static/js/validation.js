function printError(elemId, hintMsg) {
    document.getElementById(elemId).innerHTML = hintMsg;
}

function validateForm() {
    var name = document.sensorForm.name.value;
    var model = document.sensorForm.model.value;
    var rangeFrom = document.sensorForm.rangeFrom.value;
    var rangeTo = document.sensorForm.rangeTo.value;
    var type = document.sensorForm.type.value;
    var unit = document.sensorForm.unit.value;
    var location = document.sensorForm.location.value;
    var description = document.sensorForm.description.value;

    var nameErr = modelErr = rangeErr = typeErr = unitErr = true;

    if (name === "") {
        printError("nameErr", "Please enter name");
    } else {
        var regex1 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex1.test(name) === false) {
            printError("nameErr", "Please enter a valid name");
        } else {
            printError("nameErr", "");
            nameErr = false;
        }
    }

    if (model === "") {
        printError("modelErr", "Please enter model");
    } else {
        var regex2 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex2.test(model) === false) {
            printError("modelErr", "Please enter a valid model");
        } else {
            printError("modelErr", "");
            modelErr = false;
        }
    }

    if ((rangeFrom === "") && (rangeTo === "")) {
        rangeErr = false;
    } else {
        if (rangeFrom >= rangeTo) {
            printError("rangeErr", "Range From must be less than Range To");
        } else {
            printError("rangeErr", "");
            rangeErr = false;
        }
    }

    if (type === "") {
        printError("typeErr", "Please enter type");
    } else {
        var regex3 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex3.test(type) === false) {
            printError("typeErr", "Please enter a valid type");
        } else {
            printError("typeErr", "");
            typeErr = false;
        }
    }

    if (unit === "") {
        printError("unitErr", "Please enter unit");
    } else {
        var regex4 = /^[a-zA-Z0-9\W\s]+$/;
        if (regex4.test(unit) === false) {
            printError("unitErr", "Please enter a valid unit");
        } else {
            printError("unitErr", "");
            unitErr = false;
        }
    }

    if ((nameErr || modelErr || rangeErr || typeErr || unitErr) === true) {
        return false;
    } else {
        var dataPreview = "You've entered the following details: \n" +
            "Name: " + name + "\n" +
            "Model: " + model + "\n" +
            "Range From: " + rangeFrom + "\n" +
            "Range To: " + rangeTo + "\n" +
            "Type: " + type + "\n" +
            "Unit: " + unit + "\n" +
            "Location: " + location + "\n" +
            "Description: " + description;
        alert(dataPreview);
    }
}
