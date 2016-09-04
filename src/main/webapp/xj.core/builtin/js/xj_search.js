
$(document.body).on("click", ".xj_search", function (e) {

    var form = $(this).parents('form:first');
    var url = $(form).attr("action");


    // rebuild post parameter
    var form_data = new FormData();
    $(".xj_searchitem").each(function (e) {
        form_data.append($(this).attr("name"), $(this).val());
    });
    $(".xj_settings").each(function (e) {
        form_data.append($(this).attr("name"), $(this).val());
    });
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

});