
function testBrandIdProducts() {
    if (document.getElementById('brandID').value == "" || document.getElementById('productID').value == "") {
        alert('please choose Product from table');
        return false;
    }
}

var table = document.getElementById('dataTable');

for (var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function ()
    {
//        alert(this.cells[7].innerHTML);
        var description = JSON.parse(this.cells[7].innerHTML);
//        console.log(description);
        document.getElementById("productProcessor").value = description.processor;
        document.getElementById("productRam").value = description.ram;
        document.getElementById("productStorage").value = description.storage;
        document.getElementById("productOS").value = description.os;
        document.getElementById("productGraphicsCard").value = description.graphicsCard;
        document.getElementById("productDescription").value = description.description;
        
        document.getElementById("productName").value = this.cells[1].innerHTML;
        document.getElementById("productPrice").value = this.cells[2].innerHTML;
        document.getElementById("productQuantity").value = this.cells[3].innerHTML;
        document.getElementById("productColor").value = this.cells[4].innerHTML;
        document.getElementById("brandName").value = this.cells[6].id;
        document.getElementById("brandID").value = this.cells[6].id;
        document.getElementById("productID").value = this.cells[0].id;
//        alert(document.getElementById("brandID").value + ":" + document.getElementById("productID").value);

    };
}

function updateCategory() {
    alert(document.getElementById("manageForm").getAttribute("action"));
    document.getElementById("manageForm").setAttribute("action", "CreateProduct?action=deleteProduct");
}

document.getElementById("deleteBtn").onclick = updateCategory;