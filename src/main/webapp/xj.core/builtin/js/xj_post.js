/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).on("click", ".xj_post", function (e) {

    var url = $(this).attr("xj-url");

    var form_data = new FormData();
    $(".xj_postitem").each(function () {
        form_data.append($(this).attr("name"), $(this).value);
    });
    
    e.preventDefault();

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
