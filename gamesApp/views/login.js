function validate()
{
    var status = true;

    //username
    if ((document.getElementById('txtUsername').value).match(/^[A-Za-z0-9]+$/))
    {
        document.getElementById('usernameResult').src = 'correct.png'
    }
    else
    {
        document.getElementById('usernameResult').src = 'wrong.png'
        status = false;
    }

    //password
    if ((document.getElementById('txtPassword').value).match(/^[A-Za-z0-9]+$/))
    {
        document.getElementById('passwordResult').src = 'correct.png'
    }
    else
    {
        document.getElementById('passwordResult').src = 'wrong.png'
        status = false;
    }

    //success
    if (status)
    {
        //submit form
        document.getElementById("myForm").submit();
    }
}