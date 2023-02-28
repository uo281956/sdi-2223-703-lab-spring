$(document).ready(function() {
    $("#languageDropDownMenuButton a").click(function (e) {
        e.preventDefault();
        let languageSelectedText = $(this).text();
        let languageSelectedValue = $(this).attr("value");

        $("#btnLanguage").text(languageSelectedText);
        window.location.replace('?lang='+languageSelectedValue);
        return false;
    });
});