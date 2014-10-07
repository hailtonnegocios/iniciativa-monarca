/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(document).ready(function (){
    $("#img_logo").click(function(){$("#rodape").css("visibility","hidden");});
    $(window).load(function(){$("#rodape").css("visibility","hidden");});
    $(window).scroll(function(){ 
         
            if ( window.pageYOffset < 150 )
            {
//                alert("entrei " + window.pageYOffset );
                $("#seta_up").css("visibility","hidden");
                $("#rodape").css("visibility","hidden");
            }
            if (window.pageYOffset > 150)
            {
               $("#rodape").css("visibility","visible");
               $("#seta_up").css({
                   "visibility":"visible",
                   "position":"fixed",
                   "right":"25px",
                   "top":"540px"});
               }
               
          });
     });
    
