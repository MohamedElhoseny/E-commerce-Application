// JavaScript Document
$("#addProductDetails").click(function () {
    var rowCount = $('#productDetails tr').length;
    rowCount = rowCount + 1;
    var content = '<tr>' +
            '<td><div class="custom-file">' +
            '<input type="file" class="custom-file-input" id=productimage' + rowCount + ' name=productimage' + rowCount + '>' +
            '<label class="custom-file-label" for="customFile">Choose Product Image</label>' +
            '</div></td>' +
            '</tr>';
    $("#productDetails").append(content);
});

 function testBrandID(){
     if(document.getElementById('brandID').value=="" || document.getElementById('brandID').value==null){
         alert('please choose category from table');
         return false;
     }
     
 }
//function testBrandID() {
//    alert("s");
//    if (document.getElementById("brandID").value == "volvo" || document.getElementById("brandID").value == "") {
//        alert(document.getElementById("brandID").value);
//        document.getElementById("chooseBrand").html('please choose brand ');
//        document.getElementById("chooseBrand").css('display:block;');
//        return false;
//    }
//}
//function getSelectedID() {
//    alert(document.getElementById("brandID").value);
//}