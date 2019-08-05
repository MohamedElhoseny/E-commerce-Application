/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function readURLupdate(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();

        reader.onload = function (e) {
            $('#profile-img-tag').attr('src', e.target.result);
            
        }
        reader.readAsDataURL(input.files[0]);
    }
}
// A $( document ).ready() block.
$(document).ready(function () {



    $("#email").blur(function () {
        email = $("#email").val();
        // check if the user is registered 
        $.post("../validation", {email: email}, function (data) {

            if (data === "true") {

                $("#submit-button").attr("disabled", false);
                $("#email-validation").html("Valid")
            } else
            {
                $("#email-validation").html("Invalid")
                $("#submit-button").attr("disabled", true);
            }

        });
    });


    // make sure the user agrees on terms and conditions and privacy policy
    $('#updateSubmit').submit(function () {

        // confirm the password the user entered
        if ($('#new-password').val() !== $('#input-password-confirm').val()) {
            swal("please make sure that you entered a right password confirmation");
            return false;
        }

    });
    $("#upload-photo").change(function () {
        readURLupdate(this);
    });

});


