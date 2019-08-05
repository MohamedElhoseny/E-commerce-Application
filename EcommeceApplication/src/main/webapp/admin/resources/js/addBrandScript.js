/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function testCategoryId(){
     if(document.getElementById('categoryName').value==""||document.getElementById('categoryName').value=="volvo" || document.getElementById('categoryName').value==null){
         alert('please choose category from table');
         return false;
     }
     
 }