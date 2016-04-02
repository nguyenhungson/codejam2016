$(document).ready(function(){
    var pathName = "/"; //window.location.pathname;
    var page = pathName.substring(pathName.lastIndexOf("/") + 1);
    $("#menuAll li").each(function(){
        $(this).removeClass('homers');
    });
    
    if(page == encodeURIComponent('Hướng dẫn')){
        $("#menuAll li:eq(5)").addClass('homers');
    }
    else if(page == encodeURIComponent('Trực tiếp')){
        $("#menuAll li:eq(1)").addClass('homers');
    }
    else if(page == "bang-xep-hang.html"){
        $("#menuAll li:eq(3)").addClass('homers');
        $("#titlePage").css("display", "none");
        clickRankMenu('england');
    }
    else if(page == "livescore.html"){
        $("#menuAll li:eq(4)").addClass('homers');
        $("#titlePage").css("display", "none");
    }
    else if(page == "video"){
        $("#menuAll li:eq(2)").addClass('homers');
    }
    else{
        $("#menuAll li:eq(0)").addClass('homers');
    }
});

function clickRankMenu(item){
    $("#rankMenu a").each(function(){
        $(this).removeClass("active");
    });
    
    $("#rankMenu a[data-menu=" + item + "]").addClass("active");
    
    $("#rankboard > div").each(function(){
        $(this).css("display", "none");
    });
    
    $("#" + item).css("display", "block");
}