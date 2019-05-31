/*响应式的文字*/
/*让文字的大小能随着屏幕变化而变化*/
/*先取到屏幕的宽度*/
/*让文字和屏幕成比例*/
/*将屏幕控制在320p到1080p*/
var html = document.getElementsByTagName('html')[0];
var width = window.innerWidth;
if (width > 1080) {
    width = 1080;
}
else if (width < 320 ) {
    width = 320 ;
}
var fontSize = 100/1080*width;

html.style.fontSize = fontSize +'px';
window.onresize = function(){
    var html = document.getElementsByTagName('html')[0];
    var width = window.innerWidth;
    if (width > 1080) {
        width = 1080;
    }
    else if (width < 320 ) {
        width = 320 ;
    }
	/* 640 100  320 50 */
    var fontSize = 100/1080 * width;
    html.style.fontSize = fontSize +'px';
}