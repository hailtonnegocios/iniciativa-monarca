/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function(){
    $('back_menu').toggle();
    
});

    
/* MOVIMENTO DE SCROLL */    
$(document).ready(function x() {
        $('a[href*=#]:not([href=#])').click(function() {
            if (location.pathname.replace(/^\//, '') === this.pathname.replace(/^\//, '') || location.hostname === this.hostname) {

                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
  
    
/* Tooltips  */
$(document).ready(function(){
    $('a[title]').tooltip();
    $('i[title]').tooltip();
    $('p[title]').tooltip();
});
