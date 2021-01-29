 $(document).ready(function () {
     $(".open").on('click', function () {
         $(".popup").show();
         $(".dim").show();
     });
     $(".close").on('click', function () {
         $(".popup").hide();
         $(".dim").hide();
     });
 });

 $(document).ready(function () {
     $(".open2").on('click', function () {
         $(".popup2").show();
         $(".dim").show();
     });
     $(".close2").on('click', function () {
         $(".popup2").hide();
         $(".dim").hide();
     });
 });
$(document).ready(function () {
     $(".open3").on('click', function () {
         $(".popup3").show();
         $(".dim").show();
     });
     $(".close3").on('click', function () {
         $(".popup3").hide();
         $(".dim").hide();
     });
 });
function moneyComma(val){
	return val.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",") + " 원";
}
