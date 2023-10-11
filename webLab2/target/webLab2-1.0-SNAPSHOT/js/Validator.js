function validate(x, y, r) {

    let validationInfoBox = document.getElementById("validationInfo");
    validationInfoBox.innerHTML = '';

    let validationInfo = '';
    let xValidationSuccess = false;
    let yValidationSuccess = false;
    let rValidationSuccess = false;
    let validationSuccess;

    if (r === undefined || r === '') {
        validationInfo += "<span>R is not set!</span>";
    } else {
        rValidationSuccess = true;
    }
    if (!(y.trim() === '')) {
        let parsedY = parseFloat(y);
        if (!isNaN(parsedY)) {
            if ((parseFloat(y) > -3) && (parseFloat(y) < 3)) {
                yValidationSuccess = true;
            } else validationInfo += '<span>Y must be a number in (-3..3)!</span>';
        } else {
            validationInfo += '<span>Y must be a number in decimal number system!</span>';
        }
    } else validationInfo += '<span>Y is not set!</span>';
    if (!(x.trim() === '')) {
        let parsedX = parseFloat(x);
        if (!isNaN(parsedX)) {
            if ((parseFloat(x) > -5) && (parseFloat(x) < 3)) {
                xValidationSuccess = true;
            } else validationInfo += '<span>X must be a number in (-5..3)!</span>';
        } else {
            validationInfo += '<span>X must be a number in decimal number system!</span>';
        }
    } else validationInfo += '<span>X is not set!</span>';
    validationSuccess = xValidationSuccess && yValidationSuccess && rValidationSuccess;
    if (!validationSuccess) {
        document.getElementById("validationInfo").innerHTML = validationInfo;
    }
    return validationSuccess;
}