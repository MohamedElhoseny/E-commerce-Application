/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var table = document.getElementById('usersTable');

for (var i = 1; i < table.rows.length; i++)
{
    table.rows[i].onclick = function ()
    {
        document.getElementById("userDetails").innerHTML = '<table>'
                +'<tr><td><div style="text-align: center"><img src="../client/images/user_image/' + this.cells[8].id + '" style="width: 100px; height: 65px;" alet="user image"/></div></td></tr><br>'
                + '<tr><td>User Name    :</td><td>' + this.cells[0].innerHTML + '</td></tr><br>'
                + '<tr><td>User Phone   :</td><td>' + this.cells[5].innerHTML + '</td></tr><br>'
                + '<tr><td>User Email   :</td><td>' + this.cells[2].innerHTML + '</td></tr><br>'
                + '<tr><td>User Gender  :</td><td>' + this.cells[3].innerHTML + '</td></tr><br>'
                + '<tr><td>Date of Birth:</td><td>' + this.cells[4].innerHTML + '</td></tr><br>'
                + '<tr><td>User Address :</td><td>' + this.cells[1].innerHTML + '</td></tr><br>'
                + '<tr><td>User Credit  :</td><td>' + this.cells[6].innerHTML + '</td></tr><br>'
                + '<tr><td>User Wallet  :</td><td>' + this.cells[7].innerHTML + '</td></tr><br>'
                + '</table>';
    };
}