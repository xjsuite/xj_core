$(document).ready(function (e) {
    $('#xj-pages').bootpag({
        total: $("#pages_count").val(),
        page: $("#pages_current").val()
    }).on("page", function (event, /* page number here */ page) {
        var url = $("#pages_url").val();
        var form_data = new FormData();
        form_data.append("page", page);
        $(".xj_searchitem").each(function (e) {
            form_data.append($(this).attr("name"), $(this).val());
        });
        $(".xj_settings").each(function (e) {
            form_data.append($(this).attr("name"), $(this).val());
//            alert($(this).attr("name")+ $(this).val());
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
});