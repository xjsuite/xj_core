
$(document).on('click', '.xj_login', function (e) {
    var url = $(this).attr('xj-url') + "?" + $(this).attr("name") + "=";
    var alert = $(this).attr('xj-alert');
    var form_data = new FormData();
    $(".xj_loginitem").each(function () {
        form_data.append($(this).attr('name'), $(this).val());
    });
    e.preventDefault();
    $.ajax({
        url: url,
        type: "POST",
        contentType: false,
        processData: false,
        data: form_data,
        success: function (result) {
            if (result.status === 0) {
                swal("Failed", result.message, "danger");
                return false;
            }
            
            var post_data = new FormData();
            post_data.append("sessionkey", result.sessionkey);

            $.ajax({
                url: result.url,
                type: "POST",
                contentType: false,
                processData: false,
                data: post_data,
                success: function (result) {
                    document.open("text/html", "replace");
                    document.write(result);
                    document.close();
                    return true;
                }
            });
        }
    });
});
