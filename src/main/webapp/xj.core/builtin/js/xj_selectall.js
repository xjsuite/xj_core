
$(document.body).on("click", ".xj_selectall", function (e) {

    //var form = $(this).parents('form:first');
    var items = $(this).attr("xj-items");

    $(items).prop('checked', this.checked);

});