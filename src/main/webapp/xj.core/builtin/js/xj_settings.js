
$(document.body).on("click", ".xj_settings", function (e) {

    var form = $(this).parents('form:first');
    var url = $(form).attr("action");
    
    // rebuild post parameter
    var form_data = new FormData();
    var name = $(this).attr("name");
    form_data.append(name, $(this).attr("xj-value"));
    
    var btns = document.querySelectorAll('.xj_settings');
    $(".xj_settings").each(function (i, obj) {
        if (name !== $(obj).attr("name")) {
            form_data.append($(obj).attr("name"), $(obj).attr("xj-active"));
        }
    });    
    
    $(".xj_searchitem").each(function (e) {
        form_data.append($(this).attr("name"), $(this).val());
    });


    var pages_current = $(this).attr("xj-page");
    form_data.append("page", $(pages_current).val());

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