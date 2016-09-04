/*
 * Develop by Hendranto Nugroho
 * Required:  jquery validate, jquery inpromptu
 */


$(document.body).on("click", ".xj_linkconfirmation", function (e) {

    var confirmation = $(this).attr("xj-text") + " ?";

    var url = $(this).attr("xj-url");       // target url
    var mode = $(this).attr("xj-mode");     // 3modes=confirmation(get), post, link(get)
    var data = $(this).attr("xj-data");     // data to pasing to server                  
    var indexurl = url.indexOf("?");

    e.preventDefault();

    var states = {
        pre: {
            html: confirmation,
            buttons: {Cancel: false, Continue: true},
            focus: 1,
            submit: function (e, v, m, f) {
                if (v) {
                    if (mode === "confirmation") {
                        if (indexurl !== -1) {
                            url += "&" + data;
                        } else {
                            url += "?" + data;
                        }
                        $.ajax({
                            url: url,
                            type: "GET",
                            contentType: false,
                            processData: false,
                            dataType: "JSON",
                            success: function (result) {
                                $("#xj-result-message").html(result.message);
                                $("#xj-result-url").val(result.url);
                                $("#xj-title").html("Result");

                                $.prompt.goToState('result');
                                return false;
                            }
                        });
                        return false;
                    }
                    if (mode === "post") {

                        var form_data = new FormData();
                        if (data !== undefined) {
                            var multiple_data = data.split("&");

                            for (var i = 0; i < multiple_data.length; i++) {
                                var single_data = multiple_data[i].split("=");
                                form_data.append(single_data[0], single_data[1]);
                            }
                        }
                        $.ajax({
                            url: url,
                            type: "POST",
                            contentType: false,
                            processData: false,
                            data: form_data,
                            success: function (result) {
                                document.open("text/html", "replace");
                                document.write(result);
                                document.close();
                                return true;
                            }
                        });
                        return false;
                    }
                    if (indexurl !== -1) {
                        url += "&" + data;
                    } else {
                        url += "?" + data;
                    }
                    window.location = url;
                    return false;
                }
                $.prompt.close();
            }
        },
        result: {
            html: "<h4 id='xj-result-message'></h4><input type=\"hidden\" id=\"xj-result-url\" />",
            buttons: {Ok: true},
            focus: 1,
            submit: function (e, v, m, f) {
                window.location = $("#xj-result-url").val();
                $.prompt.close();
            }
        }
    };
    $.prompt(states);
});

