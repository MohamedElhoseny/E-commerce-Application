/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function testCategoryIdBrands() {
    if (document.getElementById('categoryName').value == "" || document.getElementById('categoryName').value == "volvo" || document.getElementById('brandID').value == "") {
        alert('please choose category from table');
        return false;
    }
}

 
var table = document.getElementById('dataTable');

for (var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function ()
    {
//        alert("s0");

        document.getElementById("brandID").value = this.cells[0].innerHTML;
        document.getElementById("brandName").value = this.cells[1].innerHTML;
        document.getElementById("categoryName").value = this.cells[3].id;
//        alert(this.cells[3].id);

    };
}

function updateCategory() {
    var table = $('#dataTable').DataTable();
    table.ajax.reload();
}

document.getElementById("updateSubmit").onsubmit = updateCategory;