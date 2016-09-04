/*
 * Develop by Hendranto Nugroho
 * Required:  jquery validate, jquery inpromptu
 */
$(document.body).on("click", ".xj_submitvalidateconfirmation", function (e) {

    var form = $(this).parents('form:first');

    var confirmation = $(this).attr("xj-text") + " ?";
    var validateerrormessage = $(this).attr("xj-text") + " has Invalid Data ";
    var url = $(form).attr("action") + "?" + $(this).attr("name") + "=";
    
    e.preventDefault();

    $(form).validate();
    if (!$(form).valid()) {
        $.prompt(validateerrormessage);
        return false;
    }

    var states = {
        pre: {
            html: confirmation,
            buttons: {Cancel: false, Next: true},
            focus: 1,
            submit: function (e, v, m, f) {
                if (v) {
                    $.ajax({
                        url: url,
                        type: "POST",
                        dataType: "JSON",
                        data: $(form).serializeArray(),
                        success: function (result) {
                            $("#xj-result-message").html(result.message);
                            $("#xj-result-url").val(result.url);
                            $("#xj-title").html("Result");
                            $.prompt.goToState('complete');
                            return true;

                        }
                    });
                    return false;
                }
                $.prompt.close();
            }
        },
        complete: {
            html: "<h4 id='xj-result-message'></h4><input type=\"hidden\" id=\"xj-result-url\" />",
            buttons: {Ok: 0},
            focus: 1,
            submit: function (e, v, m, f) {
                window.location = $("#xj-result-url").val();
                $.prompt.close();
            }
        }
    };
    $.prompt(states);
});

