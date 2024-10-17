//Let's define some variables to represent the form data
//At the beginning, the form is empty, and therefore, not valid

//Data to send
var formData = {
    username: "",
    email: "",
    password: "",
    buyer: false,
    seller: false
}

//This data will be read but not be sent as part of the form submission
var formValid= false;
var repPassword="";
var tosCheckBox=false;


//Function to read the form
function readForm(){
   formData.username = document.getElementById("name").value.trim();
   formData.email = document.getElementById("email").value.trim();
   formData.password = document.getElementById("password").value.trim();
   repPassword = document.getElementById("repPassword").value.trim();

    //Read the buyer and seller checkboxes 
    formData.buyer = document.getElementById("buyer").checked;
    formData.seller = document.getElementById("seller").checked;

    tosCheckBox = document.getElementById("tos").checked;

}

//Function to validate the form
function validateForm() {
    formValid = false;
    var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;
   
    if ((formData.username.length==0) || 
           (formData.email.length==0)  ||
           (formData.password.length==0) ||
           (repPassword.length == 0)){
            alert("Please fill in all text fields.");
    } else if (!formData.email.match(mailformat)){
        alert("Invalid e-mail address. Please enter your e-mail again.");
    } else if (formData.password.length < 8){
        alert("Password is too short. Please select another password");
    } else if(formData.password !== repPassword) {
        alert("Passwords do not match. Please retry");
    } else if(!formData.buyer && !formData.seller){
        alert("Please check at least one checkbox to be a seller or a buyer.")
    } else if (!tosCheckBox){ 
        alert("Please agree to the Terms and Conditions, and Privacy Policy.")
    }else {
        formValid = true;
    }
}

//Function to write the Registration success on the page
function createNewParagraph(content){
    var text = document.createTextNode(content);
    var paragraph = document.createElement("p");
    paragraph.appendChild(text);
    paragraph.style = "white-space: pre;"
    paragraph.id = "hiddenParagraph";

    var element = document.getElementById("hiddenSection");
    var existingParagraph = document.getElementById("hiddenParagraph")
    element.replaceChild(paragraph, existingParagraph);
}

//Function  to submit the form, this should be called by the Register button
//on click
function submitForm(){
    readForm();
    validateForm();
    if (formValid){
        var formText = formData.username +" registered as:\n";
        formText += formData.buyer?"buyer\n":"";
        formText += formData.seller?"seller":"";

        console.log(formText);
        createNewParagraph(formText);
    }
}
