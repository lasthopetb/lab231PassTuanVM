/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


showImageChoose(0);
var lastChoose;
function showImageChoose(n) {

    var x = document.getElementsByClassName("gallery-big-image");
    if (lastChoose != null) {
        x[lastChoose].classList.remove("gallery-display-block");
    }
    x[n].classList.add("gallery-display-block");
    lastChoose = n;

}
