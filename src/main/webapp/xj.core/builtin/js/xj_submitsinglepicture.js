/*
 * Develop by Hendranto Nugroho
 */

$(document.body).on('click', '.xj_submitsinglepicture', function (e) {

    var picture = $(this).attr("xj-picture");
    var url = $(this).attr("xj-submiturl");
    var variable = $(this).attr("xj-submitvariable");
    var output = $(this).attr("xj-variableoutput");
    
    var picture_data = $(picture).prop("files")[0];
    var form_data = new FormData();
    form_data.append(variable, picture_data);
    
    $.ajax({
        url:  url,
        type: "POST",
        contentType: false,
        processData: false,
        data: form_data,
        success: function (result) {   
           $(output).val(result);
           return true;
        }
    });

});
