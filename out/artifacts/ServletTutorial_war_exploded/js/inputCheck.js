function checkFields(form) {
    // alert(form);
    return checkY(form);
}

function checkY(value) {
    const number = Number(value);
    return value !== "" && !isNaN(number) && number >= -3 && number <= 3;
}