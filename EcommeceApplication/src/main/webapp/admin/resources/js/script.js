/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var table = document.getElementById('dataTable');

for (var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function ()
    {
        //rIndex = this.rowIndex;
        document.getElementById("categoryName").setAttribute("disabled", "false");
        document.getElementById("updateSubmit").setAttribute("disabled", "false");
        document.getElementById("deleteSubmit").setAttribute("disabled", "false");
        document.getElementById("categoryID").value = this.cells[0].innerHTML;
        document.getElementById("categoryName").value = this.cells[1].innerHTML;
    };
}

function updateCategory() {
    var table = $('#dataTable').DataTable();
    table.ajax.reload();
}

document.getElementById("updateSubmit").onsubmit = updateCategory;