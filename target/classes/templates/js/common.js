function sendRequest(type, resource, data, successHandler, errHandler) {
    jQuery.ajax({
        type: type,
        url: "http://localhost:8083/" + resource,
        data: data,
        dataType: "json",
        accepts: "application/json",

        success: function (data, status, jqXHR) {
            successHandler(data);
        },

        error: function (jqXHR, status) {
            errHandler(status);
        }
    });
}

function goToPage(url) {
    $(location).attr('href', url);
}